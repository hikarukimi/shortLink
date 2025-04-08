package com.hikarukimi.shortLink.dao;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author Hikarukimi
 */
@Component
public class DefaultFiledHandler implements MetaObjectHandler {
    @Override
    public void insertFill(MetaObject metaObject) {
        strictInsertFill(metaObject,"createTime",Date::new,Date.class);
        strictInsertFill(metaObject,"updateTime",Date::new,Date.class);
        strictInsertFill(metaObject,"delFlag",Integer.class,0);
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        strictUpdateFill(metaObject,"updateTime",Date::new,Date.class);
    }
}
