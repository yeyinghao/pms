package com.luman.pms.infrastructure.db.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.luman.pms.domain.dp.PmsRolePermission;
import com.luman.pms.infrastructure.db.dataobject.PmsRolePermissionPO;
import com.luman.pms.infrastructure.db.mapper.PmsRolePermissionMapper;
import com.luman.pms.infrastructure.db.service.PmsRolePermissionDataService;
import com.luman.smy.common.util.CopyUtil;
import org.springframework.stereotype.Service;

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
}
