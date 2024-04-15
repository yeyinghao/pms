package com.luman.pms.application.pms.user.exec.qry;

import cn.dev33.satoken.stp.StpUtil;
import com.luman.pms.application.pms.role.exec.qry.PmsRoleQryExec;
import com.luman.pms.client.pms.dto.info.ProfileInfo;
import com.luman.pms.client.pms.dto.info.RoleInfo;
import com.luman.pms.client.pms.dto.info.UserDetailInfo;
import com.luman.pms.client.pms.dto.info.UserPageInfo;
import com.luman.pms.client.pms.dto.req.UserPageReq;
import com.luman.pms.domain.pms.dp.PmsProfile;
import com.luman.pms.domain.pms.dp.PmsUser;
import com.luman.pms.infrastructure.pms.service.PmsProfileDataService;
import com.luman.pms.infrastructure.pms.service.PmsRoleDataService;
import com.luman.pms.infrastructure.pms.service.PmsUserDataService;
import com.luman.pms.infrastructure.pms.service.PmsUserRoleDataService;
import com.luman.pms.infrastructure.pms.util.UserTokenUtil;
import com.luman.smy.common.model.PageRes;
import com.luman.smy.token.constant.SaTokenConstant;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Pms用户qry执行
 *
 * @author yeyinghao
 * @date 2024/04/15
 */
@Component
@RequiredArgsConstructor
public class PmsUserQryExec {

	/**
	 * Pms用户数据服务
	 */
	private final PmsUserDataService pmsUserDataService;

	/**
	 * Pms角色数据服务
	 */
	private final PmsRoleDataService pmsRoleDataService;

	/**
	 * Pmsprofile数据服务
	 */
	private final PmsProfileDataService pmsProfileDataService;

	/**
	 * Pms用户角色数据服务
	 */
	private final PmsUserRoleDataService pmsUserRoleDataService;

	/**
	 * Pms角色qry执行
	 */
	private final PmsRoleQryExec pmsRoleQryExec;

	/**
	 * 细节
	 *
	 * @return {@link UserDetailInfo}
	 */
	public UserDetailInfo detail() {

		Long id = UserTokenUtil.getUserId();
		String roleCode = (String) StpUtil.getExtra(SaTokenConstant.JWT_CURRENT_ROLE_KEY);

		PmsUser pmsUser = pmsUserDataService.findById(id);

		UserDetailInfo userDetailInfo = new UserDetailInfo();
		userDetailInfo.setId(pmsUser.getId());
		userDetailInfo.setUserName(pmsUser.getUserName());
		userDetailInfo.setEnable(pmsUser.getEnable());
		userDetailInfo.setCreateTime(pmsUser.getCreateTime());
		userDetailInfo.setUpdateTime(pmsUser.getUpdateTime());

		PmsProfile pmsProfile = pmsProfileDataService.findByUserId(id);
		ProfileInfo profileInfo = new ProfileInfo();
		profileInfo.setGender(pmsProfile.getGender());
		profileInfo.setAvatar(pmsProfile.getAvatar());
		profileInfo.setAddress(pmsProfile.getAddress());
		profileInfo.setEmail(pmsProfile.getEmail());
		profileInfo.setUserId(pmsProfile.getUserId());
		profileInfo.setNickName(pmsProfile.getNickName());
		userDetailInfo.setProfile(profileInfo);

		List<RoleInfo> roleInfos = pmsRoleQryExec.getRoleInfosByUserId(pmsUser.getId());
		userDetailInfo.setCurrentRole(roleInfos.stream().filter(item -> item.getCode().equals(roleCode)).collect(Collectors.toList()).get(0));
		userDetailInfo.setRoles(roleInfos);
		return userDetailInfo;
	}

	/**
	 * 查询页面
	 *
	 * @param req 请求
	 * @return {@link PageRes}<{@link UserPageInfo}>
	 */
	public PageRes<UserPageInfo> queryPage(UserPageReq req) {
		PageRes<PmsUser> userPageResp = pmsUserDataService.listByPage(req);
		List<PmsUser> dataList = userPageResp.getRecords();
		PageRes<UserPageInfo> pageResp = new PageRes<>();
		pageResp.setPageIndex(userPageResp.getPageIndex());
		pageResp.setPageSize(userPageResp.getPageSize());
		pageResp.setTotalSize(userPageResp.getTotalSize());
		List<UserPageInfo> pageInfos = new ArrayList<>();
		dataList.forEach(item -> {
			UserPageInfo userPageInfo = new UserPageInfo();
			userPageInfo.setId(item.getId());
			userPageInfo.setUserName(item.getUserName());
			userPageInfo.setEnable(item.getEnable());
			userPageInfo.setCreateTime(item.getCreateTime());
			userPageInfo.setUpdateTime(item.getUpdateTime());
			PmsProfile pmsProfile = pmsProfileDataService.findByUserId(item.getId());
			userPageInfo.setGender(pmsProfile.getGender());
			userPageInfo.setAvatar(pmsProfile.getAvatar());
			userPageInfo.setAddress(pmsProfile.getAddress());
			userPageInfo.setEmail(pmsProfile.getEmail());
			// 查询用户的角色
			userPageInfo.setRoles(pmsRoleQryExec.getRoleInfosByUserId(item.getId()));
			pageInfos.add(userPageInfo);
		});
		pageResp.setRecords(pageInfos);
		return pageResp;
	}

}