package com.hikarukimi.shortLink.entity;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serial;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import main.java.com.hikarukimi.shortLink.entity.Base;

/**
 * 
 * @author Hikarukimi
 * @TableName t_user
 */
@EqualsAndHashCode(callSuper = true)
@TableName(value ="t_user")
@Data
public class User extends Base implements Serializable {
    /**
     * ID
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 真实姓名
     */
    private String realName;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 邮箱
     */
    private String mail;

    /**
     * 注销时间戳
     */
    private Long deletionTime;


    @Serial
    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

}