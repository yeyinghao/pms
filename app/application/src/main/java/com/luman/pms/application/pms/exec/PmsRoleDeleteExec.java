package com.luman.pms.application.pms.exec;

import com.luman.pms.client.pms.model.req.RemoveRoleUsersReq;
import com.luman.pms.domain.pms.gateway.PmsRoleGateway;
import com.luman.pms.domain.pms.gateway.PmsRolePermissionGateway;
import com.luman.pms.domain.pms.gateway.PmsUserRoleGateway;
import com.luman.pms.domain.pms.model.PmsRole;
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
	private final PmsRoleGateway pmsRoleDataService;

	/**
	 * Pms用户角色数据服务
	 */
	private final PmsUserRoleGateway pmsUserRoleDataService;

	/**
	 * Pms角色许可数据服务
	 */
	private final PmsRolePermissionGateway pmsRolePermissionDataService;

	/**
	 * 删除角色
	 *
	 * @param id id
	 */
	public void removeRole(Long id) {
		PmsRole pmsRole = pmsRoleDataService.findById(id);
		pmsRoleDataService.deleteById(id);
		pmsRolePermissionDataService.removeByRoleId(pmsRole.getId());
		pmsUserRoleDataService.removeByUserId(pmsRole.getId());
	}

	/**
	 * 删除角色用户
	 *
	 * @param req 请求
	 */
	public void removeRoleUsers(RemoveRoleUsersReq req) {
		PmsRole pmsRole = pmsRoleDataService.findById(req.getRoleId());
		pmsUserRoleDataService.removeRoleIdAndUserIds(pmsRole.getId(), req.getUserIds());
	}

}
