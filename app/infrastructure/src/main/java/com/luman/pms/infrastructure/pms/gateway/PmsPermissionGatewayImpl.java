package com.luman.pms.infrastructure.pms.gateway;

import com.luman.pms.domain.pms.enums.PermissionTypeEnum;
import com.luman.pms.domain.pms.gateway.PmsPermissionGateway;
import com.luman.pms.domain.pms.model.PmsPermission;
import com.luman.pms.infrastructure.pms.dataobject.PmsPermissionPO;
import com.luman.smy.common.util.CopyUtil;
import com.luman.smy.dal.gateway.GatewayImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * pms_permission表数据库服务实现
 *
 * @author yeyinghao
 * @date 2024/04/14
 */
@Service
public class PmsPermissionGatewayImpl extends GatewayImpl<PmsPermissionPO, PmsPermission> implements PmsPermissionGateway {

	@Override
	public PmsPermission convertToDO(PmsPermissionPO po) {
		return CopyUtil.copy(po, PmsPermission::new, (s, t) -> {
		});
	}

	@Override
	public PmsPermissionPO convertToPO(PmsPermission dp) {
		return CopyUtil.copy(dp, PmsPermissionPO::new, (s, t) -> {
		});
	}

	@Override
	public Boolean validateMenuPath(String path) {
		return lambdaQuery().eq(PmsPermissionPO::getPath, path).exists();
	}

	@Override
	public List<PmsPermission> findButtonByParentId(Long parentId, PermissionTypeEnum permissionType) {
		List<PmsPermissionPO> list = lambdaQuery().eq(PmsPermissionPO::getParentId, parentId)
				.eq(PmsPermissionPO::getType, permissionType.name())
				.orderByAsc(PmsPermissionPO::getOrder).list();
		return convertToDOs(list);
	}

	@Override
	public List<PmsPermission> findAllMenu(PermissionTypeEnum permissionType) {
		List<PmsPermissionPO> list = lambdaQuery().eq(PmsPermissionPO::getType, permissionType.name()).list();
		return convertToDOs(list);
	}
}
