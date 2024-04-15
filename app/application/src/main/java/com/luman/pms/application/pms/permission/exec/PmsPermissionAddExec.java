package com.luman.pms.application.pms.permission.exec;

import com.luman.pms.client.pms.dto.req.CreatePermissionReq;
import com.luman.pms.domain.pms.dp.PmsPermission;
import com.luman.pms.infrastructure.pms.service.PmsPermissionDataService;
import com.luman.smy.common.util.CopyUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Pms权限添加执行
 *
 * @author yeyinghao
 * @date 2024/04/15
 */
@Component
@RequiredArgsConstructor
public class PmsPermissionAddExec {

	/**
	 * Pms权限数据服务
	 */
	private final PmsPermissionDataService pmsPermissionDataService;

	/**
	 * 创建
	 *
	 * @param req 请求
	 * @return {@link Boolean}
	 */
	public Boolean create(CreatePermissionReq req) {
		PmsPermission pmsPermission = CopyUtil.copy(req, PmsPermission::new);
		pmsPermissionDataService.save(pmsPermission);
		return Boolean.TRUE;
	}

	/**
	 * 创建批处理
	 *
	 * @param reqs 请求
	 * @return {@link Boolean}
	 */
	public Boolean createBatch(List<CreatePermissionReq> reqs) {
		List<PmsPermission> pmsPermissions = CopyUtil.copyList(reqs, PmsPermission::new);
		pmsPermissionDataService.saveBatch(pmsPermissions);
		return Boolean.TRUE;
	}
}
