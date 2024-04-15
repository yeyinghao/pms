package com.luman.pms.infrastructure.pms.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.luman.pms.domain.pms.dp.PmsUserRole;
import com.luman.pms.infrastructure.pms.dataobject.PmsUserRolePO;
import com.luman.pms.infrastructure.pms.mapper.PmsUserRoleMapper;
import com.luman.pms.infrastructure.pms.service.PmsUserRoleDataService;
import com.luman.smy.common.util.CopyUtil;
import org.springframework.stereotype.Service;

import java.util.List;

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
