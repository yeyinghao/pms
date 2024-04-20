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
 * @date 2024/04/20
 */
@Data
public class UpdateProfileReq {

	/**
	 * 性别
	 */
	private Integer gender;

	/**
	 * 地址
	 */
	private String address;

	/**
	 * 电子邮件
	 */
	private String email;

	/**
	 * 尼克名称
	 */
	private String nickName;
}
