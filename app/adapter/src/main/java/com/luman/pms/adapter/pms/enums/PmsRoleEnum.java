package com.luman.pms.adapter.pms.enums;

import com.luman.smy.common.enums.BaseEnum;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

/**
 * Pms角色枚举
 *
 * @author yeyinghao
 * @date 2024/04/16
 */
@Getter
@RequiredArgsConstructor
@ToString
public enum PmsRoleEnum implements BaseEnum {

	/**
	 * 查询用户角色列表
	 */
	GET_USERS("查询用户角色列表"),

	/**
	 * 创建角色
	 */
	CREATE("创建角色"),

	/**
	 * 更新角色
	 */
	UPDATE("更新角色"),

	/**
	 * 查询单个角色
	 */
	FIND_BY_ID("查询单个角色"),

	/**
	 * 删除角色
	 */
	REMOVE("删除角色"),

	/**
	 * 查询所有角色
	 */
	FIND_ALL("查询所有角色"),

	/**
	 * 分页查询角色
	 */
	PAGE("分页查询角色"),

	/**
	 * 查找角色权限
	 */
	FIND_ROLE_PERMISSIONS("查询角色权限"),

	/**
	 * 添加角色权限
	 */
	ADD_ROLE_PERMISSIONS("添加角色权限"),

	/**
	 * 权限角色树
	 */
	PERMISSION_TREE("权限角色树"),

	/**
	 * 添加角色用户
	 */
	ADD_ROLE_USERS("添加角色用户"),

	/**
	 * 删除角色用户
	 */
	REMOVE_ROLE_USERS("删除角色用户");

	/**
	 * 响应业务码的描述
	 */
	private final String description;
}
