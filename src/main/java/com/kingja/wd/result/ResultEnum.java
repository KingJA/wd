package com.kingja.wd.result;

import lombok.Getter;

/**
 * Description：TODO
 * Create Time：2018/1/10 15:25
 * Author:KingJA
 * Email:kingjavip@gmail.com
 */
@Getter
public enum ResultEnum {
    LOGIN_ERROR(1, "登录失败"),
    ERROR_USER_NO_EXIST(10002, "用户不存在"),
    ERROR_USERNAME_EXIST(10003, "用户名已经注册过"),
    ERROR_ACCOUNT_EMPTY(10004, "用户名或密码不能为空"),
    ERROR_ACCOUNT(10005, "用户名或密码错误"),
    ERROR_CHANGEFACE(20001, "文件上传失败"),
    ERROR_PUBLISH(20002, "问题标题或者内容不能为空"),


    ACCESS_LIMIT_REACHED(30001, "访问过于频繁"),
    REQUEST_ILLEGAL(30002, "非法访问"),


    SHOULD_LOGIN(444, "用户未登录"),
    ORDER_OWNER_ERROR(18, "查询openid不一致");
    private Integer code;
    private String msg;

    ResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
