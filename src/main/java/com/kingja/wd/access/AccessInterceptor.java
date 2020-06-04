package com.kingja.wd.access;

import com.alibaba.fastjson.JSON;
import com.kingja.wd.redis.AccessKey;
import com.kingja.wd.redis.RedisService;
import com.kingja.wd.redis.UserKey;
import com.kingja.wd.result.ApiResult;
import com.kingja.wd.result.ResultEnum;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import java.io.OutputStream;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class AccessInterceptor  extends HandlerInterceptorAdapter {
//
//	@Autowired
//	MiaoshaUserService userService;
	
	@Autowired
	RedisService redisService;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		if(handler instanceof HandlerMethod) {
			String token = request.getHeader("token");
			String userId = redisService.get(UserKey.Token, token,String.class);
			log.error("token:"+token);
			log.error("userId:"+userId);
			UserContext.setUserId(userId);
			HandlerMethod hm = (HandlerMethod)handler;
			AccessLimit accessLimit = hm.getMethodAnnotation(AccessLimit.class);
			if(accessLimit == null) {
				return true;
			}
			int seconds = accessLimit.seconds();
			int maxCount = accessLimit.maxCount();
			boolean needLogin = accessLimit.needLogin();
			String key = request.getRequestURI();
			if(needLogin) {
				if(StringUtils.isEmpty(token)) {
					render(response, ResultEnum.REQUEST_ILLEGAL);
					return false;
				}
				if(StringUtils.isEmpty(userId)) {
					render(response, ResultEnum.TOKEN_EXPIRES);
					return false;
				}

				key = token;
			}else {
				//do nothing
			}
			AccessKey ak = AccessKey.withExpire(seconds);
			Integer count = redisService.get(ak, key, Integer.class);
	    	if(count  == null) {
	    		 redisService.set(ak, key, 1);
	    	}else if(count < maxCount) {
	    		 redisService.incr(ak, key);
	    	}else {
	    		render(response, ResultEnum.ACCESS_LIMIT_REACHED);
	    		return false;
	    	}
		}
		return true;
	}

	private void render(HttpServletResponse response, ResultEnum resultEnum)throws Exception {
		response.setContentType("application/json;charset=UTF-8");
		OutputStream out = response.getOutputStream();
		String str  = JSON.toJSONString(ApiResult.error(resultEnum));
		out.write(str.getBytes("UTF-8"));
		out.flush();
		out.close();
	}

	private String getCookieValue(HttpServletRequest request, String cookiName) {
		Cookie[]  cookies = request.getCookies();
		if(cookies == null || cookies.length <= 0){
			return null;
		}
		for(Cookie cookie : cookies) {
			if(cookie.getName().equals(cookiName)) {
				return cookie.getValue();
			}
		}
		return null;
	}
	
}
