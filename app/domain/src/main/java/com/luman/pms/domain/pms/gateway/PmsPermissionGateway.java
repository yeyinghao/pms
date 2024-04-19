package com.luman.pms.domain.pms.gateway;

import com.luman.pms.domain.pms.model.PmsPermission;
import com.luman.smy.common.gateway.Gateway;

import java.util.List;

/**
 * pms_permission表数据库服务
 *
 * @author yeyinghao
 * @date 2024/04/14
 */
public interface PmsPermissionGateway extends Gateway<PmsPermission> {

	Boolean validateMenuPath(String path);

	List<PmsPermission> findButtonAndApi();

	List<PmsPermission> findAllByMenu();

}
