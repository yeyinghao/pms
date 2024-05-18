/*
 * Copyright (c) Ye Yinghao
 * 2022.1 - 2024.1
 */

package com.luman.pms.adapter.pms.web;

import cn.hutool.core.lang.tree.Tree;
import com.luman.pms.adapter.pms.enums.PmsEnum;
import com.luman.pms.client.pms.api.PmsRoleManager;
import com.luman.pms.client.pms.model.info.PermissionInfo;
import com.luman.pms.client.pms.model.info.RoleInfo;
import com.luman.pms.client.pms.model.info.RolePageInfo;
import com.luman.pms.client.pms.model.req.*;
import com.luman.smy.common.helper.ResultHelper;
import com.luman.smy.common.model.PageRes;
import com.luman.smy.common.template.WebTemplate;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 角色控制器
 *
 * @author yeyinghao
 * @date 2024/01/13
 */
@RequestMapping("/api/role")
@RestController
@RequiredArgsConstructor
public class PmsRoleController {

	/**
	 * Pms角色Manager
	 */
	private final PmsRoleManager pmsRoleManager;

	/**
	 * 网页模板
	 */
	private final WebTemplate webTemplate;


	/**
	 * 创建
	 *
	 * @param req 请求
	 * @return {@link ResultHelper}<{@link Boolean}>
	 */
	@PostMapping
	public ResultHelper<Boolean> create(@RequestBody CreateRoleReq req) {
		webTemplate.execute(PmsEnum.ROLE_CREATE, () -> pmsRoleManager.createRole(req));
		return ResultHelper.success();
	}

	/**
	 * 更新
	 *
	 * @param req 请求
	 * @return {@link ResultHelper}<{@link Boolean}>
	 */
	@PatchMapping
	public ResultHelper<Boolean> update(@RequestBody UpdateRoleReq req) {
		webTemplate.execute(PmsEnum.ROLE_UPDATE, () -> pmsRoleManager.updateRole(req));
		return ResultHelper.success();
	}

	/**
	 * 找到通过id
	 *
	 * @param id id
	 * @return {@link ResultHelper}<{@link RoleInfo}>
	 */
	@GetMapping("/{id}")
	public ResultHelper<RoleInfo> findById(@PathVariable Long id) {
		return webTemplate.execute(PmsEnum.ROLE_FIND_BY_ID, () -> pmsRoleManager.findById(id));
	}

	/**
	 * 删除
	 *
	 * @param id id
	 * @return {@link ResultHelper}<{@link Boolean}>
	 */
	@DeleteMapping("/{id}")
	public ResultHelper<Boolean> remove(@PathVariable Long id) {
		webTemplate.execute(PmsEnum.ROLE_REMOVE, () -> pmsRoleManager.removeRole(id));
		return ResultHelper.success();
	}


	/**
	 * 找到所有
	 *
	 * @return {@link ResultHelper}<{@link List}<{@link RoleInfo}>>
	 */
	@GetMapping
	public ResultHelper<List<RoleInfo>> findAll() {
		return webTemplate.execute(PmsEnum.ROLE_FIND_ALL, pmsRoleManager::findAll);
	}

	/**
	 * 找到分页
	 *
	 * @param req 请求
	 * @return {@link ResultHelper}<{@link PageRes}<{@link RolePageInfo}>>
	 */
	@PostMapping("/page")
	public ResultHelper<PageRes<RolePageInfo>> page(@RequestBody RolePageReq req) {
		return webTemplate.execute(PmsEnum.ROLE_PAGE, () -> pmsRoleManager.queryPage(req));
	}

	/**
	 * 查找角色权限
	 *
	 * @param id id
	 * @return {@link ResultHelper}<{@link List}<{@link PermissionInfo}>>
	 */
	@GetMapping("/permissions")
	public ResultHelper<List<PermissionInfo>> findRolePermissions(Long id) {
		return webTemplate.execute(PmsEnum.ROLE_FIND_ROLE_PERMISSIONS, () -> pmsRoleManager.findRolePermissions(id));
	}

	/**
	 * 添加角色权限
	 *
	 * @param req 请求
	 * @return {@link ResultHelper}<{@link Boolean}>
	 */
	@PostMapping("/permissions/add")
	public ResultHelper<Boolean> addRolePermissions(@RequestBody AddRolePermissionsReq req) {
		webTemplate.execute(PmsEnum.ROLE_ADD_ROLE_PERMISSIONS, () -> pmsRoleManager.addRolePermissions(req));
		return ResultHelper.success();
	}

	/**
	 * 权限树
	 *
	 * @return {@link ResultHelper}<{@link List}<{@link Tree}<{@link Long}>>>
	 */
	@GetMapping("/permissions/tree")
	public ResultHelper<List<Tree<Long>>> permissionTree() {
		return webTemplate.execute(PmsEnum.ROLE_PERMISSION_TREE, pmsRoleManager::findRolePermissionsTree);
	}

	/**
	 * 添加角色用户
	 *
	 * @param req 请求
	 * @return {@link ResultHelper}<{@link Boolean}>
	 */
	@PatchMapping("/users/add")
	public ResultHelper<Boolean> addRoleUsers(@RequestBody AddRoleUsersReq req) {
		webTemplate.execute(PmsEnum.ROLE_ADD_ROLE_USERS, () -> pmsRoleManager.addRoleUsers(req));
		return ResultHelper.success();
	}

	/**
	 * @param req 请求
	 * @return {@link ResultHelper}<{@link Boolean}>
	 */
	@PatchMapping("/users/remove")
	public ResultHelper<Boolean> removeRoleUsers(@RequestBody RemoveRoleUsersReq req) {
		webTemplate.execute(PmsEnum.ROLE_REMOVE_ROLE_USERS, () -> pmsRoleManager.removeRoleUsers(req));
		return ResultHelper.success();
	}

}
