package com.luman.pms.application.pms.role.exec;

import com.luman.pms.client.pms.dto.req.RemoveRoleUsersReq;
import com.luman.pms.domain.pms.dp.PmsRole;
import com.luman.pms.infrastructure.pms.service.PmsPermissionDataService;
import com.luman.pms.infrastructure.pms.service.PmsRoleDataService;
import com.luman.pms.infrastructure.pms.service.PmsRolePermissionDataService;
import com.luman.pms.infrastructure.pms.service.PmsUserRoleDataService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * Pms角色删除执行
 *
 * @author yeyinghao
 * @date 2024/04/15
 */
@Component
@RequiredArgsConstructor
public class PmsRoleDeleteExec {

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
	 * 删除角色
	 *
	 * @param id id
	 * @return {@link Boolean}
	 */
	public Boolean removeRole(Long id) {
		PmsRole pmsRole = pmsRoleDataService.findById(id);
		pmsRoleDataService.deleteById(id);
		pmsRolePermissionDataService.removeByRoleId(pmsRole.getId());
		pmsUserRoleDataService.removeByUserId(pmsRole.getId());
		return Boolean.TRUE;
	}

	/**
	 * 删除角色用户
	 *
	 * @param req 请求
	 * @return {@link Boolean}
	 */
	public Boolean removeRoleUsers(RemoveRoleUsersReq req) {
		PmsRole pmsRole = pmsRoleDataService.findById(req.getRoleId());
		pmsUserRoleDataService.removeRoleIdAndUserIds(pmsRole.getId(), req.getUserIds());
		return Boolean.TRUE;
	}

}
