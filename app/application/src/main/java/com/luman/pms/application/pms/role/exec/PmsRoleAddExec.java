package com.luman.pms.application.pms.role.exec;

import cn.hutool.core.collection.CollUtil;
import com.luman.pms.client.pms.dto.req.AddRolePermissionsReq;
import com.luman.pms.client.pms.dto.req.AddRoleUsersReq;
import com.luman.pms.client.pms.dto.req.CreateRoleReq;
import com.luman.pms.domain.pms.dp.PmsRole;
import com.luman.pms.domain.pms.dp.PmsRolePermission;
import com.luman.pms.domain.pms.dp.PmsUserRole;
import com.luman.pms.infrastructure.pms.service.PmsPermissionDataService;
import com.luman.pms.infrastructure.pms.service.PmsRoleDataService;
import com.luman.pms.infrastructure.pms.service.PmsRolePermissionDataService;
import com.luman.pms.infrastructure.pms.service.PmsUserRoleDataService;
import com.luman.smy.common.enums.CommErrorEnum;
import com.luman.smy.common.exception.Assert;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Pms角色添加执行
 *
 * @author yeyinghao
 * @date 2024/04/15
 */
@Component
@RequiredArgsConstructor
public class PmsRoleAddExec {

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
	 * 创建角色
	 *
	 * @param req 请求
	 * @return {@link Boolean}
	 */
	public Boolean createRole(CreateRoleReq req) {
		PmsRole pmsRole = pmsRoleDataService.findByCodeOrName(req.getCode(), req.getName());
		Assert.notNull(pmsRole, CommErrorEnum.BIZ_ERROR);
		PmsRole newPmsRole = new PmsRole();
		newPmsRole.setCode(req.getCode());
		newPmsRole.setName(req.getName());
		newPmsRole.setEnable(Boolean.TRUE);
		newPmsRole.setStatus(Boolean.TRUE);

		pmsRoleDataService.save(newPmsRole);
		savePermissionByRole(newPmsRole, req.getPermissionIds());
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

	/**
	 * 添加角色权限
	 *
	 * @param req 请求
	 * @return {@link Boolean}
	 */
	public Boolean addRolePermissions(AddRolePermissionsReq req) {
		PmsRole pmsRole = pmsRoleDataService.findById(req.getId());
		List<PmsRolePermission> rolePermissions = pmsRolePermissionDataService.findByRoleId(pmsRole.getId());
		List<Long> list = rolePermissions.stream().map(PmsRolePermission::getPermissionId).collect(Collectors.toList());
		CollUtil.removeWithAddIf(req.getPermissionIds(), list::contains);
		savePermissionByRole(pmsRole, req.getPermissionIds());
		return Boolean.TRUE;
	}

	/**
	 * 添加角色用户
	 *
	 * @param req 请求
	 * @return {@link Boolean}
	 */
	public Boolean addRoleUsers(AddRoleUsersReq req) {
		PmsRole pmsRole = pmsRoleDataService.findById(req.getId());
		List<Long> list = pmsUserRoleDataService.findByRoleId(pmsRole.getId()).stream().map(PmsUserRole::getUserId).collect(Collectors.toList());
		CollUtil.removeWithAddIf(req.getUserIds(), list::contains);
		List<PmsUserRole> permissionList = req.getUserIds().stream().map(userId -> {
			PmsUserRole userRole = new PmsUserRole();
			userRole.setRoleId(pmsRole.getId());
			userRole.setUserId(userId);
			return userRole;
		}).collect(Collectors.toList());
		pmsUserRoleDataService.saveBatch(permissionList);
		return Boolean.TRUE;
	}
}
