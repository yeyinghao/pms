package com.luman.pms.adapter.pms.enums;

import com.luman.smy.common.enums.BaseEnum;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

/**
 * Pms身份验证枚举
 *
 * @author yeyinghao
 * @date 2024/04/16
 */
@Getter
@RequiredArgsConstructor
@ToString
public enum PmsAuthEnum implements BaseEnum {

	/**
	 * 登录
	 */
	LOGIN("登录"),

	/**
	 * 注册用户
	 */
	REGISTER("注册用户"),

	/**
	 * 刷新token
	 */
	REFRESH_TOKEN("刷新token"),

	/**
	 * 切换角色
	 */
	SWITCH_ROLE("切换角色"),

	/**
	 * 登出
	 */
	LOGOUT("登出"),

	/**
	 * 验证码
	 */
	CAPTCHA("验证码"),

	/**
	 * 更改密码
	 */
	CHANGE_PASSWORD("更改密码"),

	;

	/**
	 * 响应业务码的描述
	 */
	private final String description;
}
