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
	PmsUser findByName(String userName);

	PmsUser findByUserCode(String userCode);
}
