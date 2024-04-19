package com.luman.pms.application.pms.convert;

import cn.hutool.core.collection.CollectionUtil;
import com.google.common.collect.Lists;
import com.luman.pms.client.pms.model.info.RoleInfo;
import com.luman.pms.domain.pms.model.PmsRole;

import java.util.List;
import java.util.stream.Collectors;

public class RoleConvert {

	/**
	 * 获取角色信息
	 *
	 * @param pmsRoles Pms角色
	 * @return {@link List}<{@link RoleInfo}>
	 */
	public static List<RoleInfo> buildRoleInfos(List<PmsRole> pmsRoles) {
		if (CollectionUtil.isEmpty(pmsRoles)) {
			return Lists.newArrayList();
		}
		return pmsRoles.stream().map(item -> {
			RoleInfo roleInfo = new RoleInfo();
			roleInfo.setId(item.getId());
			roleInfo.setCode(item.getCode());
			roleInfo.setName(item.getName());
			roleInfo.setEnable(item.getEnable());
			return roleInfo;
		}).collect(Collectors.toList());
	}
}
