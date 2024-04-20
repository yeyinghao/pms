/*
 * Copyright (c) Ye Yinghao
 * 2022.1 - 2024.1
 */

package com.luman.pms.client.pms.model.info;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

/**
 * 用户详细信息
 *
 * @author dhb
 * @date 2024/04/20
 */
@Data
public class UserDetailInfo {

    /**
     * id
     */
    private Long id;

    /**
     * 用户名称
     */
    private String userName;

    /**
     * 启用
     */
    private Boolean enable;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;

    /**
     * 电流作用
     */
    private RoleInfo currentRole;

    /**
     * 配置文件
     */
    private ProfileInfo profile;

    /**
     * 角色
     */
    private List<RoleInfo> roles;

}
