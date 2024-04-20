package com.luman.pms.client.pms.model.info;

import lombok.Data;

/**
 * 权限
 *
 * @author dhb
 * @date 2024/04/20
 */
@Data
public class PermissionInfo {

	/**
	 * id
	 */
	private Long id;

	/**
	 * 名称
	 */
	private String name;

	/**
	 * 代码
	 */
	private String code;

	/**
	 * 类型
	 */
	private String type;

	/**
	 * 家长。id
	 */
	private Long parentId;

	/**
	 * 路径
	 */
	private String path;

	/**
	 * 重定向
	 */
	private String redirect;

	/**
	 * 图标
	 */
	private String icon;

	/**
	 * 组件
	 */
	private String component;

	/**
	 * 布局
	 */
	private String layout;

	/**
	 * keepalive
	 */
	private Boolean keepalive;

	/**
	 * 方法
	 */
	private String method;

	/**
	 * 描述
	 */
	private String description;

	/**
	 * 显示
	 */
	private Boolean show;

	/**
	 * 启用
	 */
	private Boolean enable;

	/**
	 * 顺序
	 */
	private Integer order;

}
