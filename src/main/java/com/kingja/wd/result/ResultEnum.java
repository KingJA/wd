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
    SHOULD_LOGIN(444, "用户未登录"),
    ORDER_OWNER_ERROR(18, "查询openid不一致");
    private Integer code;
    private String msg;

    ResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
