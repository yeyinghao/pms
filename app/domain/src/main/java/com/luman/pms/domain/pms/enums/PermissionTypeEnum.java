package com.luman.pms.domain.pms.enums;

import com.luman.smy.common.enums.BaseEnum;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@RequiredArgsConstructor
@ToString
public enum PermissionTypeEnum implements BaseEnum {

	/**
	 * 菜单
	 */
	MENU("菜单"),

	/**
	 * 按钮
	 */
	BUTTON("按钮"),

	/**
	 * 接口
	 */
	API("接口"),

	;

	/**
	 * 响应业务码的描述
	 */
	private final String description;

}
