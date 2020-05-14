package com.kingja.wd.controller;

import com.kingja.wd.exception.ApiException;
import com.kingja.wd.redis.RedisService;
import com.kingja.wd.redis.UserKey;
import com.kingja.wd.result.ApiResult;
import com.kingja.wd.result.ResultEnum;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class SampleController {

    @Autowired
    RedisService redisService;


    @GetMapping("/get")
    @ResponseBody
    public ApiResult get() {
        return ApiResult.successMsg("添加成功");
    }

    @GetMapping("/exception")
    @ResponseBody
    public ApiResult exception() {
        if (true) {
            throw new ApiException(ResultEnum.LOGIN_ERROR);
        }
        return ApiResult.successMsg("添加成功");
    }

    @GetMapping("/set")
    @ResponseBody
    public ApiResult setRedis(@RequestParam("name") String name) {
        redisService.set(UserKey.getByName,"name",name);
        return ApiResult.successMsg("添加成功");
    }


    @RequestMapping("/hello")
    public String test() {
        return "hello kingja";
    }

}
