package com.luman.pms.infrastructure.pms.service;

import com.luman.pms.domain.pms.dp.PmsUserRole;
import com.luman.pms.infrastructure.pms.dataobject.PmsUserRolePO;
import com.luman.smy.dal.service.DataService;

import java.util.List;

/**
 * pms_user_role表数据库服务
 *
 * @author yeyinghao
 * @date 2024/04/14
 */
public interface PmsUserRoleDataService extends DataService<PmsUserRolePO, PmsUserRole> {
	List<PmsUserRole> findRolesByUserId(Long userId);

	void removeByUserId(Long userId);

	List<PmsUserRole> findByRoleId(Long roleId);

	void removeRoleIdAndUserIds(Long roleId, List<Long> userIds);
}
