package com.kingja.wd.dao;

import com.kingja.wd.entity.Collect;

import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

/**
 * Description：TODO
 * Create Time：2018/1/10 14:26
 * Author:KingJA
 * Email:kingjavip@gmail.com
 */
@Transactional
public interface CollectDao extends JpaRepository<Collect, String> {


    int countByUserIdAndQuestionId(String userId, String questionId);
    int deleteCollectByUserIdAndQuestionId(String userId, String questionId);

}
