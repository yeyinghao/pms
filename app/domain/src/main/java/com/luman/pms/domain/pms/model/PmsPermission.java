package com.luman.pms.domain.pms.model;

import com.luman.smy.common.model.BaseDP;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * pms_permission表领域模型
 *
 * @author yeyinghao
 * @date 2024/04/14
 */
@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
public class PmsPermission extends BaseDP {

	/**
	 * 权限id
	 */
	private Long permissionId;

	/**
	 * 名称
	 */
	private String name;

	/**
	 * 编号
	 */
	private String code;

	/**
	 * 类型
	 */
	private String type;

	/**
	 * 父级id
	 */
	private Long parentId;

	/**
	 * 路径
	 */
	private String path;

	/**
	 * 外跳链接
	 */
	private String redirect;

	/**
	 * 图标
	 */
	private String icon;

	/**
	 * component
	 */
	private String component;

	/**
	 * layout
	 */
	private String layout;

	/**
	 * keepAlive
	 */
	private Boolean keepAlive;

	/**
	 * 方法
	 */
	private String method;

	/**
	 * 描述
	 */
	private String description;

	/**
	 * 是否展示在页面菜单
	 */
	private Boolean show;

	/**
	 * 是否启用
	 */
	private Boolean enable;

	/**
	 * 排序
	 */
	private Integer order;

}

