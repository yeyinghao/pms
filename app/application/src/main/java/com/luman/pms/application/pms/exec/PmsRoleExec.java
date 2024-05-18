package com.luman.pms.application.pms.exec;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.IdUtil;
import com.luman.pms.application.pms.convert.RoleConvert;
import com.luman.pms.application.pms.exec.trans.PmsTrans;
import com.luman.pms.client.pms.model.req.*;
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
public class PmsRoleExec {

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

	private final PmsTrans pmsTrans;

	/**
	 * 创建角色
	 *
	 * @param req 请求
	 */
	public void createRole(CreateRoleReq req) {
		PmsRole pmsRole = pmsRoleDataService.findByCodeOrName(req.getCode(), req.getName());
		Assert.isNull(pmsRole, CommErrorEnum.BIZ_ERROR, "角色已存在");
		pmsRole = new PmsRole();
		pmsRole.setRoleId(IdUtil.getSnowflakeNextId());
		pmsRole.setCode(req.getCode());
		pmsRole.setName(req.getName());
		pmsRole.setEnable(Boolean.TRUE);
		pmsRole.setStatus(Boolean.TRUE);
		List<PmsRolePermission> pmsRolePermissions = RoleConvert.buildRolePermissions(pmsRole.getRoleId(), req.getPermissionIds());
		pmsTrans.createRoleByTrans(pmsRole, pmsRolePermissions);
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

		List<PmsRolePermission> pmsRolePermissions = RoleConvert.buildRolePermissions(pmsRole.getRoleId(), req.getPermissionIds());
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

	/**
	 * 删除角色
	 *
	 * @param id id
	 */
	public void removeRole(Long id) {
		PmsRole pmsRole = pmsRoleDataService.findById(id);
		pmsTrans.removeRoleByTrans(pmsRole);
	}

	/**
	 * 删除角色用户
	 *
	 * @param req 请求
	 */
	public void removeRoleUsers(RemoveRoleUsersReq req) {
		PmsRole pmsRole = pmsRoleDataService.findById(req.getId());
		pmsUserRoleDataService.removeRoleIdAndUserIds(pmsRole.getRoleId(), req.getUserIds());
	}

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
		List<PmsRolePermission> pmsRolePermissions = RoleConvert.buildRolePermissions(pmsRole.getId(), req.getPermissionIds());
		pmsTrans.updateRoleByTrans(pmsRole, pmsRolePermissions);
	}

	/**
	 * 更新角色状态
	 *
	 * @param req 请求
	 */
	public void updateRoleStatus(UpdateRoleStatusReq req) {
		PmsRole pmsRole = pmsRoleDataService.findById(req.getId());
		pmsRole.setEnable(req.getEnable());
		pmsRoleDataService.updateById(pmsRole);
	}
}
