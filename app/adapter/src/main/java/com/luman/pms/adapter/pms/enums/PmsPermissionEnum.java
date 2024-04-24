package com.luman.pms.adapter.pms.enums;

import com.luman.smy.common.enums.BaseEnum;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

/**
 * Pms权限枚举
 *
 * @author yeyinghao
 * @date 2024/04/16
 */
@Getter
@RequiredArgsConstructor
@ToString
public enum PmsPermissionEnum implements BaseEnum {

	/**
	 * 查询用户列表
	 */
	GET_USERS("查询用户列表"),

	/**
	 * 创建权限
	 */
	CREATE("创建权限"),

	/**
	 * 批量创建权限
	 */
	BATCH_CREATE("批量创建权限"),

	/**
	 * 更新权限
	 */
	UPDATE("更新权限"),

	/**
	 * 批量更新权限
	 */
	BATCH_UPDATE("批量更新权限"),

	/**
	 * 删除权限
	 */
	DELETE("删除权限"),

	/**
	 * 批量删除权限
	 */
	BATCH_DELETE("批量删除权限"),

	/**
	 * 查询所有权限
	 */
	FIND_ALL("查询所有权限"),

	/**
	 * 查询菜单权限树
	 */
	FIND_MENU_TREE("查询菜单权限树"),

	/**
	 * 查询单个权限
	 */
	FIND_BY_ID("查询单个权限"),

	/**
	 * 删除权限
	 */
	REMOVE("删除权限"),

	/**
	 * 查询按钮根据父ID
	 */
	FIND_BUTTON_BY_PARENT_ID("查询按钮根据父ID"),

	/**
	 * 验证菜单权限
	 */
	VALIDATE_MENU_PATH("验证菜单权限"),

	;

	/**
	 * 响应业务码的描述
	 */
	private final String description;
}
