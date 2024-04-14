/*
 * Copyright (c) Ye Yinghao
 * 2022.1 - 2024.2
 */

package com.luman.pms.app.task;

import com.luman.pms.app.task.enums.SchedulerEnum;
import com.luman.smy.task.template.TaskTemplate;
import com.xxl.job.core.handler.annotation.XxlJob;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * 汇裁令牌工厂
 *
 * @author yeyinghao
 * @date 2024/02/28
 */
@Component
@RequiredArgsConstructor
public class TestScheduler {

	private final TaskTemplate taskTemplate;

	private final TaskService taskService;

	@XxlJob("testHander")
	public boolean test() {
		return taskTemplate.taskHandle(SchedulerEnum.TEST, taskService::datas, taskService::handle);
	}
}
