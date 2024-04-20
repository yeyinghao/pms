/*
 * Copyright (c) Ye Yinghao
 * 2022.1 - 2024.1
 */

package com.luman.pms.client.pms.model.req;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * 更新权限
 *
 * @author yeyinghao
 * @date 2024/04/20
 */
@Data
public class UpdatePermissionReq {

	/**
	 * id
	 */
	private Long id;

	/**
	 * 名称
	 */
	@NotBlank
	private String name;

	/**
	 * 代码
	 */
	@NotBlank
	private String code;

	/**
	 * 类型
	 */
	@NotBlank
	private String type;

	/**
	 * 家长。id
	 */
	private Long parentId;

	/**
	 * 路径
	 */
	private String path;

	/**
	 * 重定向
	 */
	private String redirect;

	/**
	 * 图标
	 */
	private String icon;

	/**
	 * 组件
	 */
	private String component;

	/**
	 * 布局
	 */
	private String layout;

	/**
	 * keepalive
	 */
	private Boolean keepalive;

	/**
	 * 方法
	 */
	private String method;

	/**
	 * 描述
	 */
	private String description;

	/**
	 * 显示
	 */
	private Boolean show;

	/**
	 * 启用
	 */
	private Boolean enable;

	/**
	 * 订单
	 */
	private Integer order;
}
