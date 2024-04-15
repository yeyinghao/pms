/*
 * Copyright (c) Ye Yinghao
 * 2022.1 - 2024.1
 */

package com.luman.pms.client.pms.dto.info;

import lombok.Data;

/**
 * 用户信息
 *
 * @author dhb
 */
@Data
public class ProfileInfo {

    private Long id;

    private Long bizId;

    private Integer gender;

    private String avatar;

    private String address;

    private String email;

    private Long userId;

    private String nickName;

}
