package com.luman.pms.application.pms.exec;

import com.luman.pms.domain.pms.gateway.PmsPermissionGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * Pms权限删除执行
 *
 * @author yeyinghao
 * @date 2024/04/15
 */
@Component
@RequiredArgsConstructor
public class PmsPermissionDeleteExec {

	/**
	 * Pms权限数据服务
	 */
	private final PmsPermissionGateway pmsPermissionDataService;

	/**
	 * 删除
	 *
	 * @param id id
	 */
	public void remove(Long id) {
		 pmsPermissionDataService.deleteById(id);
	}

}
