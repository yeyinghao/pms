/*
 * Copyright (c) Ye Yinghao
 * 2022.1 - 2024.1
 */

package com.luman.pms.application.pms.impl;

import com.luman.pms.application.pms.exec.PmsUserExec;
import com.luman.pms.application.pms.exec.qry.PmsUserQryExec;
import com.luman.pms.client.pms.api.PmsUserManager;
import com.luman.pms.client.pms.model.info.UserDetailInfo;
import com.luman.pms.client.pms.model.info.UserPageInfo;
import com.luman.pms.client.pms.model.req.*;
import com.luman.smy.common.model.PageRes;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * Pms用户Manager实现
 *
 * @author yeyinghao
 * @date 2024/04/15
 */
@Service
@RequiredArgsConstructor
public class PmsUserManagerImpl implements PmsUserManager {

	/**
	 * Pms用户添加执行
	 */
	private final PmsUserExec userExec;

	/**
	 * Pms用户qry执行
	 */
	private final PmsUserQryExec pmsUserQryExec;

	@Override
	public void register(RegisterUserReq req) {
		userExec.register(req);
	}

	@Override
	public void resetPassword(UpdatePasswordReq req) {
		userExec.resetPassword(req);
	}

	@Override
	public void addRoles(AddUserRolesReq req) {
		userExec.addRoles(req);
	}

	@Override
	public UserDetailInfo detail() {
		return pmsUserQryExec.detail();
	}

	@Override
	public void updateProfile(UpdateProfileReq req) {
		userExec.updateProfile(req);
	}

	@Override
	public void removeUser(Long id) {
		userExec.removeUser(id);
	}

	@Override
	public PageRes<UserPageInfo> queryPage(UserPageReq req) {
		return pmsUserQryExec.queryPage(req);
	}

	@Override
	public void update(UpdateUserReq req) {
		userExec.update(req);
	}
}
