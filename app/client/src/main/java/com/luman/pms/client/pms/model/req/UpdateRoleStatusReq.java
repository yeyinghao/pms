/*
 * Copyright (c) Ye Yinghao
 * 2022.1 - 2024.1
 */

package com.luman.pms.client.pms.model.req;

import lombok.Data;

/**
 * 更新角色
 *
 * @author dhb
 * @date 2024/04/20
 */
@Data
public class UpdateRoleStatusReq {

	/**
	 * id
	 */
	private Long id;

	/**
	 * 启用
	 */
	private Boolean enable;

}
