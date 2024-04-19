package com.luman.pms.application.pms.exec.qry;

import cn.hutool.core.lang.tree.Tree;
import com.luman.pms.client.pms.model.info.PermissionInfo;
import com.luman.pms.domain.pms.model.PmsPermission;
import com.luman.pms.domain.pms.gateway.PmsPermissionGateway;
import com.luman.pms.infrastructure.pms.util.PermissionUtil;
import com.luman.smy.common.util.CopyUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Pms权限qry执行
 *
 * @author yeyinghao
 * @date 2024/04/15
 */
@Component
@RequiredArgsConstructor
public class PmsPermissionQryExec {

	/**
	 * Pms权限数据服务
	 */
	private final PmsPermissionGateway pmsPermissionDataService;

	/**
	 * 查找所有菜单
	 *
	 * @return {@link List}<{@link PermissionInfo}>
	 */
	public List<PermissionInfo> findAllMenu() {
		List<PmsPermission> all = pmsPermissionDataService.findAll();
		return CopyUtil.copyList(all, PermissionInfo::new);
	}

	/**
	 * 查找所有菜单树
	 *
	 * @return {@link List}<{@link Tree}<{@link Long}>>
	 */
	public List<Tree<Long>> findAllMenuTree() {
		List<PmsPermission> all = pmsPermissionDataService.findAll();
		return PermissionUtil.toTreeNode(all, null);
	}

	/**
	 * 找到由id
	 *
	 * @param id id
	 * @return {@link PermissionInfo}
	 */
	public PermissionInfo findById(Long id) {
		PmsPermission byId = pmsPermissionDataService.findById(id);
		return CopyUtil.copy(byId, PermissionInfo::new);
	}

	/**
	 * 查找按钮和API
	 *
	 * @param parentId 家长。id
	 * @return {@link List}<{@link PermissionInfo}>
	 */
	public List<PermissionInfo> findButtonAndApi(Long parentId) {
		return CopyUtil.copyList(pmsPermissionDataService.findButtonAndApi(), PermissionInfo::new);
	}

	/**
	 * 验证菜单路径
	 *
	 * @param path 路径
	 */
	public void validateMenuPath(String path) {
		pmsPermissionDataService.validateMenuPath(path);
	}
}
