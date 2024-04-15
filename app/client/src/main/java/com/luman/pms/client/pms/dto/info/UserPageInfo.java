/*
 * Copyright (c) Ye Yinghao
 * 2022.1 - 2024.1
 */

package com.luman.pms.client.pms.dto.info;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

/**
 * 用户分页数据
 */
@Data
public class UserPageInfo {

	private Long id;

	private String userName;

	private Boolean enable;

	private LocalDateTime createTime;

	private LocalDateTime updateTime;

	private Integer gender;

	private String avatar;

	private String address;

	private String email;

	private List<RoleInfo> roles;


}
