/*
 * Copyright (c) Ye Yinghao
 * 2022.1 - 2024.1
 */

package com.luman.pms.client.pms.api;

import cn.hutool.core.lang.tree.Tree;
import com.luman.pms.client.pms.model.info.PermissionInfo;
import com.luman.pms.client.pms.model.req.CreatePermissionReq;
import com.luman.pms.client.pms.model.req.UpdatePermissionReq;

import java.util.List;

/**
 * Pms许可Manager
 *
 * @author yeyinghao
 * @date 2024/01/12
 */
public interface PmsPermissionManager {
	/**
	 * 创建
	 *
	 * @param req 请求
	 */
	void create(CreatePermissionReq req);

	/**
	 * 创建批处理
	 *
	 * @param reqs 请求
	 */
	void createBatch(List<CreatePermissionReq> reqs);

	/**
	 * 查找所有菜单
	 *
	 * @return {@link List}<{@link PermissionInfo}>
	 */
	List<PermissionInfo> findAllMenu();

	/**
	 * 查找所有菜单树
	 *
	 * @return {@link List}<{@link Tree}<{@link Long}>>
	 */
	List<Tree<Long>> findAllMenuTree();

	/**
	 * 找到由id
	 *
	 * @param id id
	 * @return {@link PermissionInfo}
	 */
	PermissionInfo findById(Long id);

	/**
	 * 更新由id
	 *
	 * @param req 请求
	 */
	void updateById(UpdatePermissionReq req);

	/**
	 * 删除
	 *
	 * @param id id
	 */
	void remove(Long id);

	/**
	 * @param parentId parentid
	 * @return {@link List}<{@link PermissionInfo}>
	 */
	List<PermissionInfo> findButtonByParentId(Long parentId);

	/**
	 * 验证菜单路径
	 *
	 * @param path 路径
	 */
	void validateMenuPath(String path);

}
