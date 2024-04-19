package com.luman.pms.domain.pms.gateway;

import com.luman.pms.domain.pms.model.PmsRole;
import com.luman.smy.common.gateway.Gateway;

/**
 * pms_role表数据库服务
 *
 * @author yeyinghao
 * @date 2024/04/14
 */
public interface PmsRoleGateway extends Gateway<PmsRole> {
	PmsRole findByCodeOrName(String code, String name);

	PmsRole findByCode(String roleCode);
}
