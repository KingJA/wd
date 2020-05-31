package com.kingja.wd.vo;

import lombok.Data;

/**
 * Description:TODO
 * Create Time:2020/5/31 22:56
 * Author:KingJA
 * Email:kingjavip@gmail.com
 */
@Data
public class CommentVo {
    private String commentId;
    private String content;
    private String createTime;
    private String userId;
    private String username;
    private String faceUrl;

    public CommentVo(String commentId, String content, String createTime, String userId, String username,
                     String faceUrl) {
        this.commentId = commentId;
        this.content = content;
        this.createTime = createTime;
        this.userId = userId;
        this.username = username;
        this.faceUrl = faceUrl;
    }
}
