package com.kingja.wd.dao;

import com.kingja.wd.entity.Question;
import com.kingja.wd.vo.QuestionDetailVo;

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
public interface QuestionDao extends JpaRepository<Question, String> {

//    SELECT u.username,u.face_url, q.title,q.content FROM question q LEFT JOIN user u ON u.user_id=q.user_id
//    WHERE q.question_id='046f7effe4314f1198da379b7b2135b8'


//    @Query("select new com.kingja.wd.vo.QuestionDetailVo(u.userId,u.username,u.faceUrl, q.questionId, q.title,q.content,q.resUrl,q.createTime,q.updateTime) " +
//            "FROM Question q,User u WHERE q.question_id= :questionId AND u.user_id=q.user_id")
//   List<QuestionDetailVo>  getQuestionDetail(@Param("questionId") String  questionId);

    @Query("select new com.kingja.wd.vo.QuestionDetailVo(u.userId,u.username,u.faceUrl,q.questionId, q.title,q.content,q.resUrl,q.createTime,q.updateTime) " +
            "FROM Question q LEFT JOIN User u ON u.userId=q.userId WHERE q.questionId= :questionId ")
    QuestionDetailVo  getQuestionDetail(@Param("questionId") String  questionId);

//    @Query(value = "SELECT u.user_id as userId,u.username,u.face_url as faceUrl, q.question_id as questionId, q.title,q.content,q.res_url as resUrl,q.create_time as createTime,q.update_time as updateTime FROM question q LEFT JOIN user u ON u.user_id=q" +
//            ".user_id WHERE q.question_id=:questionId",nativeQuery = true)
//    QuestionDetailVo  getQuestionDetail(@Param("questionId") String  questionId);
}
