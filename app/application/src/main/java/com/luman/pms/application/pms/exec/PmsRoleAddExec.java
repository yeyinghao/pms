package com.luman.pms.application.pms.exec;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.IdUtil;
import com.luman.pms.application.pms.convert.RolePermissionConvert;
import com.luman.pms.client.pms.model.req.AddRolePermissionsReq;
import com.luman.pms.client.pms.model.req.AddRoleUsersReq;
import com.luman.pms.client.pms.model.req.CreateRoleReq;
import com.luman.pms.domain.pms.gateway.PmsRoleGateway;
import com.luman.pms.domain.pms.gateway.PmsRolePermissionGateway;
import com.luman.pms.domain.pms.gateway.PmsUserRoleGateway;
import com.luman.pms.domain.pms.model.PmsRole;
import com.luman.pms.domain.pms.model.PmsRolePermission;
import com.luman.pms.domain.pms.model.PmsUserRole;
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
	 * 创建角色
	 *
	 * @param req 请求
	 */
	public void createRole(CreateRoleReq req) {
		PmsRole pmsRole = pmsRoleDataService.findByCodeOrName(req.getCode(), req.getName());
		Assert.notNull(pmsRole, CommErrorEnum.BIZ_ERROR);
		pmsRole = new PmsRole();
		pmsRole.setRoleId(IdUtil.getSnowflakeNextId());
		pmsRole.setCode(req.getCode());
		pmsRole.setName(req.getName());
		pmsRole.setEnable(Boolean.TRUE);
		pmsRole.setStatus(Boolean.TRUE);

		List<PmsRolePermission> pmsRolePermissions = RolePermissionConvert.buildRolePermissions(pmsRole.getRoleId(), req.getPermissionIds());

		pmsRoleDataService.save(pmsRole);
		pmsRolePermissionDataService.saveBatch(pmsRolePermissions);
	}

	/**
	 * 添加角色权限
	 *
	 * @param req 请求
	 */
	public void addRolePermissions(AddRolePermissionsReq req) {
		PmsRole pmsRole = pmsRoleDataService.findById(req.getId());
		List<PmsRolePermission> rolePermissions = pmsRolePermissionDataService.findByRoleId(pmsRole.getRoleId());
		List<Long> list = rolePermissions.stream().map(PmsRolePermission::getPermissionId).collect(Collectors.toList());
		CollUtil.removeWithAddIf(req.getPermissionIds(), list::contains);

		List<PmsRolePermission> pmsRolePermissions = RolePermissionConvert.buildRolePermissions(pmsRole.getRoleId(), req.getPermissionIds());
		pmsRolePermissionDataService.saveBatch(pmsRolePermissions);
	}

	/**
	 * 添加角色用户
	 *
	 * @param req 请求
	 */
	public void addRoleUsers(AddRoleUsersReq req) {
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
	}
}
