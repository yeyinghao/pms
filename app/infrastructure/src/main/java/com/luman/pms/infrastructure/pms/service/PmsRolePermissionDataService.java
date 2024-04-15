package com.luman.pms.infrastructure.pms.service;

import com.luman.pms.domain.pms.dp.PmsRolePermission;
import com.luman.pms.infrastructure.pms.dataobject.PmsRolePermissionPO;
import com.luman.smy.dal.service.DataService;

import java.util.List;

/**
 * pms_role_permission表数据库服务
 *
 * @author yeyinghao
 * @date 2024/04/14
 */
public interface PmsRolePermissionDataService extends DataService<PmsRolePermissionPO, PmsRolePermission> {
	List<PmsRolePermission> findByRoleId(Long roleId);

	void removeByRoleId(Long roleId);
}
