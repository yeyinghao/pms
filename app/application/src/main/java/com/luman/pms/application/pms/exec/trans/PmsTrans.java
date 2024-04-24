package com.luman.pms.application.pms.exec.trans;

import com.luman.pms.domain.pms.gateway.PmsUserRoleGateway;
import com.luman.pms.domain.pms.model.PmsUser;
import com.luman.pms.domain.pms.model.PmsUserRole;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@RequiredArgsConstructor
public class PmsTrans {

	/**
	 * Pms用户角色数据服务
	 */
	private final PmsUserRoleGateway pmsUserRoleDataService;

	@Transactional(rollbackFor = Throwable.class)
	public void addRolesByTrans(PmsUser pmsUser, List<PmsUserRole> list) {
		pmsUserRoleDataService.removeByUserId(pmsUser.getUserId());
		pmsUserRoleDataService.saveBatch(list);
	}
}
