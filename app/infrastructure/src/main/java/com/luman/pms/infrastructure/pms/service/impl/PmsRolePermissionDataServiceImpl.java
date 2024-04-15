package com.luman.pms.infrastructure.pms.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.luman.pms.domain.pms.dp.PmsRolePermission;
import com.luman.pms.infrastructure.pms.dataobject.PmsRolePermissionPO;
import com.luman.pms.infrastructure.pms.mapper.PmsRolePermissionMapper;
import com.luman.pms.infrastructure.pms.service.PmsRolePermissionDataService;
import com.luman.smy.common.util.CopyUtil;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * pms_role_permission表数据库服务实现
 *
 * @author yeyinghao
 * @date 2024/04/14
 */
@Service
public class PmsRolePermissionDataServiceImpl extends ServiceImpl<PmsRolePermissionMapper, PmsRolePermissionPO> implements PmsRolePermissionDataService {

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
