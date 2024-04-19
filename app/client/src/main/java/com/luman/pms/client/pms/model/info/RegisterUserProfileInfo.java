/*
 * Copyright (c) Ye Yinghao
 * 2022.1 - 2024.1
 */

package com.luman.pms.client.pms.model.info;

import lombok.Data;

/**
 * 注册用户的用户信息
 *
 * @author dhb
 */
@Data
public class RegisterUserProfileInfo {

    private String nickName;

    private Integer gender;

    private String avatar;

    private String address;

    private String email;


}
