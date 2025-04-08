package com.hikarukimi.shortLink.web;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author Hikarukimi
 */
@RequiredArgsConstructor
@Configuration
public class WebConfig implements WebMvcConfigurer {

    private final StringRedisTemplate redisTemplate;
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        UserTokenInterceptor userTokenInterceptor = new UserTokenInterceptor(redisTemplate);
        registry.addInterceptor(userTokenInterceptor)
                .addPathPatterns("/**")
                .excludePathPatterns("/users", "/users/login");
    }
}
