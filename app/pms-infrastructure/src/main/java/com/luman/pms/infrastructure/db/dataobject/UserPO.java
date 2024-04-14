package com.luman.pms.infrastructure.db.dataobject;

import com.baomidou.mybatisplus.annotation.TableName;
import com.kqinfo.universal.mybatis.annotation.FieldEncrypt;
import com.luman.smy.dal.model.BasePO;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * user表实体类
 *
 * @author yeyinghao
 * @date 2024/01/14
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("user")
public class UserPO extends BasePO {

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
	@FieldEncrypt
	private String password;

}

