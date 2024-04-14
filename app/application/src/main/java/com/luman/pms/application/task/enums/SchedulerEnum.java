package com.luman.pms.application.task.enums;

import com.luman.smy.common.enums.BaseEnum;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@RequiredArgsConstructor
@ToString
public enum SchedulerEnum implements BaseEnum {

	TEST("测试"),

	;


	/**
	 * 响应业务码的描述
	 */
	private final String description;
}
