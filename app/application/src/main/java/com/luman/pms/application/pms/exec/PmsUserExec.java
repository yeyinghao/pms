package com.luman.pms.application.pms.exec;

import cn.dev33.satoken.stp.StpUtil;
import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.StrUtil;
import com.luman.pms.application.pms.convert.UserConvert;
import com.luman.pms.application.pms.exec.qry.PmsBizIdQryExec;
import com.luman.pms.application.pms.exec.trans.PmsTrans;
import com.luman.pms.client.pms.model.req.*;
import com.luman.pms.domain.pms.gateway.PmsProfileGateway;
import com.luman.pms.domain.pms.gateway.PmsUserGateway;
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
	private final PmsUserGateway pmsUserGateway;

	/**
	 * Pms配置文件数据服务
	 */
	private final PmsProfileGateway pmsProfileGateway;

	private final PmsBizIdQryExec pmsBizIdQryExec;

	private final PmsTrans pmsTrans;

	/**
	 * 注册
	 *
	 * @param req 请求
	 */
	public void register(RegisterUserReq req) {
		PmsUser pmsUser = pmsUserGateway.findByName(req.getUserName());
		// 存在报错
		Assert.isNull(pmsUser, CommErrorEnum.BIZ_ERROR, "用户已存在");
		pmsUser = new PmsUser();
		pmsUser.setBizId(IdUtil.getSnowflakeNextId());
		pmsUser.setUserName(req.getUserName());
		pmsUser.setPassword(req.getPassword());
		pmsUser.setUserCode(getUserCode());
		pmsUser.setEnable(Boolean.TRUE);
		PmsProfile pmsProfile = UserConvert.buildProfile(req.getProfile(), pmsUser.getBizId());
		// 转化角色id为角色bizId
		List<Long> roleBizIds = pmsBizIdQryExec.roleIds2RoleBizIds(req.getRoleIds());
		List<PmsUserRole> userRoleList = UserConvert.buildUserRoles(roleBizIds, pmsUser.getBizId());
		pmsTrans.registerByTrans(pmsUser, pmsProfile, userRoleList);
	}

	/**
	 * 获取用户代码
	 *
	 * @return {@link String}
	 */
	private String getUserCode() {
		String userCode = CodeUtil.randomString(8);
		PmsUser pmsUser = pmsUserGateway.findByUserCode(userCode);
		while (pmsUser != null) {
			userCode = CodeUtil.randomString(8);
			pmsUser = pmsUserGateway.findByUserCode(userCode);
		}
		return userCode;
	}

	/**
	 * 添加角色
	 *
	 * @param req 请求
	 */
	public void addRoles(AddUserRolesReq req) {
		PmsUser pmsUser = pmsUserGateway.findById(req.getId());
		Assert.notNull(pmsUser, CommErrorEnum.BIZ_ERROR, "用户不存在");
		// 转化角色id为角色bizId
		List<Long> roleBizIds = pmsBizIdQryExec.roleIds2RoleBizIds(req.getRoleIds());
		List<PmsUserRole> list = UserConvert.buildUserRoles(roleBizIds, pmsUser.getBizId());
		pmsTrans.addRolesByTrans(pmsUser, list);
	}

	/**
	 * 删除用户
	 *
	 * @param id id
	 */
	public void removeUser(Long id) {
		PmsUser pmsUser = pmsUserGateway.findById(id);
		Assert.notNull(pmsUser, CommErrorEnum.BIZ_ERROR, "用户不存在");
		pmsTrans.removeUserByTrans(pmsUser);
	}

	/**
	 * 更改密码
	 *
	 * @param req 请求
	 */
	public void changePassword(ChangePasswordReq req) {
		String username = (String) StpUtil.getExtra(SaTokenConstant.JWT_USERNAME_KEY);
		PmsUser pmsUser = pmsUserGateway.findByName(username);
		Assert.notNull(pmsUser, CommErrorEnum.BIZ_ERROR);
		Assert.isTrue(StrUtil.equals(pmsUser.getPassword(), req.getOldPassword()), CommErrorEnum.BIZ_ERROR);
		pmsUser.setPassword(req.getNewPassword());
		pmsUserGateway.updateById(pmsUser);
		StpUtil.logout();
	}

	/**
	 * 重置密码
	 *
	 * @param req 请求
	 */
	public void resetPassword(UpdatePasswordReq req) {
		PmsUser pmsUser = pmsUserGateway.findById(req.getId());
		pmsUser.setPassword(req.getPassword());
		pmsUserGateway.updateById(pmsUser);
	}

	/**
	 * 更新配置文件
	 *
	 * @param req 请求
	 */
	public void updateProfile(UpdateProfileReq req) {
		Long id = UserTokenUtil.getId();
		PmsProfile pmsProfile = PmsProfile.buildPmsProfile(id, req);
		pmsProfileGateway.updateByUserId(pmsProfile);
	}

	/**
	 * 更新
	 *
	 * @param req 请求
	 */
	public void update(UpdateUserReq req) {
		PmsUser pmsUser = pmsUserGateway.findById(req.getId());
		pmsUser.setEnable(req.getEnable());
		pmsUserGateway.updateById(pmsUser);
	}
}
