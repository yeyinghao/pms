/*
 * Copyright (c) Ye Yinghao
 * 2022.1 - 2024.1
 */

package com.luman.pms.adapter.pms.web;

import cn.hutool.core.lang.tree.Tree;
import com.luman.pms.adapter.enums.UserEnum;
import com.luman.pms.client.pms.api.PmsPermissionManager;
import com.luman.pms.client.pms.dto.info.PermissionInfo;
import com.luman.pms.client.pms.dto.req.CreatePermissionReq;
import com.luman.pms.client.pms.dto.req.UpdatePermissionReq;
import com.luman.pms.domain.pms.dp.PmsPermission;
import com.luman.smy.common.helper.ResultHelper;
import com.luman.smy.common.template.WebTemplate;
import lombok.RequiredArgsConstructor;
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
public class PmsPermissionController {

	/**
	 * Pms许可Manager
	 */
	private final PmsPermissionManager pmsPermissionManager;

	/**
	 * Web模板
	 */
	private final WebTemplate webTemplate;

	/**
	 * 创建
	 *
	 * @param req 请求
	 * @return {@link ResultHelper}<{@link Boolean}>
	 */
	@PostMapping
	public ResultHelper<Boolean> create(@RequestBody CreatePermissionReq req) {
		return webTemplate.execute(UserEnum.GET_USERS, () -> pmsPermissionManager.create(req));
	}

	/**
	 * 批量创建
	 *
	 * @param reqs 请求
	 * @return {@link ResultHelper}<{@link Boolean}>
	 */
	@PostMapping("/batch")
	public ResultHelper<Boolean> batchCreate(@RequestBody List<CreatePermissionReq> reqs) {
		return webTemplate.execute(UserEnum.GET_USERS, () -> pmsPermissionManager.createBatch(reqs));
	}

	/**
	 * 找到所有
	 *
	 * @return {@link ResultHelper}<{@link List}<{@link PermissionInfo}>>
	 */
	@GetMapping
	public ResultHelper<List<PermissionInfo>> findAll() {
		return webTemplate.execute(UserEnum.GET_USERS, () -> pmsPermissionManager.findAllMenu());
	}

	/**
	 * 查找菜单树
	 *
	 * @return {@link ResultHelper}<{@link List}<{@link Tree}<{@link Long}>>>
	 */
	@GetMapping("menu/tree")
	public ResultHelper<List<Tree<Long>>> findMenuTree() {
		return webTemplate.execute(UserEnum.GET_USERS, () -> pmsPermissionManager.findAllMenuTree());
	}

	/**
	 * 找到通过id
	 *
	 * @param id id
	 * @return {@link ResultHelper}<{@link PermissionInfo}>
	 */
	@GetMapping("/{id}")
	public ResultHelper<PermissionInfo> findById(@PathVariable Long id) {
		return webTemplate.execute(UserEnum.GET_USERS, () -> pmsPermissionManager.findById(id));
	}

	/**
	 * 更新
	 *
	 * @param req 请求
	 * @return {@link ResultHelper}<{@link Boolean}>
	 */
	@PatchMapping
	public ResultHelper<Boolean> update(@RequestBody UpdatePermissionReq req) {
		return webTemplate.execute(UserEnum.GET_USERS, () -> pmsPermissionManager.updateById(req));
	}

	/**
	 * 删除
	 *
	 * @param id id
	 * @return {@link ResultHelper}<{@link Boolean}>
	 */
	@DeleteMapping("/{id}")
	public ResultHelper<Boolean> remove(@PathVariable Long id) {
		return webTemplate.execute(UserEnum.GET_USERS, () -> pmsPermissionManager.remove(id));
	}

	/**
	 * 查找按钮和API
	 *
	 * @param parentId parentid
	 * @return {@link ResultHelper}<{@link List}<{@link PmsPermission}>>
	 */
	@GetMapping("/button-and-api/{parentId}")
	public ResultHelper<List<PermissionInfo>> findButtonAndApi(@PathVariable Long parentId) {
		return webTemplate.execute(UserEnum.GET_USERS, () -> pmsPermissionManager.findButtonAndApi(parentId));
	}

	/**
	 * 验证菜单路径
	 *
	 * @param path 路径
	 * @return {@link ResultHelper}<{@link Boolean}>
	 */
	@GetMapping("/menu/validate")
	public ResultHelper<Boolean> validateMenuPath(String path) {
		return webTemplate.execute(UserEnum.GET_USERS, () -> pmsPermissionManager.validateMenuPath(path));
	}

}