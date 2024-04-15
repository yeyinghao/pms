package com.luman.pms.application.pms.permission.exec;

import com.luman.pms.client.pms.dto.req.UpdatePermissionReq;
import com.luman.pms.domain.pms.dp.PmsPermission;
import com.luman.pms.infrastructure.pms.service.PmsPermissionDataService;
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
	private final PmsPermissionDataService pmsPermissionDataService;

	/**
	 * 更新由id
	 *
	 * @param req 请求
	 * @return {@link Boolean}
	 */
	public Boolean updateById(UpdatePermissionReq req) {
		PmsPermission pmsPermission = CopyUtil.copy(req, PmsPermission::new);
		pmsPermissionDataService.updateById(pmsPermission);
		return Boolean.TRUE;
	}
}
