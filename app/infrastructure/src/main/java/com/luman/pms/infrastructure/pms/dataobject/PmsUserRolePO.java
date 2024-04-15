package com.luman.pms.infrastructure.pms.dataobject;

import com.baomidou.mybatisplus.annotation.TableName;
import com.luman.smy.dal.model.BasePO;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * pms_user_role表实体类
 *
 * @author yeyinghao
 * @date 2024/04/14
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("pms_user_role")
public class PmsUserRolePO extends BasePO {

	/**
	 * userBizId
	 */
	private Long userId;

	/**
	 * roleBizId
	 */
	private Long roleId;

}

