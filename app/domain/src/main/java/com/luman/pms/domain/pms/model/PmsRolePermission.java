package com.luman.pms.domain.pms.model;

import com.luman.smy.common.model.BaseDP;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * pms_role_permission表领域模型
 *
 * @author yeyinghao
 * @date 2024/04/14
 */
@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
public class PmsRolePermission extends BaseDP {

	/**
	 * roleBizId
	 */
	private Long roleId;

	/**
	 * permissionBizId
	 */
	private Long permissionId;

}

