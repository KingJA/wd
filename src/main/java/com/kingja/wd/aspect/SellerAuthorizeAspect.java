package com.kingja.wd.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

import lombok.extern.slf4j.Slf4j;

/**
 * Description：TODO
 * Create Time：2018/1/20 11:11
 * Author:KingJA
 * Email:kingjavip@gmail.com
 */
@Aspect
@Component
@Slf4j
public class SellerAuthorizeAspect {

    @Pointcut("execution(public * com.kingja.wd.controller.User*.*(..)))")
    public void verify(){}

    @Before("verify()")
    public void doVerify() {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
    }

}
