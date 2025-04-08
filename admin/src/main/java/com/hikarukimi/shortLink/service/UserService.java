package com.hikarukimi.shortLink.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hikarukimi.shortLink.Result;
import com.hikarukimi.shortLink.entity.User;
import com.hikarukimi.shortLink.entity.dto.UserDto;

/**
* @author Hikarukimi
* @description 针对表【user】的数据库操作Service
*/
public interface UserService extends IService<User> {
    User getUserByUsername(String username);

    boolean availableUsername(String username);

    void register(UserDto userDto);

    Result login(UserDto userDto);

    Result checkLogin(String username);

    Result logOut(UserDto userDto);
}
