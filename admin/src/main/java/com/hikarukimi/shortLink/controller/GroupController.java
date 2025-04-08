package com.hikarukimi.shortLink.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.hikarukimi.shortLink.Result;
import com.hikarukimi.shortLink.entity.Group;
import com.hikarukimi.shortLink.entity.UserInfoHolder;
import com.hikarukimi.shortLink.service.GroupService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Hikarukimi
 */
@RestController
@RequestMapping("/groups")
@RequiredArgsConstructor
public class GroupController {
    private final GroupService groupService;

    @PostMapping
    public Result add(@RequestBody Group group) {
        return groupService.add(group);
    }
    @GetMapping("/list")
    public Result list() {
        return Result.ok(groupService.list(new LambdaQueryWrapper<Group>().eq(Group::getUsername, UserInfoHolder.getUsername()).orderByDesc(Group::getSortOrder)));
    }
    @PutMapping
    public Result update(@RequestBody Group group) {
        return Result.ok(groupService.updateById(group));
    }

    /**
     *
     * @param id 基于tableLogic实现逻辑删除
     */
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Long id) {
        return Result.ok(groupService.removeById(id));
    }

    @PostMapping("/sort")
    public Result sort(@RequestBody List<Group> groups) {
        return groupService.sort(groups);
    }
}
