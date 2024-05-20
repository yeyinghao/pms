package com.luman.pms.application.pms.exec.qry;

import cn.dev33.satoken.stp.StpUtil;
import com.luman.pms.client.pms.model.info.ProfileInfo;
import com.luman.pms.client.pms.model.info.RoleInfo;
import com.luman.pms.client.pms.model.info.UserDetailInfo;
import com.luman.pms.client.pms.model.info.UserPageInfo;
import com.luman.pms.client.pms.model.req.UserPageReq;
import com.luman.pms.domain.pms.gateway.PmsProfileGateway;
import com.luman.pms.domain.pms.gateway.PmsUserGateway;
import com.luman.pms.domain.pms.model.PmsProfile;
import com.luman.pms.domain.pms.model.PmsUser;
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
	private final PmsUserGateway pmsUserGateway;

	/**
	 * Pmsprofile数据服务
	 */
	private final PmsProfileGateway pmsProfileGateway;

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

		Long id = UserTokenUtil.getId();
		String roleCode = (String) StpUtil.getExtra(SaTokenConstant.JWT_CURRENT_ROLE_KEY);

		PmsUser pmsUser = pmsUserGateway.findById(id);

		UserDetailInfo userDetailInfo = new UserDetailInfo();
		userDetailInfo.setId(pmsUser.getId());
		userDetailInfo.setUserName(pmsUser.getUserName());
		userDetailInfo.setEnable(pmsUser.getEnable());
		userDetailInfo.setCreateTime(pmsUser.getCreateTime());
		userDetailInfo.setUpdateTime(pmsUser.getUpdateTime());

		PmsProfile pmsProfile = pmsProfileGateway.findByUserId(pmsUser.getUserId());
		ProfileInfo profileInfo = new ProfileInfo();
		profileInfo.setGender(pmsProfile.getGender());
		profileInfo.setAvatar(pmsProfile.getAvatar());
		profileInfo.setAddress(pmsProfile.getAddress());
		profileInfo.setEmail(pmsProfile.getEmail());
		profileInfo.setUserId(pmsProfile.getUserId());
		profileInfo.setNickName(pmsProfile.getNickName());
		userDetailInfo.setProfile(profileInfo);

		List<RoleInfo> roleInfos = pmsRoleQryExec.getRoleInfosByUserId(pmsUser.getUserId());
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
		PageRes<PmsUser> userPageResp = pmsUserGateway.listByPage(req);
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
			PmsProfile pmsProfile = pmsProfileGateway.findByUserId(item.getUserId());
			userPageInfo.setGender(pmsProfile.getGender());
			userPageInfo.setAvatar(pmsProfile.getAvatar());
			userPageInfo.setAddress(pmsProfile.getAddress());
			userPageInfo.setEmail(pmsProfile.getEmail());
			// 查询用户的角色
			userPageInfo.setRoles(pmsRoleQryExec.getRoleInfosByUserId(item.getUserId()));
			pageInfos.add(userPageInfo);
		});
		pageResp.setRecords(pageInfos);
		return pageResp;
	}

}
