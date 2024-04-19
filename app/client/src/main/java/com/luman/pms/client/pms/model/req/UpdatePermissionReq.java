/*
 * Copyright (c) Ye Yinghao
 * 2022.1 - 2024.1
 */

package com.luman.pms.client.pms.model.req;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * 更新权限
 */
@Data
public class UpdatePermissionReq {

	private Long id;

	@NotBlank
	private String name;

	@NotBlank
	private String code;

	@NotBlank
	private String type;

	private Long parentId;

	private String path;

	private String redirect;

	private String icon;

	private String component;

	private String layout;

	private Boolean keepalive;

	private String method;

	private String description;

	private Boolean show;

	private Boolean enable;

	private Integer order;
}
