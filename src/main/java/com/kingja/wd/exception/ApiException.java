package com.kingja.wd.exception;

import com.kingja.wd.result.ResultEnum;

import lombok.Getter;

/**
 * Description：TODO
 * Create Time：2018/1/10 15:26
 * Author:KingJA
 * Email:kingjavip@gmail.com
 */
@Getter
public class ApiException extends RuntimeException {
    private Integer code;

    public ApiException(ResultEnum resultEnum) {
        super(resultEnum.getMsg());
        this.code = resultEnum.getCode();
    }

    public ApiException(Integer code, String msg) {
        super(msg);
        this.code = code;
    }
}
