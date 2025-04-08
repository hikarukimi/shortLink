package com.hikarukimi.shortLink.controller;

import com.hikarukimi.shortLink.Result;
import com.hikarukimi.shortLink.entity.dto.UserDto;
import com.hikarukimi.shortLink.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

/**
 * @author Hikarukimi
 */
@RequiredArgsConstructor
@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    @GetMapping("/{username}")
    public Result getByUsername(@PathVariable("username") String username) {
        return Result.ok(UserDto.fromEntity(userService.getUserByUsername(username)));
    }
    @GetMapping("/availableUsername/{username}")
    public Result availableUsername(@PathVariable("username") String username) {
        return Result.ok(userService.availableUsername(username));
    }
    @PostMapping()
    public Result register(@RequestBody UserDto userDto) {
        userService.register(userDto);
        return Result.ok();
    }
    @PostMapping("/login")
    public Result login(@RequestBody UserDto userDto) {
        return userService.login(userDto);
    }

    @GetMapping("/checkLogin/{username}")
    public Result checkLogin(@PathVariable("username")String username) {
        return userService.checkLogin(username);
    }

    @DeleteMapping("/logOut")
    public Result logOut(@RequestBody UserDto userDto) {
        return userService.logOut(userDto);
    }



}

