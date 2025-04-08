package com.hikarukimi.shortLink.entity.dto;

import java.io.Serializable;
import java.util.Date;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.hikarukimi.shortLink.entity.User;
import com.hikarukimi.shortLink.util.PhoneAnonymization;
import lombok.Data;
import org.springframework.beans.BeanUtils;

/**
 *
 * @author Hikarukimi
 */
@Data
public class UserDto implements Serializable {

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
    @JsonSerialize(using = PhoneAnonymization.class)
    private String phone;

    /**
     * 邮箱
     */
    private String mail;

    /**
     * 注销时间戳
     */
    private Long deletionTime;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 修改时间
     */
    private Date updateTime;

    public static UserDto fromEntity(User user) {
        UserDto userDto = new UserDto();
        BeanUtils.copyProperties(user, userDto);
        return userDto;
    }
    public User toEntity() {
        User user = new User();
        BeanUtils.copyProperties(this, user);
        return user;
    }
}