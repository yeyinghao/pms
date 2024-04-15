/*
 * Copyright (c) Ye Yinghao
 * 2022.1 - 2024.3
 */

package com.luman.pms.infrastructure.pms.util;

import cn.dev33.satoken.stp.StpUtil;
import cn.hutool.core.convert.NumberWithFormat;
import com.luman.smy.token.constant.SaTokenConstant;

/**
 * 用户令牌工具类
 *
 * @author yeyinghao
 * @date 2024/03/09
 */
public class UserTokenUtil {

	/**
	 * 获取用户id
	 *
	 * @return {@link Long}
	 */
	public static Long getUserId() {
		return ((NumberWithFormat) StpUtil.getExtra(SaTokenConstant.JWT_USER_ID_KEY)).longValue();
	}

	public static String getUserCode() {
		return String.valueOf(StpUtil.getExtra(SaTokenConstant.JWT_USER_CODE_KEY).toString());
	}

}
