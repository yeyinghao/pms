package com.luman.pms.application.pms.convert;

import com.luman.pms.client.pms.model.info.RegisterUserProfileInfo;
import com.luman.pms.domain.pms.model.PmsProfile;

import java.util.Objects;

public class ProfileConvert {

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
