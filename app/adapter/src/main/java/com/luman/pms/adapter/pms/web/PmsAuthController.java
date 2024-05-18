/*
 * Copyright (c) Ye Yinghao
 * 2022.1 - 2024.1
 */

package com.luman.pms.adapter.pms.web;

import cn.dev33.satoken.annotation.SaIgnore;
import com.luman.pms.adapter.pms.enums.PmsEnum;
import com.luman.pms.client.pms.api.PmsAuthManager;
import com.luman.pms.client.pms.api.PmsUserManager;
import com.luman.pms.client.pms.model.req.ChangePasswordReq;
import com.luman.pms.client.pms.model.req.LoginReq;
import com.luman.pms.client.pms.model.req.RegisterUserReq;
import com.luman.pms.client.pms.model.res.LoginTokenRes;
import com.luman.smy.common.helper.ResultHelper;
import com.luman.smy.common.template.WebTemplate;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

/**
 * 身份验证控制器
 *
 * @author yeyinghao
 * @date 2024/01/11
 */
@RequestMapping("/api/auth")
@RestController
@RequiredArgsConstructor
public class PmsAuthController {

	/**
	 * PMS认证映射器
	 */
	private final PmsAuthManager pmsAuthMapper;

	/**
	 * PMS认证映射器
	 */
	private final PmsUserManager pmsUserManager;

	/**
	 * 网页模板
	 */
	private final WebTemplate webTemplate;

	/**
	 * 登录
	 *
	 * @param req 请求
	 * @return {@link ResultHelper}<{@link LoginTokenRes}>
	 */
	@PostMapping("/login")
	@SaIgnore
	public ResultHelper<LoginTokenRes> login(@RequestBody LoginReq req) {
		return webTemplate.execute(PmsEnum.AUTH_LOGIN, () -> pmsAuthMapper.login(req));
	}

	/**
	 * 注册
	 *
	 * @param req 请求
	 * @return {@link ResultHelper}<{@link Boolean}>
	 */
	@PostMapping("/register")
	public ResultHelper<Boolean> register(@RequestBody RegisterUserReq req) {
		webTemplate.execute(PmsEnum.AUTH_REGISTER, () -> pmsUserManager.register(req));
		return ResultHelper.success();
	}

	/**
	 * 刷新令牌
	 *
	 * @return {@link ResultHelper}<{@link LoginTokenRes}>
	 */
	@GetMapping("/refresh/token")
	public ResultHelper<LoginTokenRes> refreshToken() {
		return webTemplate.execute(PmsEnum.AUTH_REFRESH_TOKEN, pmsAuthMapper::refreshToken);
	}

	/**
	 * 开关作用
	 *
	 * @param roleCode 角色代码
	 * @return {@link ResultHelper}<{@link LoginTokenRes}>
	 */
	@PostMapping("/current-role/switch/{roleCode}")
	public ResultHelper<LoginTokenRes> switchRole(@PathVariable String roleCode) {
		return webTemplate.execute(PmsEnum.AUTH_SWITCH_ROLE, () -> pmsAuthMapper.switchRole(roleCode));
	}

	/**
	 * 注销
	 *
	 * @return {@link ResultHelper}<{@link Boolean}>
	 */
	@PostMapping("/logout")
	public ResultHelper<Boolean> logout() {
		webTemplate.execute(PmsEnum.AUTH_LOGOUT, pmsAuthMapper::logout);
		return ResultHelper.success();
	}

	/**
	 * 验证码
	 *
	 * @return {@link ResultHelper}<{@link Boolean}>
	 */
	@GetMapping("/captcha")
	@SaIgnore
	public ResultHelper<Boolean> captcha() {
		webTemplate.execute(PmsEnum.AUTH_CAPTCHA, pmsAuthMapper::captcha);
		return ResultHelper.success();
	}

	/**
	 * 更改密码
	 *
	 * @param req 请求
	 * @return {@link ResultHelper}<{@link Boolean}>
	 */
	@PostMapping("/password")
	public ResultHelper<Boolean> changePassword(@RequestBody ChangePasswordReq req) {
		webTemplate.execute(PmsEnum.AUTH_CHANGE_PASSWORD, () -> pmsAuthMapper.changePassword(req));
		return ResultHelper.success();
	}

}
