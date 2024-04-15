package com.luman.pms.application.pms.permission.exec;

import com.luman.pms.infrastructure.pms.service.PmsPermissionDataService;
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
	private final PmsPermissionDataService pmsPermissionDataService;

	/**
	 * 删除
	 *
	 * @param id id
	 * @return {@link Boolean}
	 */
	public Boolean remove(Long id) {
		return pmsPermissionDataService.removeById(id);
	}

}
