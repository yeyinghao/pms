/*
 * Copyright (c) Ye Yinghao
 * 2022.1 - 2024.1
 */

package com.luman.pms.application.pms.impl;

import cn.hutool.core.lang.tree.Tree;
import com.luman.pms.application.pms.exec.PmsRoleExec;
import com.luman.pms.application.pms.exec.qry.PmsRoleQryExec;
import com.luman.pms.client.pms.api.PmsRoleManager;
import com.luman.pms.client.pms.model.info.PermissionInfo;
import com.luman.pms.client.pms.model.info.RoleInfo;
import com.luman.pms.client.pms.model.info.RolePageInfo;
import com.luman.pms.client.pms.model.req.*;
import com.luman.smy.common.model.PageRes;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * Pms角色Manager实现
 *
 * @author yeyinghao
 * @date 2024/04/15
 */
@Service
@RequiredArgsConstructor
public class PmsRoleManagerImpl implements PmsRoleManager {

	/**
	 * Pms角色添加执行
	 */
	private final PmsRoleExec pmsRoleExec;

	/**
	 * Pms角色qry执行
	 */
	private final PmsRoleQryExec pmsRoleQryExec;

	@Override
	public void createRole(CreateRoleReq req) {
		pmsRoleExec.createRole(req);
	}

	@Override
	public List<RoleInfo> findAll() {
		return pmsRoleQryExec.findAll();
	}

	@Override
	public PageRes<RolePageInfo> queryPage(RolePageReq req) {
		return pmsRoleQryExec.queryPage(req);
	}

	@Override
	public List<PermissionInfo> findRolePermissions(Long id) {
		return pmsRoleQryExec.findRolePermissions(id);
	}

	@Override
	public RoleInfo findById(Long id) {
		return pmsRoleQryExec.findById(id);
	}

	@Override
	public void updateRole(UpdateRoleReq req) {
		pmsRoleExec.updateRole(req);
	}

	@Override
	public void removeRole(Long id) {
		pmsRoleExec.removeRole(id);
	}

	@Override
	public void addRolePermissions(AddRolePermissionsReq req) {
		pmsRoleExec.addRolePermissions(req);
	}

	@Override
	public List<Tree<Long>> findRolePermissionsTree() {
		return pmsRoleQryExec.findRolePermissionsTree();
	}

	@Override
	public void addRoleUsers(AddRoleUsersReq req) {
		pmsRoleExec.addRoleUsers(req);
	}

	@Override
	public void removeRoleUsers(RemoveRoleUsersReq req) {
		pmsRoleExec.removeRoleUsers(req);
	}

	@Override
	public void updateRoleStatus(UpdateRoleStatusReq req) {
		pmsRoleExec.updateRoleStatus(req);
	}
}
