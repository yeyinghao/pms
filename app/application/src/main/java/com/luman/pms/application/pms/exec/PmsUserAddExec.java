package com.luman.pms.application.pms.exec;

import com.luman.pms.client.pms.model.info.RegisterUserProfileInfo;
import com.luman.pms.client.pms.model.req.AddUserRolesReq;
import com.luman.pms.client.pms.model.req.RegisterUserReq;
import com.luman.pms.domain.pms.gateway.PmsProfileGateway;
import com.luman.pms.domain.pms.gateway.PmsUserGateway;
import com.luman.pms.domain.pms.gateway.PmsUserRoleGateway;
import com.luman.pms.domain.pms.model.PmsProfile;
import com.luman.pms.domain.pms.model.PmsUser;
import com.luman.pms.domain.pms.model.PmsUserRole;
import com.luman.smy.common.enums.CommErrorEnum;
import com.luman.smy.common.exception.Assert;
import com.luman.smy.common.util.CodeUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * Pms用户添加执行
 *
 * @author yeyinghao
 * @date 2024/04/15
 */
@Component
@RequiredArgsConstructor
public class PmsUserAddExec {

	/**
	 * Pms用户数据服务
	 */
	private final PmsUserGateway pmsUserDataService;

	/**
	 * Pms配置文件数据服务
	 */
	private final PmsProfileGateway pmsProfileDataService;

	/**
	 * Pms用户角色数据服务
	 */
	private final PmsUserRoleGateway pmsUserRoleDataService;

	/**
	 * 注册
	 *
	 * @param req 请求
	 */
	public void register(RegisterUserReq req) {
		PmsUser pmsUser = pmsUserDataService.findByName(req.getUserName());
		// 存在报错
		Assert.isNull(pmsUser, CommErrorEnum.BIZ_ERROR, "用户已存在");
		PmsUser newPmsUser = new PmsUser();
		newPmsUser.setUserName(req.getUserName());
		newPmsUser.setPassword(req.getPassword());
		newPmsUser.setUserCode(getUserCode());
		newPmsUser.setEnable(Boolean.TRUE);
		newPmsUser.setStatus(Boolean.TRUE);
		pmsUserDataService.save(newPmsUser);

		PmsProfile pmsProfile = getPmsProfile(req, newPmsUser);
		pmsProfileDataService.save(pmsProfile);

		List<PmsUserRole> roleList = req.getRoleIds().stream().map(roleId -> {
			PmsUserRole userRole = new PmsUserRole();
			userRole.setUserId(newPmsUser.getId());
			userRole.setRoleId(roleId);
			userRole.setStatus(Boolean.TRUE);
			return userRole;
		}).collect(Collectors.toList());
		pmsUserRoleDataService.saveBatch(roleList);
	}

	/**
	 * 获取用户代码
	 *
	 * @return {@link String}
	 */
	private String getUserCode() {
		String userCode = CodeUtil.randomString(8);
		PmsUser pmsUser = pmsUserDataService.findByUserCode(userCode);
		while (pmsUser != null) {
			userCode = CodeUtil.randomString(8);
			pmsUser = pmsUserDataService.findByUserCode(userCode);
		}
		return userCode;
	}

	/**
	 * 获取Pms配置文件
	 *
	 * @param req        请求
	 * @param newPmsUser 新Pms用户
	 * @return {@link PmsProfile}
	 */
	private static PmsProfile getPmsProfile(RegisterUserReq req, PmsUser newPmsUser) {
		RegisterUserProfileInfo profile = req.getProfile();
		PmsProfile pmsProfile = new PmsProfile();
		if (Objects.nonNull(profile)) {
			pmsProfile.setGender(profile.getGender());
			pmsProfile.setAvatar(profile.getAvatar());
			pmsProfile.setAddress(profile.getAddress());
			pmsProfile.setEmail(profile.getEmail());
			pmsProfile.setNickName(profile.getNickName());
		}
		pmsProfile.setUserId(newPmsUser.getId());
		pmsProfile.setStatus(Boolean.TRUE);
		return pmsProfile;
	}

	/**
	 * 添加角色
	 *
	 * @param req 请求
	 */
	public void addRoles(AddUserRolesReq req) {
		pmsUserRoleDataService.removeByUserId(req.getId());
		List<PmsUserRole> list = req.getRoleIds().stream().map(roleId -> {
			PmsUserRole userRole = new PmsUserRole();
			userRole.setUserId(req.getId());
			userRole.setRoleId(roleId);
			userRole.setStatus(Boolean.TRUE);
			return userRole;
		}).collect(Collectors.toList());
		pmsUserRoleDataService.saveBatch(list);
	}
}
