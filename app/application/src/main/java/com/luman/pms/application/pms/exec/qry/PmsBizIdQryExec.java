package com.luman.pms.application.pms.exec.qry;

import com.luman.pms.domain.pms.gateway.PmsPermissionGateway;
import com.luman.pms.domain.pms.gateway.PmsRoleGateway;
import com.luman.pms.domain.pms.model.PmsPermission;
import com.luman.pms.domain.pms.model.PmsRole;
import com.luman.smy.common.enums.CommErrorEnum;
import com.luman.smy.common.exception.Assert;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class PmsBizIdQryExec {

	/**
	 * Pms权限数据服务
	 */
	private final PmsPermissionGateway pmsPermissionGateway;

	/**
	 * Pms角色数据服务
	 */
	private final PmsRoleGateway pmsRoleGateway;

	/**
	 * 角色ids2角色业务id
	 *
	 * @param roleIds 角色id
	 * @return {@link List }<{@link Long }>
	 */
	public List<Long> roleIds2RoleBizIds(List<Long> roleIds) {
		List<PmsRole> roles = pmsRoleGateway.findByIds(roleIds);
		Assert.notEmpty(roles, CommErrorEnum.BIZ_ERROR, "角色查询失败");
		Assert.isFalse(roles.size() == roleIds.size(), CommErrorEnum.BIZ_ERROR, "角色查询数量不匹配");
		return roles.stream().map(PmsRole::getRoleId).collect(Collectors.toList());
	}

	/**
	 * 权限ids2权限业务id
	 *
	 * @param roleIds 角色id
	 * @return {@link List }<{@link Long }>
	 */
	public List<Long> permissionIds2PermissionBizIds(List<Long> roleIds) {
		List<PmsPermission> roles = pmsPermissionGateway.findByIds(roleIds);
		Assert.notEmpty(roles, CommErrorEnum.BIZ_ERROR, "权限查询失败");
		Assert.isFalse(roles.size() == roleIds.size(), CommErrorEnum.BIZ_ERROR, "权限查询数量不匹配");
		return roles.stream().map(PmsPermission::getPermissionId).collect(Collectors.toList());
	}

}
