/*
 * Copyright (c) Ye Yinghao
 * 2022.1 - 2024.1
 */

package com.luman.pms.client.pms.dto.req;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * 创建权限
 *
 * @author dhb
 */
@Data
public class CreatePermissionReq {

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
