package com.luman.pms.adapter.enums;

import com.luman.smy.common.enums.BaseEnum;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@RequiredArgsConstructor
@ToString
public enum UserEnum implements BaseEnum {

	/**
	 * 查询用户列表
	 */
	GET_USERS("查询用户列表");

	;

	/**
	 * 响应业务码的描述
	 */
	private final String description;

}
