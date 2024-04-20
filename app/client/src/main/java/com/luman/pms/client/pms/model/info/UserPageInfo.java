/*
 * Copyright (c) Ye Yinghao
 * 2022.1 - 2024.1
 */

package com.luman.pms.client.pms.model.info;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

/**
 * 用户分页数据
 *
 * @author yeyinghao
 * @date 2024/04/20
 */
@Data
public class UserPageInfo {

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
	 * 性别
	 */
	private Integer gender;

	/**
	 * 头像
	 */
	private String avatar;

	/**
	 * 地址
	 */
	private String address;

	/**
	 * 电子邮件
	 */
	private String email;

	/**
	 * 角色
	 */
	private List<RoleInfo> roles;


}
