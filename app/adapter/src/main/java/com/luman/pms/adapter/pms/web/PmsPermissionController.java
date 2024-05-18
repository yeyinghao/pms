/*
 * Copyright (c) Ye Yinghao
 * 2022.1 - 2024.1
 */

package com.luman.pms.adapter.pms.web;

import cn.hutool.core.lang.tree.Tree;
import com.luman.pms.adapter.pms.enums.PmsEnum;
import com.luman.pms.client.pms.api.PmsPermissionManager;
import com.luman.pms.client.pms.model.info.PermissionInfo;
import com.luman.pms.client.pms.model.req.CreatePermissionReq;
import com.luman.pms.client.pms.model.req.UpdatePermissionReq;
import com.luman.pms.domain.pms.model.PmsPermission;
import com.luman.smy.common.constant.LoggerConstant;
import com.luman.smy.common.helper.ResultHelper;
import com.luman.smy.common.template.ExecuteTemplate;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 权限控制器
 *
 * @author yeyinghao
 * @date 2024/01/13
 */
@RequestMapping("/api/permission")
@RestController
@RequiredArgsConstructor
@Slf4j(topic = LoggerConstant.WEB_MONITOR_LOGGER)
public class PmsPermissionController {

	/**
	 * Pms许可Manager
	 */
	private final PmsPermissionManager pmsPermissionManager;

	/**
	 * Web模板
	 */
	private final ExecuteTemplate executeTemplate;

	/**
	 * 创建
	 *
	 * @param req 请求
	 * @return {@link ResultHelper}<{@link Boolean}>
	 */
	@PostMapping
	public ResultHelper<Boolean> create(@RequestBody CreatePermissionReq req) {
		executeTemplate.execute(log, PmsEnum.PERMISSION_CREATE, () -> pmsPermissionManager.create(req));
		return ResultHelper.success();
	}

	/**
	 * 批量创建
	 *
	 * @param reqs 请求
	 * @return {@link ResultHelper}<{@link Boolean}>
	 */
	@PostMapping("/batch")
	public ResultHelper<Boolean> batchCreate(@RequestBody List<CreatePermissionReq> reqs) {
		executeTemplate.execute(log, PmsEnum.PERMISSION_BATCH_CREATE, () -> pmsPermissionManager.createBatch(reqs));
		return ResultHelper.success();
	}

	/**
	 * 找到所有
	 *
	 * @return {@link ResultHelper}<{@link List}<{@link PermissionInfo}>>
	 */
	@GetMapping
	public ResultHelper<List<PermissionInfo>> findAll() {
		List<PermissionInfo> res = executeTemplate.execute(log, PmsEnum.PERMISSION_FIND_ALL, pmsPermissionManager::findAllMenu);
		return ResultHelper.of(res);
	}

	/**
	 * 查找菜单树
	 *
	 * @return {@link ResultHelper}<{@link List}<{@link Tree}<{@link Long}>>>
	 */
	@GetMapping("menu/tree")
	public ResultHelper<List<Tree<Long>>> findMenuTree() {
		List<Tree<Long>> res = executeTemplate.execute(log, PmsEnum.PERMISSION_FIND_MENU_TREE, pmsPermissionManager::findAllMenuTree);
		return ResultHelper.of(res);
	}

	/**
	 * 找到通过id
	 *
	 * @param id id
	 * @return {@link ResultHelper}<{@link PermissionInfo}>
	 */
	@GetMapping("/{id}")
	public ResultHelper<PermissionInfo> findById(@PathVariable Long id) {
		PermissionInfo res = executeTemplate.execute(log, PmsEnum.PERMISSION_FIND_BY_ID, () -> pmsPermissionManager.findById(id));
		return ResultHelper.of(res);
	}

	/**
	 * 更新
	 *
	 * @param req 请求
	 * @return {@link ResultHelper}<{@link Boolean}>
	 */
	@PatchMapping
	public ResultHelper<Boolean> update(@RequestBody UpdatePermissionReq req) {
		executeTemplate.execute(log, PmsEnum.PERMISSION_UPDATE, () -> pmsPermissionManager.updateById(req));
		return ResultHelper.success();
	}

	/**
	 * 删除
	 *
	 * @param id id
	 * @return {@link ResultHelper}<{@link Boolean}>
	 */
	@DeleteMapping("/{id}")
	public ResultHelper<Boolean> remove(@PathVariable Long id) {
		executeTemplate.execute(log, PmsEnum.PERMISSION_REMOVE, () -> pmsPermissionManager.remove(id));
		return ResultHelper.success();
	}

	/**
	 * 查找按钮和API
	 *
	 * @param parentId parentid
	 * @return {@link ResultHelper}<{@link List}<{@link PmsPermission}>>
	 */
	@GetMapping("/button/{parentId}")
	public ResultHelper<List<PermissionInfo>> findButtonByParentId(@PathVariable Long parentId) {
		List<PermissionInfo> res = executeTemplate.execute(log, PmsEnum.PERMISSION_FIND_BUTTON_BY_PARENT_ID, () -> pmsPermissionManager.findButtonByParentId(parentId));
		return ResultHelper.of(res);
	}

	/**
	 * 验证菜单路径
	 *
	 * @param path 路径
	 * @return {@link ResultHelper}<{@link Boolean}>
	 */
	@GetMapping("/menu/validate")
	public ResultHelper<Boolean> validateMenuPath(String path) {
		executeTemplate.execute(log, PmsEnum.PERMISSION_VALIDATE_MENU_PATH, () -> pmsPermissionManager.validateMenuPath(path));
		return ResultHelper.success();
	}

}
