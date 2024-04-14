package com.luman.pms.infrastructure.db.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.luman.pms.domain.dp.PmsUserRole;
import com.luman.pms.infrastructure.db.dataobject.PmsUserRolePO;
import com.luman.pms.infrastructure.db.mapper.PmsUserRoleMapper;
import com.luman.pms.infrastructure.db.service.PmsUserRoleDataService;
import com.luman.smy.common.util.CopyUtil;
import org.springframework.stereotype.Service;

/**
 * pms_user_role表数据库服务实现
 *
 * @author yeyinghao
 * @date 2024/04/14
 */
@Service
public class PmsUserRoleDataServiceImpl extends ServiceImpl<PmsUserRoleMapper, PmsUserRolePO> implements PmsUserRoleDataService {

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
}
