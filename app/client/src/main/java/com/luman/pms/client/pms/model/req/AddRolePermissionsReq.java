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
 */
@Data
public class AddRolePermissionsReq {

    private Long id;

    private List<Long> permissionIds;
}
