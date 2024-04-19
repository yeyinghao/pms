package com.luman.pms.application.pms.exec;

import cn.dev33.satoken.stp.StpUtil;
import cn.hutool.core.util.StrUtil;
import com.luman.pms.client.pms.model.req.ChangePasswordReq;
import com.luman.pms.client.pms.model.req.UpdatePasswordReq;
import com.luman.pms.client.pms.model.req.UpdateProfileReq;
import com.luman.pms.client.pms.model.req.UpdateUserReq;
import com.luman.pms.domain.pms.gateway.PmsProfileGateway;
import com.luman.pms.domain.pms.gateway.PmsUserGateway;
import com.luman.pms.domain.pms.model.PmsProfile;
import com.luman.pms.domain.pms.model.PmsUser;
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
	private final PmsUserGateway pmsUserDataService;

	/**
	 * Pms配置文件数据服务
	 */
	private final PmsProfileGateway pmsProfileDataService;

	/**
	 * 更改密码
	 *
	 * @param req 请求
	 */
	public void changePassword(ChangePasswordReq req) {
		String username = (String) StpUtil.getExtra(SaTokenConstant.JWT_USERNAME_KEY);
		PmsUser pmsUser = pmsUserDataService.findByName(username);
		Assert.notNull(pmsUser, CommErrorEnum.BIZ_ERROR);
		Assert.isTrue(StrUtil.equals(pmsUser.getPassword(), req.getOldPassword()), CommErrorEnum.BIZ_ERROR);
		pmsUser.setPassword(req.getNewPassword());
		pmsUserDataService.updateById(pmsUser);
		StpUtil.logout();
	}

	/**
	 * 重置密码
	 *
	 * @param req 请求
	 */
	public void resetPassword(UpdatePasswordReq req) {
		PmsUser pmsUser = pmsUserDataService.findById(req.getId());
		pmsUser.setPassword(req.getPassword());
		pmsUserDataService.updateById(pmsUser);
	}

	/**
	 * 更新配置文件
	 *
	 * @param req 请求
	 */
	public void updateProfile(UpdateProfileReq req) {
		Long userId = UserTokenUtil.getUserId();
		PmsProfile pmsProfile = PmsProfile.buildPmsProfile(userId, req);
		pmsProfileDataService.updateByUserId(pmsProfile);
	}

	/**
	 * 更新
	 *
	 * @param req 请求
	 */
	public void update(UpdateUserReq req) {
		PmsUser pmsUser = pmsUserDataService.findById(req.getId());
		pmsUser.setEnable(req.getEnable());
		pmsUserDataService.updateById(pmsUser);
	}
}
