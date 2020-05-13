package com.kingja.wd.entity;

import org.hibernate.annotations.DynamicUpdate;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

/**
 * Description：TODO
 * Create Time：2018/1/10 13:55
 * Author:KingJA
 * Email:kingjavip@gmail.com
 */
@Entity
@Table(name = "user")
@Data
@DynamicUpdate
public class UserT {
    @Id
    private String userId;
    private String username;
    private String password;
    private Date createTime;
    private Date updateTime;
}
