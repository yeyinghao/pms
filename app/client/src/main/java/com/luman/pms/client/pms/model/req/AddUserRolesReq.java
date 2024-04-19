/*
 * Copyright (c) Ye Yinghao
 * 2022.1 - 2024.1
 */

package com.luman.pms.client.pms.model.req;

import lombok.Data;

import java.util.List;

/**
 * 给用户分配角色
 *
 * @author dhb
 */
@Data
public class AddUserRolesReq {

    private Long id;

    private List<Long> roleIds;

}
