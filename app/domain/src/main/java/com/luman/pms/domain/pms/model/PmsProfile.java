package com.luman.pms.domain.pms.model;

import com.luman.pms.client.pms.model.req.UpdateProfileReq;
import com.luman.smy.common.model.BaseDP;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * pms_profile表领域模型
 *
 * @author yeyinghao
 * @date 2024/04/14
 */
@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
public class PmsProfile extends BaseDP {

	/**
	 * 性别
	 */
	private Integer gender;

	/**
	 * 头像地址
	 */
	private String avatar;

	/**
	 * 地址
	 */
	private String address;

	/**
	 * 邮箱
	 */
	private String email;

	/**
	 * userBizId
	 */
	private Long userId;

	/**
	 * 昵称
	 */
	private String nickName;

	public static PmsProfile buildPmsProfile(Long userId, UpdateProfileReq req) {
		PmsProfile pmsProfile = new PmsProfile();
		pmsProfile.setUserId(userId);
		pmsProfile.setGender(req.getGender());
		pmsProfile.setAddress(req.getAddress());
		pmsProfile.setEmail(req.getEmail());
		pmsProfile.setNickName(req.getNickName());
		return pmsProfile;
	}

}

