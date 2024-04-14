package com.luman.pms.infrastructure.db.service;

import com.luman.pms.domain.dp.PmsPermission;
import com.luman.pms.infrastructure.db.dataobject.PmsPermissionPO;
import com.luman.smy.dal.service.DataService;

/**
 * pms_permission表数据库服务
 *
 * @author yeyinghao
 * @date 2024/04/14
 */
public interface PmsPermissionDataService extends DataService<PmsPermissionPO, PmsPermission> {

}
