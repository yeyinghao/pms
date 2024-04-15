/*
 * Copyright (c) Ye Yinghao
 * 2022.1 - 2024.1
 */

package com.luman.pms.client.pms.dto.req;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * 修改密码请求
 *
 * @author dhb
 */
@Data
public class ChangePasswordReq {


    @NotNull(message = "旧密码不能为空")
    private String oldPassword;

    @NotNull(message = "新密码不能为空")
    private String newPassword;

}
