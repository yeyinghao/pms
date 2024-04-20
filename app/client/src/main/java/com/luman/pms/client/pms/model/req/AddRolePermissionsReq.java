/*
 * Copyright (c) Ye Yinghao
 * 2022.1 - 2024.1
 */

package com.luman.pms.client.pms.model.req;

import lombok.Data;

import java.util.List;

/**
 * 添加角色权限
 *
 * @author dhb
 * @date 2024/04/20
 */
@Data
public class AddRolePermissionsReq {

    /**
     * id
     */
    private Long id;

    /**
     * 权限id
     */
    private List<Long> permissionIds;
}
