/*
 * Copyright (c) Ye Yinghao
 * 2022.1 - 2024.3
 */

package com.luman.pms.test;


import com.luman.smy.common.enums.BaseEnum;
import com.luman.smy.common.enums.CommErrorEnum;
import org.junit.jupiter.api.Test;

/**
 * 基础枚举测试
 *
 * @author yeyinghao
 * @date 2024/03/31
 */
public class BaseEnumTest {

	@Test
	public void commErrorEnumTest() {
		BaseEnum[] values = CommErrorEnum.values();
		StringBuffer sb = new StringBuffer();
		sb.append("[");
		for (BaseEnum item : values) {
			sb.append("{ label").append(":'").append(item.getDescription()).append("' , ").append("value").append(":'").append(item.name()).append("'},");
		}
		sb.append("]");
		System.out.println(sb);
	}

}
