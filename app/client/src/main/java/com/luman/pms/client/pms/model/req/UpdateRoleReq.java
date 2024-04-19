/*
 * Copyright (c) Ye Yinghao
 * 2022.1 - 2024.1
 */

package com.luman.pms.client.pms.model.req;

import lombok.Data;

import java.util.List;

/**
 * 更新角色
 *
 * @author dhb
 */
@Data
public class UpdateRoleReq {

	private Long id;

	private String code;

	private String name;

	private Boolean enable;

	private List<Long> permissionIds;


}
