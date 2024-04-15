package com.luman.pms.infrastructure.pms.service;

import com.luman.pms.domain.pms.dp.PmsProfile;
import com.luman.pms.infrastructure.pms.dataobject.PmsProfilePO;
import com.luman.smy.dal.service.DataService;

/**
 * pms_profile表数据库服务
 *
 * @author yeyinghao
 * @date 2024/04/14
 */
public interface PmsProfileDataService extends DataService<PmsProfilePO, PmsProfile> {
	PmsProfile findByUserId(Long userId);

	void deleteByUserId(Long userId);

	void updateByUserId(PmsProfile entity);
}
