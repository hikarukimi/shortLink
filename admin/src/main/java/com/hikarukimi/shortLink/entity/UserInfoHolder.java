package com.hikarukimi.shortLink.entity;

import com.alibaba.ttl.TransmittableThreadLocal;

/**
 * @author Hikarukimi
 */

public class UserInfoHolder {
    private static final ThreadLocal<User> USER_INFO_HOLDER = new TransmittableThreadLocal<>();

    public static void setUserInfo(User userInfo) {
        USER_INFO_HOLDER.set(userInfo);
    }

    public static User getUserInfo() {
        return USER_INFO_HOLDER.get();
    }

    public static void removeUserInfo() {
        USER_INFO_HOLDER.remove();
    }
    public static Long getUserId() {
        return USER_INFO_HOLDER.get().getId();
    }
    public static String getUsername() {
        return USER_INFO_HOLDER.get().getUsername();
    }
}
