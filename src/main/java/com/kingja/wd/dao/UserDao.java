package com.kingja.wd.dao;

import com.kingja.wd.entity.UserT;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Description：TODO
 * Create Time：2018/1/10 14:26
 * Author:KingJA
 * Email:kingjavip@gmail.com
 */
public interface UserDao extends JpaRepository<UserT, String> {
    UserT findByUserId(String userId);
}
