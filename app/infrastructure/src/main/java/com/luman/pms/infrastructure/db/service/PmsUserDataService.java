package com.luman.pms.infrastructure.db.service;

import com.luman.pms.domain.dp.PmsUser;
import com.luman.pms.infrastructure.db.dataobject.PmsUserPO;
import com.luman.smy.dal.service.DataService;

/**
 * pms_user表数据库服务
 *
 * @author yeyinghao
 * @date 2024/04/14
 */
public interface PmsUserDataService extends DataService<PmsUserPO, PmsUser> {

}
