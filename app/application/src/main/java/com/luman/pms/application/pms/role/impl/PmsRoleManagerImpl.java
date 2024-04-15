/*
 * Copyright (c) Ye Yinghao
 * 2022.1 - 2024.1
 */

package com.luman.pms.application.pms.role.impl;

import cn.hutool.core.lang.tree.Tree;
import com.luman.pms.application.pms.role.exec.PmsRoleAddExec;
import com.luman.pms.application.pms.role.exec.PmsRoleDeleteExec;
import com.luman.pms.application.pms.role.exec.PmsRoleUpdateExec;
import com.luman.pms.application.pms.role.exec.qry.PmsRoleQryExec;
import com.luman.pms.client.pms.api.PmsRoleManager;
import com.luman.pms.client.pms.dto.info.PermissionInfo;
import com.luman.pms.client.pms.dto.info.RoleInfo;
import com.luman.pms.client.pms.dto.info.RolePageInfo;
import com.luman.pms.client.pms.dto.req.*;
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
	private final PmsRoleAddExec pmsRoleAddExec;

	/**
	 * Pms角色更新执行
	 */
	private final PmsRoleUpdateExec pmsRoleUpdateExec;

	/**
	 * Pms角色删除执行
	 */
	private final PmsRoleDeleteExec pmsRoleDeleteExec;

	/**
	 * Pms角色qry执行
	 */
	private final PmsRoleQryExec pmsRoleQryExec;

	@Override
	public Boolean createRole(CreateRoleReq req) {
		return pmsRoleAddExec.createRole(req);
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
	public Boolean updateRole(UpdateRoleReq req) {
		return pmsRoleUpdateExec.updateRole(req);
	}

	@Override
	public Boolean removeRole(Long id) {
		return pmsRoleDeleteExec.removeRole(id);
	}

	@Override
	public Boolean addRolePermissions(AddRolePermissionsReq req) {
		return pmsRoleAddExec.addRolePermissions(req);
	}

	@Override
	public List<Tree<Long>> findRolePermissionsTree() {
		return pmsRoleQryExec.findRolePermissionsTree();
	}

	@Override
	public Boolean addRoleUsers(AddRoleUsersReq req) {
		return pmsRoleAddExec.addRoleUsers(req);
	}

	@Override
	public Boolean removeRoleUsers(RemoveRoleUsersReq req) {
		return pmsRoleDeleteExec.removeRoleUsers(req);
	}
}
