/*
 * Copyright (c) Ye Yinghao
 * 2022.1 - 2024.1
 */

package com.luman.pms.application.pms.permission.impl;

import cn.hutool.core.lang.tree.Tree;
import com.luman.pms.application.pms.permission.exec.PmsPermissionAddExec;
import com.luman.pms.application.pms.permission.exec.PmsPermissionDeleteExec;
import com.luman.pms.application.pms.permission.exec.PmsPermissionUpdateExec;
import com.luman.pms.application.pms.permission.exec.qry.PmsPermissionQryExec;
import com.luman.pms.client.pms.api.PmsPermissionManager;
import com.luman.pms.client.pms.dto.info.PermissionInfo;
import com.luman.pms.client.pms.dto.req.CreatePermissionReq;
import com.luman.pms.client.pms.dto.req.UpdatePermissionReq;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Pms权限Manager实现
 *
 * @author yeyinghao
 * @date 2024/04/15
 */
@Service
@RequiredArgsConstructor
public class PmsPermissionManagerImpl implements PmsPermissionManager {

	/**
	 * Pms权限添加执行
	 */
	private final PmsPermissionAddExec pmsPermissionAddExec;

	/**
	 * Pms权限删除执行
	 */
	private final PmsPermissionDeleteExec pmsPermissionDeleteExec;

	/**
	 * Pms权限更新执行
	 */
	private final PmsPermissionUpdateExec pmsPermissionUpdateExec;

	/**
	 * Pms权限qry执行
	 */
	private final PmsPermissionQryExec pmsPermissionQryExec;

	@Override
	public Boolean create(CreatePermissionReq req) {
		return pmsPermissionAddExec.create(req);
	}

	@Override
	public Boolean createBatch(List<CreatePermissionReq> reqs) {
		return pmsPermissionAddExec.createBatch(reqs);
	}

	@Override
	public List<PermissionInfo> findAllMenu() {
		return pmsPermissionQryExec.findAllMenu();
	}

	@Override
	public List<Tree<Long>> findAllMenuTree() {
		return pmsPermissionQryExec.findAllMenuTree();
	}

	@Override
	public PermissionInfo findById(Long id) {
		return pmsPermissionQryExec.findById(id);
	}

	@Override
	public List<PermissionInfo> findButtonAndApi(Long parentId) {
		return pmsPermissionQryExec.findButtonAndApi(parentId);
	}

	@Override
	public Boolean validateMenuPath(String path) {
		return pmsPermissionQryExec.validateMenuPath(path);
	}

	@Override
	public Boolean updateById(UpdatePermissionReq req) {
		return pmsPermissionUpdateExec.updateById(req);
	}

	@Override
	public Boolean remove(Long id) {
		return pmsPermissionDeleteExec.remove(id);
	}


}
