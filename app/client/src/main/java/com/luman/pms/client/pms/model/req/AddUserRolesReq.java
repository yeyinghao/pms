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
 * @date 2024/04/20
 */
@Data
public class AddUserRolesReq {

    /**
     * id
     */
    private Long id;

    /**
     * 角色id
     */
    private List<Long> roleIds;

}
