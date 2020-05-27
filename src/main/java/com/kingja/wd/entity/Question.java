package com.kingja.wd.entity;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;

import lombok.Data;

/**
 * Description：TODO
 * Create Time：2018/1/10 13:55
 * Author:KingJA
 * Email:kingjavip@gmail.com
 */
@Entity
@DynamicUpdate
@DynamicInsert
@Data
@EntityListeners(AuditingEntityListener.class)
public class Question {
    @Id
    private String questionId;
    private String userId;
    private String title;
    private String content;
    private String resUrl;
    private String updateTime;
    private String createTime;
}
