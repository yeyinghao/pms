package com.luman.pms.application.pms.exec;

import cn.dev33.satoken.stp.SaLoginConfig;
import cn.dev33.satoken.stp.SaTokenInfo;
import cn.dev33.satoken.stp.StpUtil;
import cn.hutool.core.util.StrUtil;
import com.luman.pms.application.pms.exec.qry.PmsRoleQryExec;
import com.luman.pms.client.pms.model.req.LoginReq;
import com.luman.pms.client.pms.model.res.LoginTokenRes;
import com.luman.pms.domain.pms.gateway.PmsUserGateway;
import com.luman.pms.domain.pms.model.PmsRole;
import com.luman.pms.domain.pms.model.PmsUser;
import com.luman.pms.infrastructure.pms.util.UserTokenUtil;
import com.luman.smy.common.enums.CommErrorEnum;
import com.luman.smy.common.exception.Assert;
import com.luman.smy.token.constant.SaTokenConstant;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Pms身份验证令牌执行
 *
 * @author yeyinghao
 * @date 2024/04/15
 */
@Component
@RequiredArgsConstructor
public class PmsAuthTokenExec {

	/**
	 * PMS用户服务
	 */
	private final PmsUserGateway pmsUserDataService;

	/**
	 * PMS用户角色服务
	 */
	private final PmsRoleQryExec pmsRoleQryExec;

	/**
	 * 请求
	 */
	private final HttpServletRequest request;

	/**
	 * 登录
	 *
	 * @param req 请求
	 * @return {@link LoginTokenRes}
	 */
	public LoginTokenRes login(LoginReq req) {
		HttpSession session = request.getSession();
		String captchaKey = (String) session.getAttribute(CaptchaCreateExec.CAPTCHA_KEY);
		if (captchaKey != null) {
			req.setCaptchaKey(captchaKey);
		}
		PmsUser pmsUser = pmsUserDataService.findByName(req.getUserName());
		Assert.notNull(pmsUser, CommErrorEnum.BIZ_ERROR, "用户信息不存在");

//        if (StrUtil.isBlank(req.getCaptchaKey()) || !captchaService.verify(req.getCaptchaKey(), req.getCaptcha())) {
//            throw new BizException(CommonErrorEnum.PROCESS_FAIL);
//        }

		Assert.isTrue(StrUtil.equals(req.getPassword(), pmsUser.getPassword()), CommErrorEnum.BIZ_ERROR, "密码不正确");

		// 查询用户的角色
		List<PmsRole> roles = pmsRoleQryExec.getPmsRolesByUserId(pmsUser.getUserId());
		return generateToken(pmsUser, roles, roles.isEmpty() ? "" : roles.get(0).getCode());
	}

	/**
	 * 刷新令牌
	 *
	 * @return {@link LoginTokenRes}
	 */
	public LoginTokenRes refreshToken() {
		SaTokenInfo tokenInfo = StpUtil.getTokenInfo();
		StpUtil.login(tokenInfo.getLoginId(),
				SaLoginConfig.setExtra(SaTokenConstant.JWT_ID_KEY, StpUtil.getExtra(SaTokenConstant.JWT_ID_KEY))
						.setExtra(SaTokenConstant.JWT_USER_ID_KEY, StpUtil.getExtra(SaTokenConstant.JWT_USER_ID_KEY))
						.setExtra(SaTokenConstant.JWT_USERNAME_KEY, StpUtil.getExtra(SaTokenConstant.JWT_USERNAME_KEY))
						.setExtra(SaTokenConstant.JWT_CURRENT_ROLE_KEY, StpUtil.getExtra(SaTokenConstant.JWT_CURRENT_ROLE_KEY))
						.setExtra(SaTokenConstant.JWT_ROLE_LIST_KEY, StpUtil.getExtra(SaTokenConstant.JWT_ROLE_LIST_KEY)));
		SaTokenInfo newTokenInfo = StpUtil.getTokenInfo();
		LoginTokenRes dto = new LoginTokenRes();
		dto.setAccessToken(newTokenInfo.getTokenValue());
		return dto;
	}

	/**
	 * 开关作用
	 *
	 * @param roleCode 角色代码
	 * @return {@link LoginTokenRes}
	 */
	public LoginTokenRes switchRole(String roleCode) {
		Long id = UserTokenUtil.getId();
		PmsUser pmsUser = pmsUserDataService.findById(id);
		// 查询用户的角色
		List<PmsRole> roles = pmsRoleQryExec.getPmsRolesByUserId(pmsUser.getUserId());
		PmsRole currentRole = null;
		for (PmsRole role : roles) {
			if (roleCode.equals(role.getCode())) {
				currentRole = role;
			}
		}
		Assert.notNull(currentRole, CommErrorEnum.BIZ_ERROR, "角色不存在");
		return generateToken(pmsUser, roles, currentRole.getCode());
	}

	/**
	 * 生成令牌
	 *
	 * @param user            用户
	 * @param roles           角色
	 * @param currentRoleCode 当前角色代码
	 * @return {@link LoginTokenRes}
	 */
	private LoginTokenRes generateToken(PmsUser user, List<PmsRole> roles, String currentRoleCode) {
		// 密码验证成功
		StpUtil.login(user.getId(), SaLoginConfig.setExtra(SaTokenConstant.JWT_ID_KEY, user.getId())
				.setExtra(SaTokenConstant.JWT_USERNAME_KEY, user.getUserName())
				.setExtra(SaTokenConstant.JWT_USER_ID_KEY, user.getUserId())
				.setExtra(SaTokenConstant.JWT_CURRENT_ROLE_KEY, currentRoleCode)
				.setExtra(SaTokenConstant.JWT_USER_CODE_KEY, user.getUserCode())
				.setExtra(SaTokenConstant.JWT_ROLE_LIST_KEY, roles));
		SaTokenInfo tokenInfo = StpUtil.getTokenInfo();
		LoginTokenRes res = new LoginTokenRes();
		res.setAccessToken(tokenInfo.getTokenValue());
		return res;
	}
}
