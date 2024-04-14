package com.luman.pms.infrastructure.db.dataobject;

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
	 * roleBizId
	 */
	private Long roleId;

	/**
	 * permissionBizId
	 */
	private Long permissionId;

}

