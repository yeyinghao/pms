/*
 * Copyright (c) Ye Yinghao
 * 2022.1 - 2024.1
 */

package com.luman.pms.client.pms.model.req;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.util.List;

/**
 * 创建角色
 *
 * @author dhb
 * @date 2024/04/20
 */
@Data
public class CreateRoleReq   {

    /**
     * 代码
     */
    @NotBlank(message = "角色编码不能为空")
    private String code;

    /**
     * 名称
     */
    @NotBlank(message = "角色名不能为空")
    private String name;

    /**
     * 权限id
     */
    private List<Long> permissionIds;

    /**
     * 启用
     */
    private Boolean enable;

}
