package com.luman.pms.domain.pms.gateway;

import com.luman.pms.domain.pms.model.PmsUserRole;
import com.luman.smy.common.gateway.Gateway;

import java.util.List;

/**
 * pms_user_role表数据库服务
 *
 * @author yeyinghao
 * @date 2024/04/14
 */
public interface PmsUserRoleGateway extends Gateway<PmsUserRole> {
	/**
	 * 找到角色通过用户id
	 *
	 * @param userId 用户id
	 * @return {@link List }<{@link PmsUserRole }>
	 */
	List<PmsUserRole> findRolesByUserId(Long userId);

	/**
	 * 删除通过用户id
	 *
	 * @param userId 用户id
	 */
	void removeByUserId(Long userId);

	/**
	 * 找到通过角色id
	 *
	 * @param roleId 角色id
	 * @return {@link List }<{@link PmsUserRole }>
	 */
	List<PmsUserRole> findByRoleId(Long roleId);

	/**
	 * 删除角色id和用户id
	 *
	 * @param roleId  角色id
	 * @param userIds 用户id
	 */
	void removeRoleIdAndUserIds(Long roleId, List<Long> userIds);

	/**
	 * 删除通过角色id
	 *
	 * @param roleId 角色id
	 */
	void removeByRoleId(Long roleId);
}
