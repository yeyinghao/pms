package com.luman.pms.domain.dp;

import com.luman.smy.common.model.BaseDP;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * pms_user表领域模型
 *
 * @author yeyinghao
 * @date 2024/04/14
 */
@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
public class PmsUser extends BaseDP {

	/**
	 * 名称
	 */
	private String userName;

	/**
	 * 用户code
	 */
	private String userCode;

	/**
	 * 密码
	 */
	private String password;

	/**
	 * 是否启用
	 */
	private Boolean enable;

}

