package com.kingja.wd.access;



public class UserContext {
	
	private static ThreadLocal<String> userHolder = new ThreadLocal<String>();
	
	public static void setUserId(String userId) {
		userHolder.set(userId);
	}
	
	public static String getUserId() {
		return userHolder.get();
	}

}
