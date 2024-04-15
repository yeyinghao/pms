/*
 * Copyright (c) Ye Yinghao
 * 2022.1 - 2024.1
 */

package com.luman.pms.client.pms.dto.info;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

/**
 * 用户详细信息
 *
 * @author dhb
 */
@Data
public class UserDetailInfo {

    private Long id;

    private String userName;

    private Boolean enable;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;

    private RoleInfo currentRole;

    private ProfileInfo profile;

    private List<RoleInfo> roles;

}
