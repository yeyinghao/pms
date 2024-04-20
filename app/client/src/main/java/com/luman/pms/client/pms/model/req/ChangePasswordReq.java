/*
 * Copyright (c) Ye Yinghao
 * 2022.1 - 2024.1
 */

package com.luman.pms.client.pms.model.req;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * 修改密码请求
 *
 * @author dhb
 * @date 2024/04/20
 */
@Data
public class ChangePasswordReq {


    /**
     * 旧密码
     */
    @NotNull(message = "旧密码不能为空")
    private String oldPassword;

    /**
     * 新密码
     */
    @NotNull(message = "新密码不能为空")
    private String newPassword;

}
