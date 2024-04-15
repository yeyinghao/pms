/*
 * Copyright (c) Ye Yinghao
 * 2022.1 - 2024.1
 */

package com.luman.pms.client.pms.dto.info;

import lombok.Data;

/**
 * 角色Dto
 *
 * @author dhb
 */
@Data
public class RoleInfo {

    private Long id;

    private String code;

    private String name;

    private Boolean enable;

}
