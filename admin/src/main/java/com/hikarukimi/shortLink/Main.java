package com.hikarukimi.shortLink;

import org.mybatis.spring.annotation.MapperScan;
import org.redisson.api.RBloomFilter;
import org.redisson.api.RedissonClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * @author Hikarukimi
 */
@SpringBootApplication
@MapperScan("com.hikarukimi.shortLink.dao.mapper")
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @Bean
    public RBloomFilter<String> usernameBloomFilter(RedissonClient redissonClient){
        RBloomFilter<String> usernameBloomFilter = redissonClient.getBloomFilter("usernameBloomFilter");
        usernameBloomFilter.tryInit(10000000,0.01);
        return usernameBloomFilter;
    }
}