package com.kingja.wd.service.impl;

import com.kingja.wd.dao.UserDao;
import com.kingja.wd.entity.UserT;
import com.kingja.wd.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public UserT findByUserId(String userId) {
        return userDao.findByUserId(userId);
    }
}
