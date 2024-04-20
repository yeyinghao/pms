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
 * @date 2024/04/20
 */
@Data
public class RegisterUserProfileInfo {

    /**
     * 昵称
     */
    private String nickName;

    /**
     * 性别
     */
    private Integer gender;

    /**
     * 头像
     */
    private String avatar;

    /**
     * 地址
     */
    private String address;

    /**
     * 电子邮件
     */
    private String email;


}
