package com.luman.pms.application.pms.exec;

import cn.hutool.core.util.IdUtil;
import com.luman.pms.client.pms.model.req.CreatePermissionReq;
import com.luman.pms.client.pms.model.req.UpdatePermissionReq;
import com.luman.pms.domain.pms.gateway.PmsPermissionGateway;
import com.luman.pms.domain.pms.model.PmsPermission;
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
public class PmsPermissionExec {

	/**
	 * Pms权限数据服务
	 */
	private final PmsPermissionGateway pmsPermissionGateway;

	/**
	 * 创建
	 *
	 * @param req 请求
	 * @return {@link Boolean}
	 */
	public Boolean create(CreatePermissionReq req) {
		PmsPermission pmsPermission = CopyUtil.copy(req, PmsPermission::new);
		pmsPermission.setBizId(IdUtil.getSnowflakeNextId());
		pmsPermissionGateway.save(pmsPermission);
		return Boolean.TRUE;
	}

	/**
	 * 创建批处理
	 *
	 * @param reqs 请求
	 */
	public void createBatch(List<CreatePermissionReq> reqs) {
		List<PmsPermission> pmsPermissions = CopyUtil.copyList(reqs, PmsPermission::new);
		pmsPermissionGateway.saveBatch(pmsPermissions);
	}

	/**
	 * 更新由id
	 *
	 * @param req 请求
	 */
	public void updateById(UpdatePermissionReq req) {
		PmsPermission pmsPermission = CopyUtil.copy(req, PmsPermission::new);
		pmsPermissionGateway.updateById(pmsPermission);
	}

	/**
	 * 删除
	 *
	 * @param id id
	 */
	public void remove(Long id) {
		pmsPermissionGateway.deleteById(id);
	}
}
