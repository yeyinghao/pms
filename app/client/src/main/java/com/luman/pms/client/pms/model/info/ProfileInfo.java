/*
 * Copyright (c) Ye Yinghao
 * 2022.1 - 2024.1
 */

package com.luman.pms.client.pms.model.info;

import lombok.Data;

/**
 * 用户信息
 *
 * @author dhb
 * @date 2024/04/20
 */
@Data
public class ProfileInfo {

    /**
     * id
     */
    private Long id;

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

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 昵称
     */
    private String nickName;

}
