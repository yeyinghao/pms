package com.luman.pms.application.pms.exec;

import com.luman.pms.application.pms.convert.RolePermissionConvert;
import com.luman.pms.client.pms.model.req.UpdateRoleReq;
import com.luman.pms.domain.pms.gateway.PmsRoleGateway;
import com.luman.pms.domain.pms.gateway.PmsRolePermissionGateway;
import com.luman.pms.domain.pms.model.PmsRole;
import com.luman.pms.domain.pms.model.PmsRolePermission;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

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
	private final PmsRoleGateway pmsRoleDataService;

	/**
	 * Pms角色许可数据服务
	 */
	private final PmsRolePermissionGateway pmsRolePermissionDataService;

	/**
	 * 更新作用
	 *
	 * @param req 请求
	 */
	public void updateRole(UpdateRoleReq req) {
		PmsRole pmsRole = pmsRoleDataService.findById(req.getId());
		pmsRole.setCode(req.getCode());
		pmsRole.setName(req.getName());
		pmsRole.setEnable(req.getEnable());
		pmsRoleDataService.updateById(pmsRole);

		List<PmsRolePermission> pmsRolePermissions = RolePermissionConvert.buildRolePermissions(pmsRole.getId(), req.getPermissionIds());

		pmsRolePermissionDataService.removeByRoleId(pmsRole.getId());
		pmsRolePermissionDataService.saveBatch(pmsRolePermissions);
	}
}
