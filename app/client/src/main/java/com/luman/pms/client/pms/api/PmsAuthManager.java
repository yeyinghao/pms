/*
 * Copyright (c) Ye Yinghao
 * 2022.1 - 2024.1
 */

package com.luman.pms.client.pms.api;


import com.luman.pms.client.pms.model.req.ChangePasswordReq;
import com.luman.pms.client.pms.model.req.LoginReq;
import com.luman.pms.client.pms.model.res.LoginTokenRes;

/**
 * 经前综合症身份验证Manager
 *
 * @author yeyinghao
 * @date 2024/01/11
 */
public interface PmsAuthManager {

    /**
     * 登录
     *
     * @param req 请求
     * @return {@link LoginTokenRes}
     */
    LoginTokenRes login(LoginReq req);

    /**
     * 刷新令牌
     *
     * @return {@link LoginTokenRes}
     */
    LoginTokenRes refreshToken();

    /**
     * 开关作用
     *
     * @param roleCode 角色代码
     * @return {@link LoginTokenRes}
     */
    LoginTokenRes switchRole(String roleCode);

    /**
     * 注销
     */
    void logout();

    /**
     * 验证码
     */
    void captcha();

    /**
     * 更改密码
     *
     * @param req 请求
     */
    void changePassword(ChangePasswordReq req);
}


