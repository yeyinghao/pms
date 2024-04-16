package com.luman.pms.infrastructure.pms.dataobject;

import com.baomidou.mybatisplus.annotation.TableName;
import com.kqinfo.universal.mybatis.annotation.FieldEncrypt;
import com.luman.smy.dal.model.BasePO;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * pms_user表实体类
 *
 * @author yeyinghao
 * @date 2024/04/14
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("pms_user")
public class PmsUserPO extends BasePO {

	/**
	 * 名称
	 */
	private String userName;

	/**
	 * 用户code
	 */
	private String userCode;

	/**
	 * 密码
	 */
	@FieldEncrypt
	private String password;

	/**
	 * 是否启用
	 */
	private Boolean enable;

}

