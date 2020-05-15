package com.kingja.wd.dao;

import com.kingja.wd.entity.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

/**
 * Description：TODO
 * Create Time：2018/1/10 14:26
 * Author:KingJA
 * Email:kingjavip@gmail.com
 */
@Transactional
public interface UserDao extends JpaRepository<User, String> {
    User findByUserId(String userId);

    User findByUsername(String username);

    User findByUsernameAndPassword(String username, String password);

    @Modifying
    @Query("update User user set user.faceUrl= :faceUrl where user.userId= :userId")
     void updateFace(@Param("userId") String userId, @Param("faceUrl") String faceUrl);
}
