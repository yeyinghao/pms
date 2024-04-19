package com.luman.pms.domain.pms.gateway;

import com.luman.pms.domain.pms.model.PmsProfile;
import com.luman.smy.common.gateway.Gateway;

/**
 * pms_profile表数据库服务
 *
 * @author yeyinghao
 * @date 2024/04/14
 */
public interface PmsProfileGateway extends Gateway< PmsProfile> {
	PmsProfile findByUserId(Long userId);

	void deleteByUserId(Long userId);

	void updateByUserId(PmsProfile entity);
}
