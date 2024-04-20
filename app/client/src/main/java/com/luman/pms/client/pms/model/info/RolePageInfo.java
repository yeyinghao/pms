package com.luman.pms.client.pms.model.info;

import lombok.Data;

import java.util.List;

/**
 * 角色Dto
 *
 * @author dhb
 * @date 2024/04/20
 */
@Data
public class RolePageInfo {

	/**
	 * id
	 */
	private Long id;

	/**
	 * 代码
	 */
	private String code;

	/**
	 * 名称
	 */
	private String name;

	/**
	 * 启用
	 */
	private Boolean enable;

	/**
	 * 权限id
	 */
	private List<Long> permissionIds;

}
