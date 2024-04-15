package com.luman.pms.domain.pms.dp;

import com.luman.smy.common.model.BaseDP;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * pms_user_role表领域模型
 *
 * @author yeyinghao
 * @date 2024/04/14
 */
@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
public class PmsUserRole extends BaseDP {

	/**
	 * userBizId
	 */
	private Long userId;

	/**
	 * roleBizId
	 */
	private Long roleId;

}

