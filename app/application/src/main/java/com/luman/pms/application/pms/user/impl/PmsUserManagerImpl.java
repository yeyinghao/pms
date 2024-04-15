/*
 * Copyright (c) Ye Yinghao
 * 2022.1 - 2024.1
 */

package com.luman.pms.application.pms.user.impl;

import com.luman.pms.application.pms.user.exec.PmsUserAddExec;
import com.luman.pms.application.pms.user.exec.PmsUserDeleteExec;
import com.luman.pms.application.pms.user.exec.PmsUserUpdateExec;
import com.luman.pms.application.pms.user.exec.qry.PmsUserQryExec;
import com.luman.pms.client.pms.api.PmsUserManager;
import com.luman.pms.client.pms.dto.info.UserDetailInfo;
import com.luman.pms.client.pms.dto.info.UserPageInfo;
import com.luman.pms.client.pms.dto.req.*;
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
	public Boolean register(RegisterUserReq req) {
		return pmsUserAddExec.register(req);
	}

	@Override
	public Boolean resetPassword(UpdatePasswordReq req) {
		return pmsUserUpdateExec.resetPassword(req);
	}

	@Override
	public Boolean addRoles(AddUserRolesReq req) {
		return pmsUserAddExec.addRoles(req);
	}

	@Override
	public UserDetailInfo detail() {
		return pmsUserQryExec.detail();
	}

	@Override
	public Boolean updateProfile(UpdateProfileReq req) {
		return pmsUserUpdateExec.updateProfile(req);
	}

	@Override
	public Boolean removeUser(Long id) {
		return pmsUserDeleteExec.removeUser(id);
	}

	@Override
	public PageRes<UserPageInfo> queryPage(UserPageReq req) {
		return pmsUserQryExec.queryPage(req);
	}

	@Override
	public Boolean update(UpdateUserReq req) {
		return pmsUserUpdateExec.update(req);
	}
}
