package com.luman.pms.application.pms.user.exec;

import com.luman.pms.domain.pms.dp.PmsUser;
import com.luman.pms.infrastructure.pms.service.PmsProfileDataService;
import com.luman.pms.infrastructure.pms.service.PmsRoleDataService;
import com.luman.pms.infrastructure.pms.service.PmsUserDataService;
import com.luman.pms.infrastructure.pms.service.PmsUserRoleDataService;
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
	private final PmsUserDataService pmsUserDataService;

	/**
	 * Pms角色数据服务
	 */
	private final PmsRoleDataService pmsRoleDataService;

	/**
	 * Pms配置文件数据服务
	 */
	private final PmsProfileDataService pmsProfileDataService;

	/**
	 * Pms用户角色数据服务
	 */
	private final PmsUserRoleDataService pmsUserRoleDataService;

	/**
	 * 删除用户
	 *
	 * @param id id
	 * @return {@link Boolean}
	 */
	public Boolean removeUser(Long id) {
		Long userId = UserTokenUtil.getUserId();
		Assert.isTrue(Objects.equals(userId, id), CommErrorEnum.BIZ_ERROR, "用户Id不匹配");
		PmsUser pmsUser = pmsUserDataService.findById(id);
		pmsUserDataService.deleteById(pmsUser.getId());
		pmsProfileDataService.deleteByUserId(id);
		return Boolean.TRUE;
	}

}
