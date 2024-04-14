/*
 * QQ: 1113531030 WX: missyeyh Phone: 17689397484 Copyright (c) Ye Yinghao 2022.1 - 2023.2
 */

package com.luman.pms.infrastructure.db;

import com.luman.smy.common.constant.CommConstant;
import com.luman.smy.common.constant.LoggerConstant;
import com.luman.smy.common.util.LoggerUtil;
import com.luman.smy.common.util.TimeUtil;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

/**
 * dal切面
 *
 * @author yeyinghao
 * @date 2024/04/04
 */
@Aspect
@Component
@EnableAspectJAutoProxy(proxyTargetClass = true)
@Slf4j(topic = LoggerConstant.DAL_MONITOR_LOGGER)
public class DalAspect {

	/**
	 * 周围
	 *
	 * @param joinPoint 连接点
	 * @return {@link Object}
	 */
	@SneakyThrows
	@Around("execution(* com.luman.pms.infrastructure.gateway..*GatewayImpl.*(..))")
	public Object around(ProceedingJoinPoint joinPoint) {
		long startTime = System.currentTimeMillis();
		String res = CommConstant.N;
		String className = null;
		String methodName = null;
		try {
			className = joinPoint.getSignature().getDeclaringType().getSimpleName();
			methodName = joinPoint.getSignature().getName();
			Object proceed = joinPoint.proceed();
			res = CommConstant.Y;
			return proceed;
		} catch (Throwable e) {
			res = CommConstant.N;
			throw e;
		} finally {
			LoggerUtil.info(log, className, methodName, res, TimeUtil.getCostTime(startTime));
		}
	}

}
