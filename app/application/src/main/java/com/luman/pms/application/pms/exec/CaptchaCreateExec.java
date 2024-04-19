package com.luman.pms.application.pms.exec;

import cn.hutool.captcha.ICaptcha;
import cn.hutool.core.lang.Pair;
import com.luman.pms.infrastructure.pms.captcha.CaptchaService;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 验证码创建执行
 *
 * @author yeyinghao
 * @date 2024/04/15
 */
@Component
@RequiredArgsConstructor
public class CaptchaCreateExec {

	/**
	 * 验证码key
	 */
	public static final String CAPTCHA_KEY = "captchaKey";

	/**
	 * 验证码服务
	 */
	private final CaptchaService captchaService;

	/**
	 * 请求
	 */
	private final HttpServletRequest request;

	/**
	 * 响应
	 */
	private final HttpServletResponse response;

	/**
	 * 验证码
	 */
	@SneakyThrows
	public void captcha() {
		Pair<String, ICaptcha> captchaPair = captchaService.create();
		HttpSession session = request.getSession();
		session.setAttribute(CAPTCHA_KEY, captchaPair.getKey());
		captchaPair.getValue().write(response.getOutputStream());
	}
}
