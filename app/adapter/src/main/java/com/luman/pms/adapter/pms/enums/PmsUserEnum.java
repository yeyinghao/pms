package com.luman.pms.adapter.pms.enums;

import com.luman.smy.common.enums.BaseEnum;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

/**
 * Pms用户枚举
 *
 * @author yeyinghao
 * @date 2024/04/16
 */
@Getter
@RequiredArgsConstructor
@ToString
public enum PmsUserEnum implements BaseEnum {

	/**
	 * 查询用户列表
	 */
	GET_USERS("查询用户列表"),

	/**
	 * 创建用户
	 */
	CREATE("创建用户"),

	/**
	 * 更新
	 */
	UPDATE("更新用户"),

	/**
	 * 删除用户
	 */
	REMOVE("删除用户"),

	/**
	 * 查询用户详情
	 */
	DETAIL("查询用户详情"),

	/**
	 * 分页查询用户列表
	 */
	PAGE("分页查询用户列表"),

	/**
	 * 更新用户信息
	 */
	UPDATE_PROFILE("更新用户信息"),

	/**
	 * 根据用户名查询用户
	 */
	FIND_BY_USERNAME("根据用户名查询用户"),

	/**
	 * 查询用户信息
	 */
	GET_USER_PROFILE("查询用户信息"),

	/**
	 * 添加角色
	 */
	ADD_ROLES("添加角色"),

	/**
	 * 重置密码
	 */
	RESET_PASSWORD("重置密码");

	/**
	 * 响应业务码的描述
	 */
	private final String description;
}
