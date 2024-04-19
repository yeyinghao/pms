package com.luman.pms.domain.pms.gateway;

import com.luman.pms.domain.pms.model.PmsUserRole;
import com.luman.smy.common.gateway.Gateway;

import java.util.List;

/**
 * pms_user_role表数据库服务
 *
 * @author yeyinghao
 * @date 2024/04/14
 */
public interface PmsUserRoleGateway extends Gateway<PmsUserRole> {
	List<PmsUserRole> findRolesByUserId(Long userId);

	void removeByUserId(Long userId);

	List<PmsUserRole> findByRoleId(Long roleId);

	void removeRoleIdAndUserIds(Long roleId, List<Long> userIds);
}
