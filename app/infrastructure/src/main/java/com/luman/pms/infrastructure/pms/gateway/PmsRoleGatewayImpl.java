package com.luman.pms.infrastructure.pms.gateway;

import com.luman.pms.domain.pms.gateway.PmsRoleGateway;
import com.luman.pms.domain.pms.model.PmsRole;
import com.luman.pms.infrastructure.pms.dataobject.PmsRolePO;
import com.luman.smy.common.util.CopyUtil;
import com.luman.smy.dal.gateway.GatewayImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * pms_role表数据库服务实现
 *
 * @author yeyinghao
 * @date 2024/04/14
 */
@Service
public class PmsRoleGatewayImpl extends GatewayImpl<PmsRolePO, PmsRole> implements PmsRoleGateway {

	@Override
	public PmsRole convertToDO(PmsRolePO po) {
		return CopyUtil.copy(po, PmsRole::new, (s, t) -> {
		});
	}

	@Override
	public PmsRolePO convertToPO(PmsRole dp) {
		return CopyUtil.copy(dp, PmsRolePO::new, (s, t) -> {
		});
	}

	@Override
	public PmsRole findByCodeOrName(String code, String name) {
		PmsRolePO entity = lambdaQuery().eq(PmsRolePO::getCode, code).or().eq(PmsRolePO::getName, code).one();
		return convertToDO(entity);
	}

	@Override
	public PmsRole findByCode(String roleCode) {
		PmsRolePO entity = lambdaQuery().eq(PmsRolePO::getCode, roleCode).one();
		return convertToDO(entity);
	}

	@Override
	public List<PmsRole> findByRoleIds(List<Long> roleBizIds) {
		return convertToDOs(lambdaQuery().in(PmsRolePO::getRoleId, roleBizIds).list());
	}
}
