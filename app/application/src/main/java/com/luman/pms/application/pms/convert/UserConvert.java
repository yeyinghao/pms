package com.luman.pms.application.pms.convert;

import com.luman.pms.client.pms.model.info.RegisterUserProfileInfo;
import com.luman.pms.domain.pms.model.PmsProfile;
import com.luman.pms.domain.pms.model.PmsUserRole;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class UserConvert {

	public static List<PmsUserRole> buildUserRoles(List<Long> roleIds, Long userId) {
		return roleIds.stream().map(roleId -> {
			PmsUserRole userRole = new PmsUserRole();
			userRole.setUserId(userId);
			userRole.setRoleId(roleId);
			return userRole;
		}).collect(Collectors.toList());
	}

	public static PmsProfile buildProfile(RegisterUserProfileInfo profile, Long userId) {
		PmsProfile pmsProfile = new PmsProfile();
		if (Objects.nonNull(profile)) {
			pmsProfile.setGender(profile.getGender());
			pmsProfile.setAvatar(profile.getAvatar());
			pmsProfile.setUserId(userId);
			pmsProfile.setAddress(profile.getAddress());
			pmsProfile.setEmail(profile.getEmail());
			pmsProfile.setNickName(profile.getNickName());
		}
		return pmsProfile;
	}
}
