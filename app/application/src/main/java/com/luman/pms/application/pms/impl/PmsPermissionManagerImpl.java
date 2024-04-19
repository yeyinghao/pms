/*
 * Copyright (c) Ye Yinghao
 * 2022.1 - 2024.1
 */

package com.luman.pms.application.pms.impl;

import cn.hutool.core.lang.tree.Tree;
import com.luman.pms.application.pms.exec.PmsPermissionAddExec;
import com.luman.pms.application.pms.exec.PmsPermissionDeleteExec;
import com.luman.pms.application.pms.exec.PmsPermissionUpdateExec;
import com.luman.pms.application.pms.exec.qry.PmsPermissionQryExec;
import com.luman.pms.client.pms.api.PmsPermissionManager;
import com.luman.pms.client.pms.model.info.PermissionInfo;
import com.luman.pms.client.pms.model.req.CreatePermissionReq;
import com.luman.pms.client.pms.model.req.UpdatePermissionReq;
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
	public void create(CreatePermissionReq req) {
		 pmsPermissionAddExec.create(req);
	}

	@Override
	public void createBatch(List<CreatePermissionReq> reqs) {
		 pmsPermissionAddExec.createBatch(reqs);
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
	public void validateMenuPath(String path) {
		 pmsPermissionQryExec.validateMenuPath(path);
	}

	@Override
	public void updateById(UpdatePermissionReq req) {
		 pmsPermissionUpdateExec.updateById(req);
	}

	@Override
	public void remove(Long id) {
		 pmsPermissionDeleteExec.remove(id);
	}
}
