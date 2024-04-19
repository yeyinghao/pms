package com.luman.pms.application.pms.convert;

import com.luman.pms.domain.pms.model.PmsRolePermission;

import java.util.List;
import java.util.stream.Collectors;

public class RolePermissionConvert {

	public static List<PmsRolePermission> buildRolePermissions(Long roleId, List<Long> permissionIds) {
		return permissionIds.stream().map(permId -> {
			PmsRolePermission rolePermission = new PmsRolePermission();
			rolePermission.setRoleId(roleId);
			rolePermission.setPermissionId(permId);
			return rolePermission;
		}).collect(Collectors.toList());
	}

}
