package com.kingja.wd.entity;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;

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
public class User {
    @Id
    private String userId;
    private String username;
    private String password;
    private String faceUrl;
//    @CreatedDate
//    private Date createTime;
//    @LastModifiedDate
//    private Date updateTime;
}
