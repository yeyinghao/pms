package com.luman.pms.infrastructure.pms.dataobject;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.luman.smy.dal.model.BasePO;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * pms_permission表实体类
 *
 * @author yeyinghao
 * @date 2024/04/14
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("pms_permission")
public class PmsPermissionPO extends BasePO {

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
	@TableField("`show`")
	private Boolean show;

	/**
	 * 是否启用
	 */
	private Boolean enable;

	/**
	 * 排序
	 */
	@TableField("`order`")
	private Integer order;

}

