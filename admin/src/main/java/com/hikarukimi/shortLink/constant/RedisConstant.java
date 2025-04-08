package com.hikarukimi.shortLink.constant;

import lombok.Getter;

/**
 * @author Hikarukimi
 */

@Getter
public enum RedisConstant {
    USERNAME_ALREADY_EXIST_KEY("user:username_already_exist:"),
    USER_TOKEN_KEY("login_user_token:");

    private final String keyName;

    RedisConstant(String keyName) {
        this.keyName = keyName;
    }
}