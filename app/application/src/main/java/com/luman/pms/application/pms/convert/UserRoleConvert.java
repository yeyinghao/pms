package com.luman.pms.application.pms.convert;

import com.luman.pms.domain.pms.model.PmsUserRole;

import java.util.List;
import java.util.stream.Collectors;

public class UserRoleConvert {

	public static List<PmsUserRole> buildUserRoles(List<Long> roleIds, Long userId) {
		return roleIds.stream().map(roleId -> {
			PmsUserRole userRole = new PmsUserRole();
			userRole.setUserId(userId);
			userRole.setRoleId(roleId);
			return userRole;
		}).collect(Collectors.toList());
	}
}
