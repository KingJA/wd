package com.kingja.wd.controller;

import com.kingja.wd.entity.User;
import com.kingja.wd.exception.ApiException;
import com.kingja.wd.form.UserForm;
import com.kingja.wd.redis.RedisService;
import com.kingja.wd.redis.UserKey;
import com.kingja.wd.result.ApiResult;
import com.kingja.wd.result.ResultEnum;
import com.kingja.wd.service.UserService;
import com.kingja.wd.util.UUIDUtil;
import com.kingja.wd.vo.UserVo;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {

    @Autowired
    UserService userService;
    @Autowired
    RedisService redisService;

    @GetMapping("/user")
    @ResponseBody
    public ApiResult exception() {
        User user = userService.findByUserId("1");
        if (user == null) {
            throw new ApiException(ResultEnum.ERROR_USER_NO_EXIST);
        }
        return ApiResult.success(user);
    }

    @PostMapping("/register")
    @ResponseBody
    public ApiResult register(User user) {
        checkAccountEmpty(user);
        userService.register(user);
        UserVo userVo = getTokenBody(user);
        return ApiResult.success(userVo);
    }


    @PostMapping("/changeFace")
    @ResponseBody
    public ApiResult updateFace(@RequestParam("userId") String userId, @RequestParam("file") MultipartFile file) {
        if (file.isEmpty()) {
            throw new ApiException(ResultEnum.ERROR_CHANGEFACE);
        }
        String fileName = file.getOriginalFilename();
        // 文件保存的命名空间
        String fileSpace = "g:/wd";
        // 保存到数据库中的相对路径
        String uploadPathDB = "/" + userId + "/face";

        // 文件上传的最终保存路径
        String finalFacePath = fileSpace + uploadPathDB + "/" + fileName;
        // 设置数据库保存的路径
        uploadPathDB += ("/" + fileName);

        File outFile = new File(finalFacePath);
        if (outFile.getParentFile() != null && !outFile.getParentFile().isDirectory()) {
            // 创建父文件夹
            outFile.getParentFile().mkdirs();
        }
        try {
            file.transferTo(new File(finalFacePath));
        } catch (IOException e) {
            log.error(e.toString());
            throw new ApiException(ResultEnum.ERROR_CHANGEFACE);
        }

        User user = new User();
        user.setUserId(userId);
        user.setFaceUrl(uploadPathDB);
        userService.updateUserInfo(user);

        return ApiResult.success(uploadPathDB);
    }


    @PostMapping("/login")
    @ResponseBody
    public ApiResult login(User user) {
        checkAccountEmpty(user);
        User resultUser = userService.login(user);
        UserVo userVo = getTokenBody(resultUser);
        return ApiResult.success(userVo);
    }


    private void checkAccountEmpty(User user) {
        String username = user.getUsername();
        String password = user.getPassword();
        if (StringUtils.isEmpty(username) || StringUtils.isEmpty(password)) {
            throw new ApiException(ResultEnum.ERROR_ACCOUNT_EMPTY);
        }
        log.error(username + " " + user.getPassword());
    }

    private UserVo getTokenBody(User user) {
        String token = UUIDUtil.uuid();
        redisService.set(UserKey.getById, user.getUserId(), token);
        UserVo userVO = new UserVo();
        BeanUtils.copyProperties(user, userVO);
        userVO.setToken(token);
        return userVO;
    }

}
