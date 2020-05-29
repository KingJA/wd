package com.kingja.wd.service.impl;

import com.kingja.wd.dao.CollectDao;
import com.kingja.wd.dao.QuestionDao;
import com.kingja.wd.entity.Collect;
import com.kingja.wd.entity.Question;
import com.kingja.wd.service.QuestionService;
import com.kingja.wd.vo.QuestionDetailVo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

import lombok.extern.slf4j.Slf4j;

/**
 * Description:TODO
 * Create Time:2020/5/13 0013 下午 4:51
 * Author:KingJA
 * Email:kingjavip@gmail.com
 */
@Service
@Slf4j
public class QuestionServiceImpl implements QuestionService {
    @Autowired
    QuestionDao questionDao;
    @Autowired
    CollectDao collectDao;

    @Override
    public void publishQuestion(Question question) {
        questionDao.save(question);
    }

    @Override
    public List<Question> getQuestions(int pageIndex, int pageSize) {
        PageRequest pageable = PageRequest.of(pageIndex, pageSize, Sort.Direction.DESC, "createTime");
        return questionDao.findAll(pageable).getContent();
    }

    @Override
    public QuestionDetailVo getQuestionDetail(String userId, String questionId) {
        QuestionDetailVo questionDetail = questionDao.getQuestionDetail(questionId);
        questionDetail.setCollected(userId != null && isCollected(userId, questionId));
        return questionDetail;
    }

    @Override
    public boolean isCollected(String userId, String questionId) {
        return collectDao.countByUserIdAndQuestionId(userId, questionId) > 0;
    }

    @Override
    public void collectQuestion(String userId, String questionId) {
        collectDao.save(new Collect(userId, questionId));
    }

    @Override
    public void cancelCollectQuestion(String userId, String questionId) {
        collectDao.deleteCollectByUserIdAndQuestionId(userId, questionId);
    }
}
