/*
 * Copyright (c) Ye Yinghao
 * 2022.1 - 2024.1
 */

package com.luman.pms.client.pms.dto.req;

import com.luman.pms.client.pms.dto.info.RegisterUserProfileInfo;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import java.util.List;

/**
 * 注册用户
 *
 * @author dhb
 */
@Data
public class RegisterUserReq {

    @Length(min = 6, max = 20, message = "用户名长度必须是6到20之间")
    private String userName;

    @Length(min = 6, max = 20, message = "密码长度必须是6到20之间")
    private String password;

    private Boolean enable;

    private RegisterUserProfileInfo profile;

    private List<Long> roleIds;


}
