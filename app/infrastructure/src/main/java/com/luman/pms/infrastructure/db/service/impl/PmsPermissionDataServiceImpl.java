package com.luman.pms.infrastructure.db.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.luman.pms.domain.dp.PmsPermission;
import com.luman.pms.infrastructure.db.dataobject.PmsPermissionPO;
import com.luman.pms.infrastructure.db.mapper.PmsPermissionMapper;
import com.luman.pms.infrastructure.db.service.PmsPermissionDataService;
import com.luman.smy.common.util.CopyUtil;
import org.springframework.stereotype.Service;

/**
 * pms_permission表数据库服务实现
 *
 * @author yeyinghao
 * @date 2024/04/14
 */
@Service
public class PmsPermissionDataServiceImpl extends ServiceImpl<PmsPermissionMapper, PmsPermissionPO> implements PmsPermissionDataService {

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
}
