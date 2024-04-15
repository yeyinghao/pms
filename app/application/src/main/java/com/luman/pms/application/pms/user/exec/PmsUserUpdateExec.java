package com.luman.pms.application.pms.user.exec;

import cn.dev33.satoken.stp.StpUtil;
import cn.hutool.core.util.StrUtil;
import com.luman.pms.client.pms.dto.req.ChangePasswordReq;
import com.luman.pms.client.pms.dto.req.UpdatePasswordReq;
import com.luman.pms.client.pms.dto.req.UpdateProfileReq;
import com.luman.pms.client.pms.dto.req.UpdateUserReq;
import com.luman.pms.domain.pms.dp.PmsProfile;
import com.luman.pms.domain.pms.dp.PmsUser;
import com.luman.pms.infrastructure.pms.service.PmsProfileDataService;
import com.luman.pms.infrastructure.pms.service.PmsRoleDataService;
import com.luman.pms.infrastructure.pms.service.PmsUserDataService;
import com.luman.pms.infrastructure.pms.service.PmsUserRoleDataService;
import com.luman.pms.infrastructure.pms.util.UserTokenUtil;
import com.luman.smy.common.enums.CommErrorEnum;
import com.luman.smy.common.exception.Assert;
import com.luman.smy.token.constant.SaTokenConstant;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * Pms用户更新执行
 *
 * @author yeyinghao
 * @date 2024/04/15
 */
@Component
@RequiredArgsConstructor
public class PmsUserUpdateExec {

	/**
	 * Pms用户数据服务
	 */
	private final PmsUserDataService pmsUserDataService;

	/**
	 * Pms角色数据服务
	 */
	private final PmsRoleDataService pmsRoleDataService;

	/**
	 * Pms配置文件数据服务
	 */
	private final PmsProfileDataService pmsProfileDataService;

	/**
	 * Pms用户角色数据服务
	 */
	private final PmsUserRoleDataService pmsUserRoleDataService;

	/**
	 * 更改密码
	 *
	 * @param req 请求
	 * @return {@link Boolean}
	 */
	public Boolean changePassword(ChangePasswordReq req) {
		String username = (String) StpUtil.getExtra(SaTokenConstant.JWT_USERNAME_KEY);
		PmsUser pmsUser = pmsUserDataService.findByName(username);
		Assert.notNull(pmsUser, CommErrorEnum.BIZ_ERROR);
		Assert.isTrue(StrUtil.equals(pmsUser.getPassword(), req.getOldPassword()), CommErrorEnum.BIZ_ERROR);
		pmsUser.setPassword(req.getNewPassword());
		pmsUserDataService.updateById(pmsUser);
		StpUtil.logout();
		return Boolean.TRUE;
	}

	/**
	 * 重置密码
	 *
	 * @param req 请求
	 * @return {@link Boolean}
	 */
	public Boolean resetPassword(UpdatePasswordReq req) {
		PmsUser pmsUser = pmsUserDataService.findById(req.getId());
		pmsUser.setPassword(req.getPassword());
		pmsUserDataService.updateById(pmsUser);
		return Boolean.TRUE;
	}

	/**
	 * 更新配置文件
	 *
	 * @param req 请求
	 * @return {@link Boolean}
	 */
	public Boolean updateProfile(UpdateProfileReq req) {
		Long userId = UserTokenUtil.getUserId();
		PmsProfile pmsProfile = PmsProfile.buildPmsProfile(userId, req);
		pmsProfileDataService.updateByUserId(pmsProfile);
		return Boolean.TRUE;
	}

	/**
	 * 更新
	 *
	 * @param req 请求
	 * @return {@link Boolean}
	 */
	public Boolean update(UpdateUserReq req) {
		PmsUser pmsUser = pmsUserDataService.findById(req.getId());
		pmsUser.setEnable(req.getEnable());
		pmsUserDataService.updateById(pmsUser);
		return Boolean.TRUE;
	}
}
