/*
 * Copyright (c) Ye Yinghao
 * 2022.1 - 2024.1
 */

package com.luman.pms.client.pms.model.req;

import lombok.Data;

/**
 * 更新用户信息
 *
 * @author dhb
 */
@Data
public class UpdateProfileReq {

	private Integer gender;

	private String address;

	private String email;

	private String nickName;
}
