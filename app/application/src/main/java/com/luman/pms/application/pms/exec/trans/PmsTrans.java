package com.luman.pms.application.pms.exec.trans;

import com.luman.pms.domain.pms.gateway.*;
import com.luman.pms.domain.pms.model.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@RequiredArgsConstructor
public class PmsTrans {

	/**
	 * Pms用户角色数据服务
	 */
	private final PmsUserRoleGateway pmsUserRoleGateway;

	/**
	 * Pms角色数据服务
	 */
	private final PmsRoleGateway pmsRoleGateway;

	/**
	 * Pms角色许可数据服务
	 */
	private final PmsRolePermissionGateway pmsRolePermissionGateway;

	/**
	 * Pms用户数据服务
	 */
	private final PmsUserGateway pmsUserGateway;

	/**
	 * Pms配置文件数据服务
	 */
	private final PmsProfileGateway pmsProfileGateway;

	/**
	 * 添加角色通过事务
	 *
	 * @param pmsUser Pms用户
	 * @param list    列表
	 */
	@Transactional(rollbackFor = Throwable.class)
	public void addRolesByTrans(PmsUser pmsUser, List<PmsUserRole> list) {
		pmsUserRoleGateway.removeByUserId(pmsUser.getBizId());
		pmsUserRoleGateway.saveBatch(list);
	}

	/**
	 * 创建角色通过事务
	 *
	 * @param pmsRole            Pms角色
	 * @param pmsRolePermissions Pms角色权限
	 */
	@Transactional(rollbackFor = Throwable.class)
	public void createRoleByTrans(PmsRole pmsRole, List<PmsRolePermission> pmsRolePermissions) {
		pmsRoleGateway.save(pmsRole);
		pmsRolePermissionGateway.saveBatch(pmsRolePermissions);
	}

	/**
	 * 删除角色通过事务
	 *
	 * @param pmsRole Pms角色
	 */
	@Transactional(rollbackFor = Throwable.class)
	public void removeRoleByTrans(PmsRole pmsRole) {
		pmsRoleGateway.deleteById(pmsRole.getId());
		pmsRolePermissionGateway.removeByRoleId(pmsRole.getBizId());
		pmsUserRoleGateway.removeByRoleId(pmsRole.getBizId());
	}

	/**
	 * 更新角色通过事务
	 *
	 * @param pmsRole            Pms角色
	 * @param pmsRolePermissions Pms角色权限
	 */
	@Transactional(rollbackFor = Throwable.class)
	public void updateRoleByTrans(PmsRole pmsRole, List<PmsRolePermission> pmsRolePermissions) {
		pmsRoleGateway.updateById(pmsRole);
		pmsRolePermissionGateway.removeByRoleId(pmsRole.getBizId());
		pmsRolePermissionGateway.saveBatch(pmsRolePermissions);
	}

	/**
	 * 删除用户通过事务
	 *
	 * @param pmsUser Pms用户
	 */
	@Transactional(rollbackFor = Throwable.class)
	public void removeUserByTrans(PmsUser pmsUser) {
		pmsUserGateway.deleteById(pmsUser.getId());
		pmsProfileGateway.deleteByUserId(pmsUser.getId());
	}

	/**
	 * 注册通过事务
	 *
	 * @param pmsUser      Pms用户
	 * @param pmsProfile   Pms配置文件
	 * @param userRoleList 用户角色列表
	 */
	@Transactional(rollbackFor = Throwable.class)
	public void registerByTrans(PmsUser pmsUser, PmsProfile pmsProfile, List<PmsUserRole> userRoleList) {
		pmsUserGateway.save(pmsUser);
		pmsProfileGateway.save(pmsProfile);
		pmsUserRoleGateway.saveBatch(userRoleList);
	}
}
