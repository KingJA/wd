package com.kingja.wd.service.impl;

import com.kingja.wd.dao.UserDao;
import com.kingja.wd.entity.User;
import com.kingja.wd.exception.ApiException;
import com.kingja.wd.result.ResultEnum;
import com.kingja.wd.service.UserService;
import com.kingja.wd.util.MD5Util;
import com.kingja.wd.util.UUIDUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

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
public class UserServiceImpl implements UserService {
    @Autowired
    UserDao userDao;

    @Override
    public User findByUserId(String userId) {
        return userDao.findByUserId(userId);
    }

    @Transactional
    @Override
    public void register(User user) {
        User result = userDao.findByUsername(user.getUsername());
        //已经存在
        if (result != null) {
            throw new ApiException(ResultEnum.ERROR_USERNAME_EXIST);
        }
        //进行注册
        user.setUserId(UUIDUtil.uuid());
        user.setUsername(user.getUsername());
        user.setPassword(MD5Util.md5(user.getPassword()));
        userDao.save(user);
    }

    @Override
    public User login(User user) {
        User result = userDao.findByUsernameAndPassword(user.getUsername(), MD5Util.md5(user.getPassword()));
        if (result == null) {
            throw new ApiException(ResultEnum.ERROR_ACCOUNT);
        }

        return result;
    }

    @Override
    public void updateUserInfo(User user) {
        userDao.updateFace(user.getUserId(),user.getFaceUrl());
    }
}
