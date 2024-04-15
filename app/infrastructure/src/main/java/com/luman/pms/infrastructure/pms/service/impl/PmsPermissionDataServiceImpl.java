package com.luman.pms.infrastructure.pms.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.luman.pms.domain.pms.dp.PmsPermission;
import com.luman.pms.infrastructure.pms.dataobject.PmsPermissionPO;
import com.luman.pms.infrastructure.pms.mapper.PmsPermissionMapper;
import com.luman.pms.infrastructure.pms.service.PmsPermissionDataService;
import com.luman.smy.common.util.CopyUtil;
import org.springframework.stereotype.Service;

import java.util.List;

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

	@Override
	public Boolean validateMenuPath(String path) {
		return lambdaQuery().eq(PmsPermissionPO::getPath, path).exists();
	}

	@Override
	public List<PmsPermission> findButtonAndApi() {
		List<PmsPermissionPO> list = lambdaQuery().eq(PmsPermissionPO::getStatus, Boolean.TRUE)
				.in(PmsPermissionPO::getType, "BUTTON", "API")
				.orderByAsc(PmsPermissionPO::getOrder)
				.list();
		return convertToDOs(list);
	}

	@Override
	public List<PmsPermission> findAllByMenu() {
		List<PmsPermissionPO> list = lambdaQuery().eq(PmsPermissionPO::getStatus, Boolean.TRUE)
				.eq(PmsPermissionPO::getStatus, Boolean.TRUE)
				.eq(PmsPermissionPO::getType,"MENU").list();
		return convertToDOs(list);
	}
}
