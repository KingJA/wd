package com.kingja.wd.controller;

import com.kingja.wd.access.AccessLimit;
import com.kingja.wd.entity.Question;
import com.kingja.wd.exception.ApiException;
import com.kingja.wd.redis.RedisService;
import com.kingja.wd.result.ApiResult;
import com.kingja.wd.result.ResultEnum;
import com.kingja.wd.service.CommentService;
import com.kingja.wd.service.QuestionService;
import com.kingja.wd.service.UserService;
import com.kingja.wd.threepart.qiniuyun.QiniuUpload;
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
import org.springframework.web.multipart.MultipartFile;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/question")
@Slf4j
public class QuestionController {

    @Autowired
    QuestionService questionService;
    @Autowired
    RedisService redisService;

    @Autowired
    CommentService commentService;


    @PostMapping("/publish")
    @ResponseBody
    @AccessLimit()
    public ApiResult publish(@RequestParam(value = "file", required = false) MultipartFile file, Question question,
                             String userId) {
        String title = question.getTitle();
        String content = question.getContent();
        log.error(title + " " + content);
        log.error("isEmpty: " + (file == null));
        if (StringUtils.isEmpty(title) || StringUtils.isEmpty(content)) {
            throw new ApiException(ResultEnum.ERROR_PUBLISH);
        }
        /*存储到七牛云*/
        if (file != null && !file.isEmpty()) {
            String imgUrl = "";
            try {
                imgUrl = QiniuUpload.updateFile(file, file.getOriginalFilename());
                question.setResUrl(imgUrl);
            } catch (Exception e) {
                log.error(e.toString());
                throw new ApiException(ResultEnum.ERROR_CHANGEFACE);
            }
        }
        question.setQuestionId(UUIDUtil.uuid());
        question.setUserId(userId);
        questionService.publishQuestion(question);
        return ApiResult.success("发布成功");
    }

    @GetMapping("/questions")
    @ResponseBody
    public ApiResult getQuestions(@RequestParam int pageIndex, @RequestParam int pageSize) {
        log.error(pageIndex + " | " + pageSize);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return ApiResult.success(questionService.getQuestions(pageIndex, pageSize));
    }

    @GetMapping("/search")
    @ResponseBody
    public ApiResult searchQuestions(@RequestParam("keyword") String keyword, @RequestParam int pageIndex,
                                     @RequestParam int pageSize) {
        log.error(pageIndex + " | " + pageSize);
        return ApiResult.success(questionService.searchQuestion(keyword, pageIndex, pageSize));
    }

    @GetMapping("/collected")
    @ResponseBody
    public ApiResult getCollectedQuestions(String userId, @RequestParam int pageIndex, @RequestParam int pageSize) {
        log.error(pageIndex + " | " + pageSize);
        return ApiResult.success(questionService.getCollectedQuestions(userId, pageIndex, pageSize));
    }

    @GetMapping("/detail")
    @ResponseBody
    public ApiResult getQuestionDetail(@RequestParam("questionId") String questionId, String userId) {
        log.error(" questionId:" + questionId + " userId:" + userId);
        return ApiResult.success(questionService.getQuestionDetail(userId, questionId));
    }

    @PostMapping("/collectQuestion")
    @ResponseBody
    @AccessLimit()
    public ApiResult collectQuestion(String userId, @RequestParam("questionId") String questionId, @RequestParam(
            "collected") boolean collected) {
        log.error(" userId:" + userId + " questionId:" + questionId + " collected:" + collected);
        if (!collected) {
            questionService.collectQuestion(userId, questionId);
        } else {
            questionService.cancelCollectQuestion(userId, questionId);
        }
        return ApiResult.success(!collected);
    }

    @PostMapping("/comment")
    @ResponseBody
    @AccessLimit()
    public ApiResult comment(String userId, @RequestParam("questionId") String questionId,
                             @RequestParam("content") String content) {
        log.error(" userId:" + userId + " questionId:" + questionId + " collected:" + content);
        commentService.comment(userId, questionId, content);
        return ApiResult.success("评论成功");
    }

}
