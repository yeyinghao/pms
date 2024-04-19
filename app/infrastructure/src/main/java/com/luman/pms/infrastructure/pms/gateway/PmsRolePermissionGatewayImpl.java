package com.luman.pms.infrastructure.pms.gateway;

import com.luman.pms.domain.pms.gateway.PmsRolePermissionGateway;
import com.luman.pms.domain.pms.model.PmsRolePermission;
import com.luman.pms.infrastructure.pms.dataobject.PmsRolePermissionPO;
import com.luman.smy.common.util.CopyUtil;
import com.luman.smy.dal.gateway.GatewayImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * pms_role_permission表数据库服务实现
 *
 * @author yeyinghao
 * @date 2024/04/14
 */
@Service
public class PmsRolePermissionGatewayImpl extends GatewayImpl<PmsRolePermissionPO, PmsRolePermission> implements PmsRolePermissionGateway {

	@Override
	public PmsRolePermission convertToDO(PmsRolePermissionPO po) {
		return CopyUtil.copy(po, PmsRolePermission::new, (s, t) -> {
		});
	}

	@Override
	public PmsRolePermissionPO convertToPO(PmsRolePermission dp) {
		return CopyUtil.copy(dp, PmsRolePermissionPO::new, (s, t) -> {
		});
	}

	@Override
	public List<PmsRolePermission> findByRoleId(Long roleId) {
		List<PmsRolePermissionPO> list = lambdaQuery().eq(PmsRolePermissionPO::getStatus, Boolean.TRUE)
				.in(PmsRolePermissionPO::getRoleId, roleId).list();
		return convertToDOs(list);
	}

	@Override
	public void removeByRoleId(Long roleId) {
		lambdaUpdate().eq(PmsRolePermissionPO::getRoleId, roleId).remove();
	}
}
