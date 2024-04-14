package com.luman.pms.infrastructure.db.service;

import com.luman.pms.domain.dp.PmsProfile;
import com.luman.pms.infrastructure.db.dataobject.PmsProfilePO;
import com.luman.smy.dal.service.DataService;

/**
 * pms_profile表数据库服务
 *
 * @author yeyinghao
 * @date 2024/04/14
 */
public interface PmsProfileDataService extends DataService<PmsProfilePO, PmsProfile> {

}
