/*
 * Copyright (c) Ye Yinghao
 * 2022.1 - 2024.1
 */

package com.luman.pms.client.pms.dto.req;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;

/**
 * 重置密码
 *
 * @author dhb
 */
@Data
public class UpdateUserReq {

	private Long id;

	@NotBlank(message = "密码不能为空")
	@Length(min = 6, max = 20, message = "密码长度必须大于6到20之间")
	private Boolean enable;

}
