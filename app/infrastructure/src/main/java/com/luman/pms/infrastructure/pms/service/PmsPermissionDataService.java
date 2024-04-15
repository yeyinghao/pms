package com.luman.pms.infrastructure.pms.service;

import com.luman.pms.domain.pms.dp.PmsPermission;
import com.luman.pms.infrastructure.pms.dataobject.PmsPermissionPO;
import com.luman.smy.dal.service.DataService;

import java.util.List;

/**
 * pms_permission表数据库服务
 *
 * @author yeyinghao
 * @date 2024/04/14
 */
public interface PmsPermissionDataService extends DataService<PmsPermissionPO, PmsPermission> {

	Boolean validateMenuPath(String path);

	List<PmsPermission> findButtonAndApi();

	List<PmsPermission> findAllByMenu();

}
