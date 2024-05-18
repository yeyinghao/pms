package com.luman.pms.domain.pms.gateway;

import com.luman.pms.domain.pms.model.PmsRole;
import com.luman.smy.common.gateway.Gateway;

import java.util.List;

/**
 * pms_role表数据库服务
 *
 * @author yeyinghao
 * @date 2024/04/14
 */
public interface PmsRoleGateway extends Gateway<PmsRole> {
	/**
	 * 找到通过代码或名称
	 *
	 * @param code 代码
	 * @param name 名称
	 * @return {@link PmsRole }
	 */
	PmsRole findByCodeOrName(String code, String name);

	/**
	 * 按代码查找
	 *
	 * @param roleCode 角色代码
	 * @return {@link PmsRole }
	 */
	PmsRole findByCode(String roleCode);

	/**
	 * 按角色id查找
	 *
	 * @param roleBizIds role业务ids
	 * @return {@link List }<{@link PmsRole }>
	 */
	List<PmsRole> findByRoleIds(List<Long> roleBizIds);
}
