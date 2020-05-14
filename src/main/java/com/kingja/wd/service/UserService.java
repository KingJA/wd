package com.kingja.wd.service;

import com.kingja.wd.entity.User;

/**
 * Description:TODO
 * Create Time:2020/5/13 0013 下午 4:50
 * Author:KingJA
 * Email:kingjavip@gmail.com
 */

public interface UserService {
    User findByUserId(String userId);

    void register(User user);

    User login(User user);

    void updateUserInfo(User user);
}
