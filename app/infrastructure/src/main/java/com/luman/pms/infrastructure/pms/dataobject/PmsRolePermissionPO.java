package com.luman.pms.infrastructure.pms.dataobject;

import com.baomidou.mybatisplus.annotation.TableName;
import com.luman.smy.dal.model.BasePO;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * pms_role_permission表实体类
 *
 * @author yeyinghao
 * @date 2024/04/14
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("pms_role_permission")
public class PmsRolePermissionPO extends BasePO {

	/**
	 * 角色id
	 */
	private Long roleId;

	/**
	 * 权限id
	 */
	private Long permissionId;

}

