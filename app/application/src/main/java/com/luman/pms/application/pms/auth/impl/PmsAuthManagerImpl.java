/*
 * Copyright (c) Ye Yinghao
 * 2022.1 - 2024.1
 */

package com.luman.pms.application.pms.auth.impl;

import cn.dev33.satoken.stp.StpUtil;
import com.luman.pms.application.pms.auth.exec.CaptchaCreateExec;
import com.luman.pms.application.pms.auth.exec.PmsAuthTokenExec;
import com.luman.pms.application.pms.user.exec.PmsUserUpdateExec;
import com.luman.pms.client.pms.api.PmsAuthManager;
import com.luman.pms.client.pms.dto.req.ChangePasswordReq;
import com.luman.pms.client.pms.dto.req.LoginReq;
import com.luman.pms.client.pms.dto.res.LoginTokenRes;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


/**
 * Pms身份验证Manager实现
 *
 * @author yeyinghao
 * @date 2024/01/11
 */
@RequiredArgsConstructor
@Service
public class PmsAuthManagerImpl implements PmsAuthManager {

	/**
	 * Pms用户更新执行
	 */
	private final PmsUserUpdateExec pmsUserUpdateExec;

	/**
	 * Pms身份验证令牌执行
	 */
	private final PmsAuthTokenExec pmsAuthTokenExec;

	/**
	 * 验证码执行
	 */
	private final CaptchaCreateExec captchaExec;

	@Override
	public LoginTokenRes login(LoginReq req) {
		return pmsAuthTokenExec.login(req);
	}

	@Override
	public LoginTokenRes refreshToken() {
		return pmsAuthTokenExec.refreshToken();
	}

	@Override
	public LoginTokenRes switchRole(String roleCode) {
		return pmsAuthTokenExec.switchRole(roleCode);
	}

	@Override
	public Boolean logout() {
		StpUtil.logout();
		return Boolean.TRUE;
	}

	@Override
	public Boolean captcha() {
		return captchaExec.captcha();
	}

	@Override
	public Boolean changePassword(ChangePasswordReq req) {
		return pmsUserUpdateExec.changePassword(req);
	}
}
