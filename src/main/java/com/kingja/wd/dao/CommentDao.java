package com.kingja.wd.dao;

import com.kingja.wd.entity.Comment;
import com.kingja.wd.vo.CommentVo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

import javax.transaction.Transactional;

/**
 * Description：TODO
 * Create Time：2018/1/10 14:26
 * Author:KingJA
 * Email:kingjavip@gmail.com
 */
@Transactional
public interface CommentDao extends JpaRepository<Comment, String> {

    @Query("select new com.kingja.wd.vo.CommentVo(c.commentId,c.content,c.createTime,u.userId, u.username,u.faceUrl) " +
            "FROM Comment c LEFT JOIN User u ON c.userId=u.userId WHERE c.questionId= :questionId ")
    List<CommentVo> getCommentList(@Param("questionId") String questionId);


}
