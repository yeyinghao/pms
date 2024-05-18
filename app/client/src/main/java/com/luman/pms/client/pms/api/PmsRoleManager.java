/*
 * Copyright (c) Ye Yinghao
 * 2022.1 - 2024.1
 */

package com.luman.pms.client.pms.api;

import cn.hutool.core.lang.tree.Tree;
import com.luman.pms.client.pms.model.info.PermissionInfo;
import com.luman.pms.client.pms.model.info.RoleInfo;
import com.luman.pms.client.pms.model.info.RolePageInfo;
import com.luman.pms.client.pms.model.req.*;
import com.luman.smy.common.model.PageRes;

import java.util.List;

/**
 * Pms角色Manager
 *
 * @author yeyinghao
 * @date 2024/01/12
 */
public interface PmsRoleManager {
	/**
	 * 创建角色
	 *
	 * @param req 请求
	 */
	void createRole(CreateRoleReq req);

	/**
	 * 找到所有
	 *
	 * @return {@link List}<{@link RoleInfo}>
	 */
	List<RoleInfo> findAll();

	/**
	 * 查询页面
	 *
	 * @param req 请求
	 * @return {@link PageRes}<{@link RolePageInfo}>
	 */
	PageRes<RolePageInfo> queryPage(RolePageReq req);

	/**
	 * 查找角色权限
	 *
	 * @param id id
	 * @return {@link List}<{@link PermissionInfo}>
	 */
	List<PermissionInfo> findRolePermissions(Long id);

	/**
	 * 找到byid
	 *
	 * @param id id
	 * @return {@link RoleInfo}
	 */
	RoleInfo findById(Long id);

	/**
	 * 更新作用
	 *
	 * @param req 请求
	 */
	void updateRole(UpdateRoleReq req);

	/**
	 * 删除角色
	 *
	 * @param id id
	 */
	void removeRole(Long id);

	/**
	 * 添加角色权限
	 *
	 * @param req 请求
	 */
	void addRolePermissions(AddRolePermissionsReq req);

	/**
	 * 查找角色权限树
	 *
	 * @return {@link List}<{@link Tree}<{@link Long}>>
	 */
	List<Tree<Long>> findRolePermissionsTree();

	/**
	 * 添加角色用户
	 *
	 * @param req 请求
	 */
	void addRoleUsers(AddRoleUsersReq req);

	/**
	 * 删除角色用户
	 *
	 * @param req 请求
	 */
	void removeRoleUsers(RemoveRoleUsersReq req);

	/**
	 * 更新角色状态
	 *
	 * @param req 请求
	 */
	void updateRoleStatus(UpdateRoleStatusReq req);
}
