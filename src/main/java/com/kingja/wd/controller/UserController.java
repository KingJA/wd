package com.kingja.wd.controller;

import com.kingja.wd.entity.UserT;
import com.kingja.wd.exception.ApiException;
import com.kingja.wd.result.ApiResult;
import com.kingja.wd.result.ResultEnum;
import com.kingja.wd.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/user")
    @ResponseBody
    public ApiResult exception() {
        UserT user = userService.findByUserId("1");
        if (user == null) {
            throw new ApiException(ResultEnum.ERROR_USER_NO_EXIST);
        }
        return ApiResult.success(user);
    }

}
