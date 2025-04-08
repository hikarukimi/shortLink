package com.hikarukimi.shortLink.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.hikarukimi.shortLink.Result;
import com.hikarukimi.shortLink.entity.Group;

import java.util.List;

/**
* @author HP
* @description 针对表【t_group_0】的数据库操作Service
* @createDate 2025-03-14 10:18:34
*/
public interface GroupService extends IService<Group> {

    Result add(Group group);

    Result sort(List<Group> groups);
}
