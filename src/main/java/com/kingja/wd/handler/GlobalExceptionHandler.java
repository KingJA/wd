package com.kingja.wd.handler;

import com.kingja.wd.exception.ResponseException;
import com.kingja.wd.exception.ApiException;
import com.kingja.wd.result.ApiResult;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Description：TODO
 * Create Time：2018/1/12 13:33
 * Author:KingJA
 * Email:kingjavip@gmail.com
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = ApiException.class)
    @ResponseBody
    public ApiResult handlerSellerException(ApiException e) {
        return ApiResult.error(e.getCode(), e.getMessage());
    }

    /*直接回复状态值，比如403*/
    @ExceptionHandler(value = ResponseException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public void handlerResponseException() {
    }

//    @ExceptionHandler(value = AuthorizeException.class)
//    public ModelAndView handlerAuthorizeException() {
//        //http://kingja.nat300.top/sell/wechat/qrAuthorize?returnUrl=http://kingja.nat300.top/sell/seller/login
//        return new ModelAndView("redirect:"
//                .concat(projectUrlConfig.getWechatOpenAuthorize())
//                .concat("/sell/wechat/qrAuthorize")
//                .concat("?returnUrl=")
//                .concat(projectUrlConfig.getSell())
//                .concat("/sell/seller/login")
//        );
//    }

}
