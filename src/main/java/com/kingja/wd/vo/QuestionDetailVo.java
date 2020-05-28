package com.kingja.wd.vo;

import lombok.Data;

/**
 * Description：TODO
 * Create Time：2018/1/10 13:55
 * Author:KingJA
 * Email:kingjavip@gmail.com
 */
@Data
public class QuestionDetailVo {
    /*用户相关*/

    private String userId;
    private String username;
    private String faceUrl;

    /*问题相关*/

    private String questionId;
    private String title;
    private String content;
    private String resUrl;
    private String createTime;
    private String updateTime;

    public QuestionDetailVo(String userId, String username, String faceUrl, String questionId, String title,
                            String content, String resUrl, String createTime, String updateTime) {
        this.userId = userId;
        this.username = username;
        this.faceUrl = faceUrl;
        this.questionId = questionId;
        this.title = title;
        this.content = content;
        this.resUrl = resUrl;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }
}
