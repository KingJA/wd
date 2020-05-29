package com.kingja.wd.service.impl;

import com.kingja.wd.dao.CommentDao;
import com.kingja.wd.dao.UserDao;
import com.kingja.wd.entity.Comment;
import com.kingja.wd.entity.User;
import com.kingja.wd.exception.ApiException;
import com.kingja.wd.result.ResultEnum;
import com.kingja.wd.service.CommentService;
import com.kingja.wd.service.UserService;
import com.kingja.wd.util.MD5Util;
import com.kingja.wd.util.UUIDUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

import lombok.extern.slf4j.Slf4j;

/**
 * Description:TODO
 * Create Time:2020/5/13 0013 下午 4:51
 * Author:KingJA
 * Email:kingjavip@gmail.com
 */
@Service
@Slf4j
public class CommentServiceImpl implements CommentService {
    @Autowired
    CommentDao commentDao;

    @Override
    public void comment(String userId, String questionId, String content) {
        Comment comment = new Comment();
        comment.setUserId(userId);
        comment.setQuestionId(questionId);
        comment.setContent(content);
        commentDao.save(comment);
    }
}
