package com.luman.pms.start;

import com.alibaba.nacos.spring.context.annotation.config.NacosPropertySource;
import com.luman.smy.common.util.LoggerUtil;
import com.luman.smy.common.util.TimeUtil;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.Environment;

/**
 * Spring Boot Starter
 *
 * @author Frank Zhang
 */
@Slf4j
@SpringBootApplication(scanBasePackages = {"com.luman.pms", "com.luman.smy"})
@ServletComponentScan(basePackages = "com.luman.smy.common.web.filter")
@MapperScan(basePackages = {
		"com.luman.pms.infrastructure.pms.mapper",
		"com.luman.pms.infrastructure.user.mapper"
})
@NacosPropertySource(dataId = "pms.yml", autoRefreshed = true)
public class Application {

	public static void main(String[] args) {
		try {
			long startTime = System.currentTimeMillis();
			ConfigurableApplicationContext configurableApplicationContext = SpringApplication.run(Application.class, args);
			Environment environment = configurableApplicationContext.getBean(Environment.class);
			LoggerUtil.info(log, "Application", "Success", environment.getProperty("server.port"), TimeUtil.getCostTime(startTime));
		} catch (Throwable e) {
			LoggerUtil.error(log, "Application", "Fail", e);
		}
	}
}
