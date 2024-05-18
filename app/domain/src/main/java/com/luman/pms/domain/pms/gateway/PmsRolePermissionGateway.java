package com.luman.pms.domain.pms.gateway;

import com.luman.pms.domain.pms.model.PmsRolePermission;
import com.luman.smy.common.gateway.Gateway;

import java.util.List;

/**
 * pms_role_permission表数据库服务
 *
 * @author yeyinghao
 * @date 2024/04/14
 */
public interface PmsRolePermissionGateway extends Gateway< PmsRolePermission> {
	/**
	 * 找到通过角色id
	 *
	 * @param roleId 角色id
	 * @return {@link List }<{@link PmsRolePermission }>
	 */
	List<PmsRolePermission> findByRoleId(Long roleId);

	/**
	 * 删除通过角色id
	 *
	 * @param roleId 角色id
	 */
	void removeByRoleId(Long roleId);
}
