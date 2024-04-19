package com.luman.pms.client.pms.model.info;

import lombok.Data;

import java.util.List;

/**
 * 角色Dto
 *
 * @author dhb
 */
@Data
public class RolePageInfo {

	private Long id;

	private String code;

	private String name;

	private Boolean enable;

	private List<Long> permissionIds;

}
