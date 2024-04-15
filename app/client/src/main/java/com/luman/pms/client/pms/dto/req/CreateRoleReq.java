/*
 * Copyright (c) Ye Yinghao
 * 2022.1 - 2024.1
 */

package com.luman.pms.client.pms.dto.req;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.util.List;

/**
 * 创建角色
 *
 * @author dhb
 */
@Data
public class CreateRoleReq   {

    @NotBlank(message = "角色编码不能为空")
    private String code;

    @NotBlank(message = "角色名不能为空")
    private String name;

    private List<Long> permissionIds;

    private Boolean enable;

}
