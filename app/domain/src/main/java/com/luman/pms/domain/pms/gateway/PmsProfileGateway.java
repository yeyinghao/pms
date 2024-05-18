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
	/**
	 * 找到通过用户id
	 *
	 * @param userId 用户id
	 * @return {@link PmsProfile }
	 */
	PmsProfile findByUserId(Long userId);

	/**
	 * 删除通过用户id
	 *
	 * @param userId 用户id
	 */
	void deleteByUserId(Long userId);

	/**
	 * 更新通过用户id
	 *
	 * @param entity 实体
	 */
	void updateByUserId(PmsProfile entity);
}
