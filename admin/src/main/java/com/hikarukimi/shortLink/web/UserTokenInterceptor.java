package com.hikarukimi.shortLink.web;

import com.alibaba.fastjson2.JSON;
import com.hikarukimi.shortLink.Result;
import com.hikarukimi.shortLink.constant.RedisConstant;
import com.hikarukimi.shortLink.entity.User;
import com.hikarukimi.shortLink.entity.UserInfoHolder;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.NonNull;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.servlet.HandlerInterceptor;

import java.io.IOException;

/**
 * @author Hikarukimi
 */
public class UserTokenInterceptor implements HandlerInterceptor {

    private final StringRedisTemplate redisTemplate;

    public UserTokenInterceptor(StringRedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }
    @Override
    public boolean preHandle(HttpServletRequest request, @NonNull HttpServletResponse response,@NonNull Object handler) throws IOException {
        String authorization = request.getHeader("Authorization");
        response.setCharacterEncoding("UTF-8");
        if (authorization == null|| authorization.isEmpty()){
            response.getWriter().println(JSON.toJSONString(Result.fail("未携带token")));
            return false;
        }
        String redisKey= RedisConstant.USER_TOKEN_KEY.getKeyName()+authorization;
        String userId = redisTemplate.opsForValue().get(redisKey);
        if (userId == null||userId.isEmpty()){
            response.getWriter().println(JSON.toJSONString(Result.fail("无效的token")));
            return false;
        }
        User user = new User();
        user.setId(Long.parseLong(userId));
        user.setUsername(authorization);

        UserInfoHolder.setUserInfo(user);
        return true;
    }
}
