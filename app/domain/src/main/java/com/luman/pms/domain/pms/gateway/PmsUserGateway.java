package com.luman.pms.domain.pms.gateway;

import com.luman.pms.domain.pms.model.PmsUser;
import com.luman.smy.common.gateway.Gateway;

/**
 * pms_user表数据库服务
 *
 * @author yeyinghao
 * @date 2024/04/14
 */
public interface PmsUserGateway extends Gateway< PmsUser> {
	/**
	 * 找到通过名称
	 *
	 * @param userName 用户名称
	 * @return {@link PmsUser }
	 */
	PmsUser findByName(String userName);

	/**
	 * 按用户代码查找
	 *
	 * @param userCode 用户代码
	 * @return {@link PmsUser }
	 */
	PmsUser findByUserCode(String userCode);
}
