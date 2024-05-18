package com.luman.pms.application.pms.exec;

import cn.dev33.satoken.stp.StpUtil;
import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.StrUtil;
import com.luman.pms.application.pms.convert.UserConvert;
import com.luman.pms.application.pms.exec.trans.PmsTrans;
import com.luman.pms.client.pms.model.req.*;
import com.luman.pms.domain.pms.gateway.PmsProfileGateway;
import com.luman.pms.domain.pms.gateway.PmsUserGateway;
import com.luman.pms.domain.pms.gateway.PmsUserRoleGateway;
import com.luman.pms.domain.pms.model.PmsProfile;
import com.luman.pms.domain.pms.model.PmsUser;
import com.luman.pms.domain.pms.model.PmsUserRole;
import com.luman.pms.infrastructure.pms.util.UserTokenUtil;
import com.luman.smy.common.enums.CommErrorEnum;
import com.luman.smy.common.exception.Assert;
import com.luman.smy.common.util.CodeUtil;
import com.luman.smy.token.constant.SaTokenConstant;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;

/**
 * Pms用户添加执行
 *
 * @author yeyinghao
 * @date 2024/04/15
 */
@Component
@RequiredArgsConstructor
public class PmsUserExec {

	/**
	 * Pms用户数据服务
	 */
	private final PmsUserGateway pmsUserDataService;

	/**
	 * Pms配置文件数据服务
	 */
	private final PmsProfileGateway pmsProfileDataService;

	/**
	 * Pms用户角色数据服务
	 */
	private final PmsUserRoleGateway pmsUserRoleDataService;

	private final PmsTrans pmsTrans;

	/**
	 * 注册
	 *
	 * @param req 请求
	 */
	public void register(RegisterUserReq req) {
		PmsUser pmsUser = pmsUserDataService.findByName(req.getUserName());
		// 存在报错
		Assert.isNull(pmsUser, CommErrorEnum.BIZ_ERROR, "用户已存在");
		pmsUser = new PmsUser();
		pmsUser.setUserId(IdUtil.getSnowflakeNextId());
		pmsUser.setUserName(req.getUserName());
		pmsUser.setPassword(req.getPassword());
		pmsUser.setUserCode(getUserCode());
		pmsUser.setEnable(Boolean.TRUE);

		PmsProfile pmsProfile = UserConvert.buildProfile(req.getProfile(), pmsUser.getUserId());
		List<PmsUserRole> userRoleList = UserConvert.buildUserRoles(req.getRoleIds(), pmsUser.getUserId());

		pmsUserDataService.save(pmsUser);
		pmsProfileDataService.save(pmsProfile);
		pmsUserRoleDataService.saveBatch(userRoleList);
	}

	/**
	 * 获取用户代码
	 *
	 * @return {@link String}
	 */
	private String getUserCode() {
		String userCode = CodeUtil.randomString(8);
		PmsUser pmsUser = pmsUserDataService.findByUserCode(userCode);
		while (pmsUser != null) {
			userCode = CodeUtil.randomString(8);
			pmsUser = pmsUserDataService.findByUserCode(userCode);
		}
		return userCode;
	}

	/**
	 * 添加角色
	 *
	 * @param req 请求
	 */
	public void addRoles(AddUserRolesReq req) {

		PmsUser pmsUser = pmsUserDataService.findById(req.getId());
		Assert.isNull(pmsUser, CommErrorEnum.BIZ_ERROR, "用户不存在");

		List<PmsUserRole> list = UserConvert.buildUserRoles(req.getRoleIds(), req.getId());

		pmsTrans.addRolesByTrans(pmsUser, list);
	}

	/**
	 * 删除用户
	 *
	 * @param id id
	 */
	public void removeUser(Long id) {
		Assert.isTrue(Objects.equals(UserTokenUtil.getId(), id), CommErrorEnum.BIZ_ERROR, "用户Id不匹配");
		PmsUser pmsUser = pmsUserDataService.findById(id);
		pmsUserDataService.deleteById(pmsUser.getId());
		pmsProfileDataService.deleteByUserId(id);
	}

	/**
	 * 更改密码
	 *
	 * @param req 请求
	 */
	public void changePassword(ChangePasswordReq req) {
		String username = (String) StpUtil.getExtra(SaTokenConstant.JWT_USERNAME_KEY);
		PmsUser pmsUser = pmsUserDataService.findByName(username);
		Assert.notNull(pmsUser, CommErrorEnum.BIZ_ERROR);
		Assert.isTrue(StrUtil.equals(pmsUser.getPassword(), req.getOldPassword()), CommErrorEnum.BIZ_ERROR);
		pmsUser.setPassword(req.getNewPassword());
		pmsUserDataService.updateById(pmsUser);
		StpUtil.logout();
	}

	/**
	 * 重置密码
	 *
	 * @param req 请求
	 */
	public void resetPassword(UpdatePasswordReq req) {
		PmsUser pmsUser = pmsUserDataService.findById(req.getId());
		pmsUser.setPassword(req.getPassword());
		pmsUserDataService.updateById(pmsUser);
	}

	/**
	 * 更新配置文件
	 *
	 * @param req 请求
	 */
	public void updateProfile(UpdateProfileReq req) {
		Long id = UserTokenUtil.getId();
		PmsProfile pmsProfile = PmsProfile.buildPmsProfile(id, req);
		pmsProfileDataService.updateByUserId(pmsProfile);
	}

	/**
	 * 更新
	 *
	 * @param req 请求
	 */
	public void update(UpdateUserReq req) {
		PmsUser pmsUser = pmsUserDataService.findById(req.getId());
		pmsUser.setEnable(req.getEnable());
		pmsUserDataService.updateById(pmsUser);
	}
}
