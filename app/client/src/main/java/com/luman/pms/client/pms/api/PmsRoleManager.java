/*
 * Copyright (c) Ye Yinghao
 * 2022.1 - 2024.1
 */

package com.luman.pms.client.pms.api;

import cn.hutool.core.lang.tree.Tree;
import com.luman.pms.client.pms.dto.info.PermissionInfo;
import com.luman.pms.client.pms.dto.info.RoleInfo;
import com.luman.pms.client.pms.dto.info.RolePageInfo;
import com.luman.pms.client.pms.dto.req.*;
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
	 * @return {@link Boolean}
	 */
	Boolean createRole(CreateRoleReq req);

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
	 * @param req 请求
	 * @return {@link Boolean}
	 */
	Boolean updateRole(UpdateRoleReq req);

	/**
	 * @param id id
	 * @return {@link Boolean}
	 */
	Boolean removeRole(Long id);

	/**
	 * @param req 请求
	 * @return {@link Boolean}
	 */
	Boolean addRolePermissions(AddRolePermissionsReq req);

	/**
	 * @return {@link List}<{@link Tree}<{@link Long}>>
	 */
	List<Tree<Long>> findRolePermissionsTree();


	/**
	 * @param req 请求
	 * @return {@link Boolean}
	 */
	Boolean addRoleUsers(AddRoleUsersReq req);

	/**
	 * @param req 请求
	 * @return {@link Boolean}
	 */
	Boolean removeRoleUsers(RemoveRoleUsersReq req);
}
