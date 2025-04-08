package com.hikarukimi.shortLink.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import main.java.com.hikarukimi.shortLink.entity.Base;

/**
 * 
 * @author Hikarukimi
 * @TableName t_group
 */
@EqualsAndHashCode(callSuper = true)
@TableName(value ="t_group")
@Data
public class Group extends Base implements Serializable {
    /**
     * ID
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 分组标识
     */
    private String gid;

    /**
     * 分组名称
     */
    private String name;

    /**
     * 创建分组用户名
     */
    private String username;

    /**
     * 分组排序
     */
    private Integer sortOrder;

}