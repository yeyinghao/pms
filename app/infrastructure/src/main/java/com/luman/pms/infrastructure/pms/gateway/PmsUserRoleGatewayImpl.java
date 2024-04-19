package com.luman.pms.infrastructure.pms.gateway;

import com.luman.pms.domain.pms.gateway.PmsUserRoleGateway;
import com.luman.pms.domain.pms.model.PmsUserRole;
import com.luman.pms.infrastructure.pms.dataobject.PmsUserRolePO;
import com.luman.smy.common.util.CopyUtil;
import com.luman.smy.dal.gateway.GatewayImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * pms_user_role表数据库服务实现
 *
 * @author yeyinghao
 * @date 2024/04/14
 */
@Service
public class PmsUserRoleGatewayImpl extends GatewayImpl<PmsUserRolePO, PmsUserRole> implements PmsUserRoleGateway {

	@Override
	public PmsUserRole convertToDO(PmsUserRolePO po) {
		return CopyUtil.copy(po, PmsUserRole::new, (s, t) -> {
		});
	}

	@Override
	public PmsUserRolePO convertToPO(PmsUserRole dp) {
		return CopyUtil.copy(dp, PmsUserRolePO::new, (s, t) -> {
		});
	}

	@Override
	public List<PmsUserRole> findRolesByUserId(Long userId) {
		List<PmsUserRolePO> list = lambdaQuery().eq(PmsUserRolePO::getStatus, Boolean.TRUE)
				.eq(PmsUserRolePO::getUserId, userId).list();
		return convertToDOs(list);
	}

	@Override
	public void removeByUserId(Long userId) {
		lambdaUpdate().eq(PmsUserRolePO::getUserId, userId).remove();
	}

	@Override
	public List<PmsUserRole> findByRoleId(Long roleId) {
		List<PmsUserRolePO> list = lambdaQuery().eq(PmsUserRolePO::getStatus, Boolean.TRUE)
				.in(PmsUserRolePO::getRoleId, roleId).list();
		return convertToDOs(list);
	}

	@Override
	public void removeRoleIdAndUserIds(Long roleId, List<Long> userIds) {
		lambdaUpdate().eq(PmsUserRolePO::getStatus, Boolean.TRUE)
				.eq(PmsUserRolePO::getRoleId, roleId)
				.in(PmsUserRolePO::getUserId, userIds).remove();
	}
}
