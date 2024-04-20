package com.luman.pms.application.pms.exec.qry;

import cn.hutool.core.lang.tree.Tree;
import com.luman.pms.application.pms.convert.PermissionConvert;
import com.luman.pms.client.pms.model.info.PermissionInfo;
import com.luman.pms.domain.pms.enums.PermissionTypeEnum;
import com.luman.pms.domain.pms.gateway.PmsPermissionGateway;
import com.luman.pms.domain.pms.model.PmsPermission;
import com.luman.smy.common.enums.CommErrorEnum;
import com.luman.smy.common.exception.Assert;
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
		List<PmsPermission> all = pmsPermissionDataService.findAllMenu(PermissionTypeEnum.MENU);
		return PermissionConvert.buildTreeNode(all, null);
	}

	/**
	 * 找到由id
	 *
	 * @param id id
	 * @return {@link PermissionInfo}
	 */
	public PermissionInfo findById(Long id) {
		PmsPermission permission = pmsPermissionDataService.findById(id);
		return CopyUtil.copy(permission, PermissionInfo::new);
	}

	/**
	 * 查找按钮和API
	 *
	 * @param parentId 家长。id
	 * @return {@link List}<{@link PermissionInfo}>
	 */
	public List<PermissionInfo> findButtonByParentId(Long parentId) {
		List<PmsPermission> permissionList = pmsPermissionDataService.findButtonByParentId(parentId, PermissionTypeEnum.BUTTON);
		return CopyUtil.copyList(permissionList, PermissionInfo::new);
	}

	/**
	 * 验证菜单路径
	 *
	 * @param path 路径
	 */
	public void validateMenuPath(String path) {
		Boolean isExists = pmsPermissionDataService.validateMenuPath(path);
		Assert.isTrue(isExists, CommErrorEnum.BIZ_ERROR, "路径不合法");
	}
}
