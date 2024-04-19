package com.luman.pms.application.pms.exec;

import com.luman.pms.domain.pms.gateway.PmsProfileGateway;
import com.luman.pms.domain.pms.gateway.PmsUserGateway;
import com.luman.pms.domain.pms.model.PmsUser;
import com.luman.pms.infrastructure.pms.util.UserTokenUtil;
import com.luman.smy.common.enums.CommErrorEnum;
import com.luman.smy.common.exception.Assert;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Objects;

/**
 * Pms用户删除执行
 *
 * @author yeyinghao
 * @date 2024/04/15
 */
@Component
@RequiredArgsConstructor
public class PmsUserDeleteExec {

	/**
	 * Pms用户数据服务
	 */
	private final PmsUserGateway pmsUserDataService;

	/**
	 * Pms配置文件数据服务
	 */
	private final PmsProfileGateway pmsProfileDataService;

	/**
	 * 删除用户
	 *
	 * @param id id
	 */
	public void removeUser(Long id) {
		Long userId = UserTokenUtil.getUserId();
		Assert.isTrue(Objects.equals(userId, id), CommErrorEnum.BIZ_ERROR, "用户Id不匹配");
		PmsUser pmsUser = pmsUserDataService.findById(id);
		pmsUserDataService.deleteById(pmsUser.getId());
		pmsProfileDataService.deleteByUserId(id);
	}

}
