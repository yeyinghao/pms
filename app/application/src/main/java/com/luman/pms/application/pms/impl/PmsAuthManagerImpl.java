/*
 * Copyright (c) Ye Yinghao
 * 2022.1 - 2024.1
 */

package com.luman.pms.application.pms.impl;

import cn.dev33.satoken.stp.StpUtil;
import com.luman.pms.application.pms.exec.CaptchaCreateExec;
import com.luman.pms.application.pms.exec.PmsAuthTokenExec;
import com.luman.pms.application.pms.exec.PmsUserUpdateExec;
import com.luman.pms.client.pms.api.PmsAuthManager;
import com.luman.pms.client.pms.model.req.ChangePasswordReq;
import com.luman.pms.client.pms.model.req.LoginReq;
import com.luman.pms.client.pms.model.res.LoginTokenRes;
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
	public void logout() {
		StpUtil.logout();
	}

	@Override
	public void captcha() {
		captchaExec.captcha();
	}

	@Override
	public void changePassword(ChangePasswordReq req) {
		pmsUserUpdateExec.changePassword(req);
	}
}
