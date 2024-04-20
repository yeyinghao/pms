/*
 * Copyright (c) Ye Yinghao
 * 2022.1 - 2024.1
 */

package com.luman.pms.client.pms.model.req;

import com.luman.pms.client.pms.model.info.RegisterUserProfileInfo;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import java.util.List;

/**
 * 注册用户
 *
 * @author dhb
 * @date 2024/04/20
 */
@Data
public class RegisterUserReq {

    /**
     * 用户名称
     */
    @Length(min = 6, max = 20, message = "用户名长度必须是6到20之间")
    private String userName;

    /**
     * 密码
     */
    @Length(min = 6, max = 20, message = "密码长度必须是6到20之间")
    private String password;

    /**
     * 启用
     */
    private Boolean enable;

    /**
     * 配置文件
     */
    private RegisterUserProfileInfo profile;

    /**
     * 角色id
     */
    private List<Long> roleIds;


}
