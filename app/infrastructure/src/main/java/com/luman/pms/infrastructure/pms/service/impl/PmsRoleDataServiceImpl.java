package com.luman.pms.infrastructure.pms.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.luman.pms.domain.pms.dp.PmsRole;
import com.luman.pms.infrastructure.pms.dataobject.PmsRolePO;
import com.luman.pms.infrastructure.pms.mapper.PmsRoleMapper;
import com.luman.pms.infrastructure.pms.service.PmsRoleDataService;
import com.luman.smy.common.util.CopyUtil;
import org.springframework.stereotype.Service;

/**
 * pms_role表数据库服务实现
 *
 * @author yeyinghao
 * @date 2024/04/14
 */
@Service
public class PmsRoleDataServiceImpl extends ServiceImpl<PmsRoleMapper, PmsRolePO> implements PmsRoleDataService {

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
		PmsRolePO entity = lambdaQuery().eq(PmsRolePO::getStatus, Boolean.TRUE)
				.eq(PmsRolePO::getCode, code).or().eq(PmsRolePO::getName, code).one();
		return convertToDO(entity);
	}

	@Override
	public PmsRole findByCode(String roleCode) {
		PmsRolePO entity = lambdaQuery().eq(PmsRolePO::getStatus, Boolean.TRUE)
				.eq(PmsRolePO::getCode, roleCode).one();
		return convertToDO(entity);
	}
}
