package com.hikarukimi.shortLink.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hikarukimi.shortLink.Result;
import com.hikarukimi.shortLink.constant.RedisConstant;
import com.hikarukimi.shortLink.entity.User;
import com.hikarukimi.shortLink.entity.UserInfoHolder;
import com.hikarukimi.shortLink.entity.dto.UserDto;
import com.hikarukimi.shortLink.dao.mapper.UserMapper;
import com.hikarukimi.shortLink.service.UserService;
import lombok.RequiredArgsConstructor;
import org.redisson.api.RBloomFilter;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import java.util.concurrent.TimeUnit;

/**
* @author Hikarukimi
* @description 针对表【user】的数据库操作Service实现
*/
@RequiredArgsConstructor
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
    implements UserService {

    private final StringRedisTemplate redisTemplate;
    private final RBloomFilter<String> userBloomFilter;
    private final RedissonClient redissonClient;

    @Override
    public User getUserByUsername(String username) {
        return baseMapper.selectOne(new LambdaQueryWrapper<User>().eq(User::getUsername, username));
    }

    @Override
    public boolean availableUsername(String username) {
        return !userBloomFilter.contains(username);
    }

    @Override
    public void register(UserDto userDto) {

        if (!availableUsername(userDto.getUsername())) {
            throw new RuntimeException("用户名已存在");
        }

        RLock lock = redissonClient.getLock(RedisConstant.USERNAME_ALREADY_EXIST_KEY.getKeyName() +userDto.getUsername());
        if(!lock.tryLock()){
            throw new RuntimeException("获取锁失败");
        }
        try {
            if (save(userDto.toEntity())) {
                userBloomFilter.add(userDto.getUsername());
            }else{
                throw new RuntimeException("注册失败");
            }
        }finally {
            lock.unlock();
        }

    }

    @Override
    public Result login(UserDto userDto) {
        String key = RedisConstant.USER_TOKEN_KEY.getKeyName()+ userDto.getUsername();
        String alreadyLogin=redisTemplate.opsForValue().get(key);

        if (alreadyLogin != null&&!alreadyLogin.isEmpty()){
            return Result.ok("用户已登录");
        }

        User one = getOne(new LambdaQueryWrapper<User>().eq(User::getUsername, userDto.getUsername())
                .eq(User::getPassword, userDto.getPassword()).eq(User::getDelFlag, 0));
        if (one == null){
            return Result.fail("用户名或密码错误");
        }
        redisTemplate.opsForValue().set(key, String.valueOf(one.getId()));
        redisTemplate.expire(key, 30, TimeUnit.MINUTES);
        return Result.ok(userDto.getUsername());
    }

    @Override
    public Result checkLogin(String username) {
        String key = RedisConstant.USER_TOKEN_KEY.getKeyName() + username;
        Boolean isLogin = redisTemplate.hasKey(key);

        return Boolean.TRUE.equals(isLogin) ? Result.ok("已登录") : Result.fail("未登录");
    }

    @Override
    public Result logOut(UserDto userDto) {
        if (Boolean.FALSE.equals(redisTemplate.hasKey(RedisConstant.USER_TOKEN_KEY + userDto.getUsername()))){
            return Result.fail("用户未登录");
        }
        redisTemplate.delete(RedisConstant.USER_TOKEN_KEY + userDto.getUsername());
        UserInfoHolder.removeUserInfo();
        return Result.ok("退出成功");
    }
}




