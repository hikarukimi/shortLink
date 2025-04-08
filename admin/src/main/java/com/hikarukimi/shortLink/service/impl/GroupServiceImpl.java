package com.hikarukimi.shortLink.service.impl;

import cn.hutool.core.util.RandomUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hikarukimi.shortLink.Result;
import com.hikarukimi.shortLink.dao.mapper.GroupMapper;
import com.hikarukimi.shortLink.entity.Group;
import com.hikarukimi.shortLink.entity.UserInfoHolder;
import com.hikarukimi.shortLink.service.GroupService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author Hikarukimi
* @description 针对表【group】的数据库操作Service实现
*/
@Service
public class GroupServiceImpl extends ServiceImpl<GroupMapper, Group>
    implements GroupService {

    @Override
    public Result add(Group group) {
        String gid;
        LambdaQueryWrapper<Group> groupLambdaQueryWrapper;
        do{
            gid= RandomUtil.randomString(6);
            groupLambdaQueryWrapper=new LambdaQueryWrapper<Group>().eq(Group::getGid,gid);
        }while(count(groupLambdaQueryWrapper)>0);
        group.setGid(gid);
        group.setUsername(UserInfoHolder.getUsername());
        save(group);
        return Result.ok();
    }

    @Override
    public Result sort(List<Group> groups) {
        groups.forEach(group -> {
            update(group,new LambdaUpdateWrapper<Group>().eq(Group::getDelFlag,0).eq(Group::getUsername, UserInfoHolder.getUsername()));
        });
        return Result.ok();
    }
}




