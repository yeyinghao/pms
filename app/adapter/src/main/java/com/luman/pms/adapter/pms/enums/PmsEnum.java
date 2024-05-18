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
public enum PmsEnum implements BaseEnum {

	/**
	 * 登录
	 */
	AUTH_LOGIN("登录"),

	/**
	 * 注册用户
	 */
	AUTH_REGISTER("注册用户"),

	/**
	 * 刷新token
	 */
	AUTH_REFRESH_TOKEN("刷新token"),

	/**
	 * 切换角色
	 */
	AUTH_SWITCH_ROLE("切换角色"),

	/**
	 * 登出
	 */
	AUTH_LOGOUT("登出"),

	/**
	 * 查询用户列表
	 */
	PERMISSION_GET_USERS("查询用户列表"),

	/**
	 * 创建权限
	 */
	PERMISSION_CREATE("创建权限"),

	/**
	 * 批量创建权限
	 */
	PERMISSION_BATCH_CREATE("批量创建权限"),

	/**
	 * 更新权限
	 */
	PERMISSION_UPDATE("更新权限"),

	/**
	 * 批量更新权限
	 */
	PERMISSION_BATCH_UPDATE("批量更新权限"),

	/**
	 * 删除权限
	 */
	PERMISSION_DELETE("删除权限"),

	/**
	 * 批量删除权限
	 */
	PERMISSION_BATCH_DELETE("批量删除权限"),

	/**
	 * 查询所有权限
	 */
	PERMISSION_FIND_ALL("查询所有权限"),

	/**
	 * 查询菜单权限树
	 */
	PERMISSION_FIND_MENU_TREE("查询菜单权限树"),

	/**
	 * 查询单个权限
	 */
	PERMISSION_FIND_BY_ID("查询单个权限"),

	/**
	 * 删除权限
	 */
	PERMISSION_REMOVE("删除权限"),

	/**
	 * 查询按钮根据父ID
	 */
	PERMISSION_FIND_BUTTON_BY_PARENT_ID("查询按钮根据父ID"),

	/**
	 * 验证菜单权限
	 */
	PERMISSION_VALIDATE_MENU_PATH("验证菜单权限"),

	/**
	 * 验证码
	 */
	AUTH_CAPTCHA("验证码"),

	/**
	 * 查询用户角色列表
	 */
	ROLE_GET_USERS("查询用户角色列表"),

	/**
	 * 创建角色
	 */
	ROLE_CREATE("创建角色"),

	/**
	 * 更新角色
	 */
	ROLE_UPDATE("更新角色"),

	/**
	 * 更新角色状态
	 */
	ROLE_UPDATE_STATUS("更新角色状态"),

	/**
	 * 查询单个角色
	 */
	ROLE_FIND_BY_ID("查询单个角色"),

	/**
	 * 删除角色
	 */
	ROLE_REMOVE("删除角色"),

	/**
	 * 查询所有角色
	 */
	ROLE_FIND_ALL("查询所有角色"),

	/**
	 * 分页查询角色
	 */
	ROLE_PAGE("分页查询角色"),

	/**
	 * 查找角色权限
	 */
	ROLE_FIND_ROLE_PERMISSIONS("查询角色权限"),

	/**
	 * 添加角色权限
	 */
	ROLE_ADD_ROLE_PERMISSIONS("添加角色权限"),

	/**
	 * 权限角色树
	 */
	ROLE_PERMISSION_TREE("权限角色树"),

	/**
	 * 添加角色用户
	 */
	ROLE_ADD_ROLE_USERS("添加角色用户"),

	/**
	 * 删除角色用户
	 */
	ROLE_REMOVE_ROLE_USERS("删除角色用户"),

	/**
	 * 更改密码
	 */
	AUTH_CHANGE_PASSWORD("更改密码"),

	/**
	 * 查询用户列表
	 */
	USER_GET_USERS("查询用户列表"),

	/**
	 * 创建用户
	 */
	USER_CREATE("创建用户"),

	/**
	 * 更新
	 */
	USER_UPDATE("更新用户"),

	/**
	 * 删除用户
	 */
	USER_REMOVE("删除用户"),

	/**
	 * 查询用户详情
	 */
	USER_DETAIL("查询用户详情"),

	/**
	 * 分页查询用户列表
	 */
	USER_PAGE("分页查询用户列表"),

	/**
	 * 更新用户信息
	 */
	USER_UPDATE_PROFILE("更新用户信息"),

	/**
	 * 根据用户名查询用户
	 */
	USER_FIND_BY_USERNAME("根据用户名查询用户"),

	/**
	 * 查询用户信息
	 */
	USER_GET_USER_PROFILE("查询用户信息"),

	/**
	 * 添加角色
	 */
	USER_ADD_ROLES("添加角色"),

	/**
	 * 重置密码
	 */
	USER_RESET_PASSWORD("重置密码");

	;

	/**
	 * 响应业务码的描述
	 */
	private final String description;
}
