package com.luman.pms.application.pms.exec.qry;

import cn.dev33.satoken.stp.StpUtil;
import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.lang.tree.Tree;
import com.google.common.collect.Lists;
import com.luman.pms.application.pms.convert.RoleConvert;
import com.luman.pms.client.pms.model.info.PermissionInfo;
import com.luman.pms.client.pms.model.info.RoleInfo;
import com.luman.pms.client.pms.model.info.RolePageInfo;
import com.luman.pms.client.pms.model.req.RolePageReq;
import com.luman.pms.domain.pms.gateway.PmsPermissionGateway;
import com.luman.pms.domain.pms.gateway.PmsRoleGateway;
import com.luman.pms.domain.pms.gateway.PmsRolePermissionGateway;
import com.luman.pms.domain.pms.gateway.PmsUserRoleGateway;
import com.luman.pms.domain.pms.model.PmsPermission;
import com.luman.pms.domain.pms.model.PmsRole;
import com.luman.pms.domain.pms.model.PmsRolePermission;
import com.luman.pms.domain.pms.model.PmsUserRole;
import com.luman.pms.infrastructure.pms.util.PermissionUtil;
import com.luman.smy.common.model.PageRes;
import com.luman.smy.common.util.CopyUtil;
import com.luman.smy.dal.util.PageUtil;
import com.luman.smy.token.constant.SaTokenConstant;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Pms角色qry执行
 *
 * @author yeyinghao
 * @date 2024/04/15
 */
@Component
@RequiredArgsConstructor
public class PmsRoleQryExec {

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
	 * Pms许可数据服务
	 */
	private final PmsPermissionGateway pmsPermissionDataService;

	/**
	 * 获取角色信息由用户id
	 *
	 * @param userId 用户id
	 * @return {@link List}<{@link RoleInfo}>
	 */
	public List<RoleInfo> getRoleInfosByUserId(Long userId) {
		// 查询用户的角色
		return RoleConvert.buildRoleInfos(getPmsRolesByUserId(userId));
	}

	/**
	 * 获取Pms角色由用户id
	 *
	 * @param userId 用户id
	 * @return {@link List}<{@link PmsRole}>
	 */
	public List<PmsRole> getPmsRolesByUserId(Long userId) {
		List<PmsUserRole> pmsUserRoles = pmsUserRoleDataService.findRolesByUserId(userId);
		if (CollectionUtil.isEmpty(pmsUserRoles)) {
			return Lists.newArrayList();
		}
		List<Long> roleBizIds = pmsUserRoles.stream().map(PmsUserRole::getRoleId).collect(Collectors.toList());
		if (CollectionUtil.isEmpty(roleBizIds)) {
			return Lists.newArrayList();
		}
		return pmsRoleDataService.findByIds(roleBizIds);
	}

	/**
	 * 找到所有
	 *
	 * @return {@link List}<{@link RoleInfo}>
	 */
	public List<RoleInfo> findAll() {
		List<PmsRole> pmsRoles = pmsRoleDataService.findAll();
		return RoleConvert.buildRoleInfos(pmsRoles);
	}

	/**
	 * 查询页面
	 *
	 * @param req 请求
	 * @return {@link PageRes}<{@link RolePageInfo}>
	 */
	public PageRes<RolePageInfo> queryPage(RolePageReq req) {
		PageRes<PmsRole> pmsRolePageResp = pmsRoleDataService.listByPage(req);
		return PageUtil.buildPage(pmsRolePageResp, RolePageInfo::new, (s, t) -> {
			List<PmsRolePermission> permissions = pmsRolePermissionDataService.findByRoleId(s.getId());
			t.setPermissionIds(permissions.stream().map(PmsRolePermission::getPermissionId)
					.collect(Collectors.toList()));
		});
	}

	/**
	 * 查找角色权限
	 *
	 * @param id id
	 * @return {@link List}<{@link PermissionInfo}>
	 */
	public List<PermissionInfo> findRolePermissions(Long id) {
		List<PmsRolePermission> permissions = pmsRolePermissionDataService.findByRoleId(id);
		List<Long> permissionIds = permissions.stream().map(PmsRolePermission::getPermissionId).collect(Collectors.toList());
		List<PmsPermission> pmsPermissions = pmsPermissionDataService.findByIds(permissionIds);
		return pmsPermissions.stream().map(item -> CopyUtil.copy(item, PermissionInfo::new))
				.collect(Collectors.toList());
	}

	/**
	 * find由id
	 *
	 * @param id id
	 * @return {@link RoleInfo}
	 */
	public RoleInfo findById(Long id) {
		PmsRole pmsRole = pmsRoleDataService.findById(id);
		RoleInfo roleInfo = new RoleInfo();
		roleInfo.setId(pmsRole.getId());
		roleInfo.setCode(pmsRole.getCode());
		roleInfo.setName(pmsRole.getName());
		roleInfo.setEnable(pmsRole.getEnable());
		return roleInfo;
	}

	/**
	 * @return {@link List}<{@link Tree}<{@link Long}>>
	 */
	public List<Tree<Long>> findRolePermissionsTree() {
		String roleCode = (String) StpUtil.getExtra(SaTokenConstant.JWT_CURRENT_ROLE_KEY);
		PmsRole pmsRole = pmsRoleDataService.findByCode(roleCode);
		List<PmsPermission> permissions;
		if ("SUPER_ADMIN".equals(roleCode)) {
			permissions = pmsPermissionDataService.findAll();
		} else {
			List<PmsRolePermission> rolePermissions = pmsRolePermissionDataService.findByRoleId(pmsRole.getRoleId());
			List<Long> collect = rolePermissions.stream().map(PmsRolePermission::getPermissionId).collect(Collectors.toList());
			permissions = pmsPermissionDataService.findByIds(collect);
		}
		return PermissionUtil.toTreeNode(permissions, null);
	}
}
