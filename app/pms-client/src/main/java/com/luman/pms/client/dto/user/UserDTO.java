package com.luman.pms.client.dto.user;

import com.luman.smy.common.base.DTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class UserDTO extends DTO {

	/**
	 * 姓名
	 */
	private String name;

	/**
	 * userNo
	 */
	private String userNo;

	/**
	 * 年龄
	 */
	private Integer age;

	/**
	 * 邮箱
	 */
	private String email;


}
