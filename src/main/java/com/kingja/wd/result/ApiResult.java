package com.kingja.wd.result;

import lombok.Getter;

@Getter
public class ApiResult<T> {

    private int code;
    private String msg;
    private T data;

    public static <T> ApiResult<T> success(T data) {
        return new ApiResult<>(0, "操作成功", data);
    }

    public static <T> ApiResult<T> successMsg(String message) {
        return new ApiResult<>(0, message);
    }

    public static <T> ApiResult<T> error(ResultEnum codeMsg) {
        return new ApiResult<>(codeMsg);
    }

    public static <T> ApiResult<T> error(int code, String msg) {
        return new ApiResult<>(code, msg);
    }

    private ApiResult(T data) {
        this.data = data;
    }

    private ApiResult(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    private ApiResult(int code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    private ApiResult(ResultEnum codeMsg) {
        if (codeMsg != null) {
            this.code = codeMsg.getCode();
            this.msg = codeMsg.getMsg();
        }
    }
}
