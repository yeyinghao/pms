/*
 * Copyright (c) Ye Yinghao
 * 2022.1 - 2024.1
 */

package com.luman.pms.client.pms.model.info;

import lombok.Data;

/**
 * 角色Dto
 *
 * @author dhb
 * @date 2024/04/20
 */
@Data
public class RoleInfo {

    /**
     * id
     */
    private Long id;

    /**
     * 代码
     */
    private String code;

    /**
     * 名称
     */
    private String name;

    /**
     * 启用
     */
    private Boolean enable;

}
