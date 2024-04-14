package com.luman.pms.domain.dp;

import com.luman.smy.common.model.BaseDP;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * user表领域模型
 *
 * @author yeyinghao
 * @date 2024/01/14
 */
@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
public class User extends BaseDP {

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

	/**
	 * 密码
	 */
	private String password;

}

