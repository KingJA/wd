package com.kingja.wd.dao;

import com.kingja.wd.entity.Collect;
import com.kingja.wd.entity.Comment;

import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

/**
 * Description：TODO
 * Create Time：2018/1/10 14:26
 * Author:KingJA
 * Email:kingjavip@gmail.com
 */
@Transactional
public interface CommentDao extends JpaRepository<Comment, String> {


}
