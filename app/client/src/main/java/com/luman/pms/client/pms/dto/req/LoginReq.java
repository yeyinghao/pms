/*
 * Copyright (c) Ye Yinghao
 * 2022.1 - 2024.1
 */

package com.luman.pms.client.pms.dto.req;

import lombok.Data;

/**
 * 登录请求参数
 *
 * @author dhb
 */
@Data
public class LoginReq {

    /**
     * 用户名
     */
    private String userName;

    /**
     * 密码
     */
    private String password;

    /**
     * 验证码
     */
    private String captcha;

    private String captchaKey;

    private Boolean isQuick;

}
