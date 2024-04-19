/*
 * Copyright (c) Ye Yinghao
 * 2022.1 - 2024.1
 */

package com.luman.pms.client.pms.model.res;

import lombok.Data;

/**
 * 登录响应token
 *
 * @author dhb
 */
@Data
public class LoginTokenRes {

    /**
     * 通过登录获取的token
     */
    private String accessToken;

}
