package com.kingja.wd.controller;

import com.kingja.wd.access.AccessLimit;
import com.kingja.wd.entity.Question;
import com.kingja.wd.exception.ApiException;
import com.kingja.wd.redis.RedisService;
import com.kingja.wd.result.ApiResult;
import com.kingja.wd.result.ResultEnum;
import com.kingja.wd.service.QuestionService;
import com.kingja.wd.service.UserService;
import com.kingja.wd.util.UUIDUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/question")
@Slf4j
public class QuestionController {

    @Autowired
    QuestionService questionService;
    @Autowired
    RedisService redisService;


    @PostMapping("/publish")
    @ResponseBody
    @AccessLimit()
    public ApiResult updateFace(Question question,String userId) {
        String title = question.getTitle();
        String content =  question.getContent();
        log.error(title + " " + content);
        if (StringUtils.isEmpty(title) || StringUtils.isEmpty(content)) {
            throw new ApiException(ResultEnum.ERROR_PUBLISH);
        }
        question.setQuestionId(UUIDUtil.uuid());
        question.setUserId(userId);
        questionService.publishQuestion(question);
        return ApiResult.success("发布成功");
    }

    @GetMapping("/questions")
    @ResponseBody
    @AccessLimit()
    public ApiResult getQuestions(@RequestParam int pageIndex, @RequestParam int pageSize) {
        log.error(pageIndex + " | " + pageSize);
        return ApiResult.success(questionService.getQuestions(pageIndex,pageSize));
    }
}
