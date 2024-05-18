package com.luman.pms.domain.pms.gateway;

import com.luman.pms.domain.pms.enums.PermissionTypeEnum;
import com.luman.pms.domain.pms.model.PmsPermission;
import com.luman.smy.common.gateway.Gateway;

import java.util.List;

/**
 * pms_permission表数据库服务
 *
 * @author yeyinghao
 * @date 2024/04/14
 */
public interface PmsPermissionGateway extends Gateway<PmsPermission> {

	/**
	 * 验证菜单路径
	 *
	 * @param path 路径
	 * @return {@link Boolean }
	 */
	Boolean validateMenuPath(String path);

	/**
	 * 找到按钮通过家长id
	 *
	 * @param parentId       家长id
	 * @param permissionType 权限类型
	 * @return {@link List }<{@link PmsPermission }>
	 */
	List<PmsPermission> findButtonByParentId(Long parentId, PermissionTypeEnum permissionType);

	/**
	 * 查找所有菜单
	 *
	 * @param permissionType 权限类型
	 * @return {@link List }<{@link PmsPermission }>
	 */
	List<PmsPermission> findAllMenu(PermissionTypeEnum permissionType);

}
