package com.luman.pms.application.pms.role.exec;

import com.luman.pms.client.pms.dto.req.UpdateRoleReq;
import com.luman.pms.domain.pms.dp.PmsRole;
import com.luman.pms.domain.pms.dp.PmsRolePermission;
import com.luman.pms.infrastructure.pms.service.PmsPermissionDataService;
import com.luman.pms.infrastructure.pms.service.PmsRoleDataService;
import com.luman.pms.infrastructure.pms.service.PmsRolePermissionDataService;
import com.luman.pms.infrastructure.pms.service.PmsUserRoleDataService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Pms角色更新执行
 *
 * @author yeyinghao
 * @date 2024/04/15
 */
@Component
@RequiredArgsConstructor
public class PmsRoleUpdateExec {

	/**
	 * Pms角色数据服务
	 */
	private final PmsRoleDataService pmsRoleDataService;

	/**
	 * Pms用户角色数据服务
	 */
	private final PmsUserRoleDataService pmsUserRoleDataService;

	/**
	 * Pms角色许可数据服务
	 */
	private final PmsRolePermissionDataService pmsRolePermissionDataService;

	/**
	 * Pms许可数据服务
	 */
	private final PmsPermissionDataService pmsPermissionDataService;

	/**
	 * 更新作用
	 *
	 * @param req 请求
	 * @return {@link Boolean}
	 */
	public Boolean updateRole(UpdateRoleReq req) {
		PmsRole pmsRole = pmsRoleDataService.findById(req.getId());
		pmsRole.setCode(req.getCode());
		pmsRole.setName(req.getName());
		pmsRole.setEnable(req.getEnable());
		pmsRoleDataService.updateById(pmsRole);

		pmsRolePermissionDataService.removeByRoleId(pmsRole.getId());

		savePermissionByRole(pmsRole, req.getPermissionIds());
		return Boolean.TRUE;
	}

	/**
	 * 按角色保存权限
	 *
	 * @param pmsRole       Pms角色
	 * @param permissionIds ids允许
	 */
	private void savePermissionByRole(PmsRole pmsRole, List<Long> permissionIds) {
		List<PmsRolePermission> permissionList = permissionIds.stream().map(permId -> {
			PmsRolePermission rolePermission = new PmsRolePermission();
			rolePermission.setRoleId(pmsRole.getId());
			rolePermission.setPermissionId(permId);
			return rolePermission;
		}).collect(Collectors.toList());
		pmsRolePermissionDataService.saveBatch(permissionList);
	}
}
