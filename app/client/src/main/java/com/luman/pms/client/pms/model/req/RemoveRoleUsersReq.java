/*
 * Copyright (c) Ye Yinghao
 * 2022.1 - 2024.1
 */

package com.luman.pms.client.pms.model.req;

import lombok.Data;

import java.util.List;

/**
 * 给角色分配用户
 *
 * @author dhb
 */
@Data
public class RemoveRoleUsersReq {

	private Long id;

	private List<Long> userIds;

}
