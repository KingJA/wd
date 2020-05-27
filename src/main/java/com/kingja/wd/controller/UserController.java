package com.kingja.wd.controller;

import com.kingja.wd.entity.User;
import com.kingja.wd.exception.ApiException;
import com.kingja.wd.redis.RedisService;
import com.kingja.wd.redis.UserKey;
import com.kingja.wd.result.ApiResult;
import com.kingja.wd.result.ResultEnum;
import com.kingja.wd.service.UserService;
import com.kingja.wd.threepart.qiniuyun.QiniuUpload;
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
    public ApiResult updateFace(@RequestParam("file") MultipartFile file, String userId) {
        log.error("changeFace");
        if (file.isEmpty()) {
            throw new ApiException(ResultEnum.ERROR_CHANGEFACE);
        }
        String fileName = file.getOriginalFilename();
        /*存储到七牛云*/
        String imgUrl = "";
        try {
            imgUrl = QiniuUpload.updateFile(file, fileName);
        } catch (Exception e) {
            log.error(e.toString());
            throw new ApiException(ResultEnum.ERROR_CHANGEFACE);
        }
        User user = new User();
        user.setUserId(userId);
        user.setFaceUrl(imgUrl);
        userService.updateUserInfo(user);
        return ApiResult.success(imgUrl);
    }


    @PostMapping("/login")
    @ResponseBody
    public ApiResult login(User user) {
        checkAccountEmpty(user);
        User resultUser = userService.login(user);
        UserVo userVo = getTokenBody(resultUser);
        return ApiResult.success(userVo);
    }

    @PostMapping("/quit")
    @ResponseBody
    public ApiResult quit() {
        return ApiResult.successMsg("退出登录成功");
    }


    private void checkAccountEmpty(User user) {
        String username = user.getUsername();
        String password = user.getPassword();
        log.error(username + " " + user.getPassword());
        if (StringUtils.isEmpty(username) || StringUtils.isEmpty(password)) {
            throw new ApiException(ResultEnum.ERROR_ACCOUNT_EMPTY);
        }

    }

    private UserVo getTokenBody(User user) {
        String token = UUIDUtil.uuid();
        redisService.set(UserKey.Token, token, user.getUserId());
        UserVo userVO = new UserVo();
        BeanUtils.copyProperties(user, userVO);
        userVO.setToken(token);
        return userVO;
    }

}
