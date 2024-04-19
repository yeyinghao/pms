package com.luman.pms.application.pms.exec;

import com.luman.pms.client.pms.model.req.UpdatePermissionReq;
import com.luman.pms.domain.pms.model.PmsPermission;
import com.luman.pms.domain.pms.gateway.PmsPermissionGateway;
import com.luman.smy.common.util.CopyUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * Pms权限更新执行
 *
 * @author yeyinghao
 * @date 2024/04/15
 */
@Component
@RequiredArgsConstructor
public class PmsPermissionUpdateExec {

	/**
	 * Pms权限数据服务
	 */
	private final PmsPermissionGateway pmsPermissionDataService;

	/**
	 * 更新由id
	 *
	 * @param req 请求
	 */
	public void updateById(UpdatePermissionReq req) {
		PmsPermission pmsPermission = CopyUtil.copy(req, PmsPermission::new);
		pmsPermissionDataService.updateById(pmsPermission);
	}
}
