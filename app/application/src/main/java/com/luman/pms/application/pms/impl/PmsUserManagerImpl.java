/*
 * Copyright (c) Ye Yinghao
 * 2022.1 - 2024.1
 */

package com.luman.pms.application.pms.impl;

import com.luman.pms.application.pms.exec.PmsUserAddExec;
import com.luman.pms.application.pms.exec.PmsUserDeleteExec;
import com.luman.pms.application.pms.exec.PmsUserUpdateExec;
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
	private final PmsUserAddExec pmsUserAddExec;

	/**
	 * Pms用户删除执行
	 */
	private final PmsUserDeleteExec pmsUserDeleteExec;

	/**
	 * Pms用户更新执行
	 */
	private final PmsUserUpdateExec pmsUserUpdateExec;

	/**
	 * Pms用户qry执行
	 */
	private final PmsUserQryExec pmsUserQryExec;

	@Override
	public void register(RegisterUserReq req) {
		pmsUserAddExec.register(req);
	}

	@Override
	public void resetPassword(UpdatePasswordReq req) {
		pmsUserUpdateExec.resetPassword(req);
	}

	@Override
	public void addRoles(AddUserRolesReq req) {
		pmsUserAddExec.addRoles(req);
	}

	@Override
	public UserDetailInfo detail() {
		return pmsUserQryExec.detail();
	}

	@Override
	public void updateProfile(UpdateProfileReq req) {
		pmsUserUpdateExec.updateProfile(req);
	}

	@Override
	public void removeUser(Long id) {
		pmsUserDeleteExec.removeUser(id);
	}

	@Override
	public PageRes<UserPageInfo> queryPage(UserPageReq req) {
		return pmsUserQryExec.queryPage(req);
	}

	@Override
	public void update(UpdateUserReq req) {
		pmsUserUpdateExec.update(req);
	}
}
