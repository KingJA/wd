package com.kingja.wd.service;

import com.kingja.wd.entity.Question;

import org.springframework.data.domain.Page;

import java.util.List;


/**
 * Description:TODO
 * Create Time:2020/5/13 0013 下午 4:50
 * Author:KingJA
 * Email:kingjavip@gmail.com
 */

public interface QuestionService {

    void publishQuestion(Question question);

    List<Question> getQuestions(int pageIndex, int pageSize);
}
