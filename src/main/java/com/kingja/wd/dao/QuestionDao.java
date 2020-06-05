package com.kingja.wd.dao;

import com.kingja.wd.entity.Question;
import com.kingja.wd.vo.QuestionDetailVo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
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
public interface QuestionDao extends JpaRepository<Question, String> {

    @Query("select new com.kingja.wd.vo.QuestionDetailVo(u.userId,u.username,u.faceUrl,q.questionId, q.title,q.content,q.resUrl,q.createTime,q.updateTime) " +
            "FROM Question q LEFT JOIN User u ON u.userId=q.userId WHERE q.questionId= :questionId ")
    QuestionDetailVo  getQuestionDetail(@Param("questionId") String  questionId);


    int countByUserIdAndQuestionId(String userId,String questionId);

    @Query(value = "SELECT * from question where title like %?1%",nativeQuery = true)
    Page<Question> searchQuestion(String keyword, PageRequest pageRequest);

}
