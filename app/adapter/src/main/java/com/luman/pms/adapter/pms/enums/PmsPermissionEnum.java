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
	 * 创建
	 */
	CREATE("创建"),

	/**
	 * 批量创建
	 */
	BATCH_CREATE("批量创建"),

	/**
	 * 更新
	 */
	UPDATE("更新"),

	/**
	 * 批量更新
	 */
	BATCH_UPDATE("批量更新"),

	/**
	 * 删除
	 */
	DELETE("删除"),

	/**
	 * 批量删除
	 */
	BATCH_DELETE("批量删除"),

	/**
	 * 找到所有
	 */
	FIND_ALL("查询所有"),

	/**
	 * 查找菜单树
	 */
	FIND_MENU_TREE("查询菜单树"),

	/**
	 * findbyid
	 */
	FIND_BY_ID("查询单个"),

	/**
	 * 删除
	 */
	REMOVE("删除"),

	/**
	 * 查找按钮和API
	 */
	FIND_BUTTON_AND_API("查询按钮和API"),

	/**
	 * 验证菜单路径
	 */
	VALIDATE_MENU_PATH("验证菜单路径"),

	;

	/**
	 * 响应业务码的描述
	 */
	private final String description;
}
