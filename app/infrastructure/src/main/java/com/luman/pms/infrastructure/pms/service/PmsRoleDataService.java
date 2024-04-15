package com.luman.pms.infrastructure.pms.service;

import com.luman.pms.domain.pms.dp.PmsRole;
import com.luman.pms.infrastructure.pms.dataobject.PmsRolePO;
import com.luman.smy.dal.service.DataService;

/**
 * pms_role表数据库服务
 *
 * @author yeyinghao
 * @date 2024/04/14
 */
public interface PmsRoleDataService extends DataService<PmsRolePO, PmsRole> {
	PmsRole findByCodeOrName(String code, String name);

	PmsRole findByCode(String roleCode);
}
