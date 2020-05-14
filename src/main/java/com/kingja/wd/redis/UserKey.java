package com.kingja.wd.redis;

public class UserKey extends BasePrefix {


    private UserKey(int expireSeconds, String prefix) {
        super(expireSeconds, prefix);
    }

    public static UserKey getById = new UserKey(60 * 60 * 24 * 7, "id");
    public static UserKey getByName = new UserKey(300, "name");
}
