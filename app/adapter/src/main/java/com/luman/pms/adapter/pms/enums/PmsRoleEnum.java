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
	 * 查询用户列表
	 */
	GET_USERS("查询用户列表"),

	/**
	 * 创建
	 */
	CREATE("创建"),

	/**
	 * 更新
	 */
	UPDATE("更新"),

	/**
	 * findbyid
	 */
	FIND_BY_ID("查询单个"),

	/**
	 * 删除
	 */
	REMOVE("删除"),

	/**
	 * 找到所有
	 */
	FIND_ALL("查询所有"),

	/**
	 * 页面
	 */
	PAGE("分页查询"),

	/**
	 * 查找角色权限
	 */
	FIND_ROLE_PERMISSIONS("查询角色权限"),

	/**
	 * 添加角色权限
	 */
	ADD_ROLE_PERMISSIONS("添加角色权限"),

	/**
	 * 权限tree
	 */
	PERMISSION_TREE("权限树"),

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
