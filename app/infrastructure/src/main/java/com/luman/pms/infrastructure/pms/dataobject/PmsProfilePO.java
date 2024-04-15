package com.luman.pms.infrastructure.pms.dataobject;

import com.baomidou.mybatisplus.annotation.TableName;
import com.luman.smy.dal.model.BasePO;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * pms_profile表实体类
 *
 * @author yeyinghao
 * @date 2024/04/14
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("pms_profile")
public class PmsProfilePO extends BasePO {

	/**
	 * 性别
	 */
	private Integer gender;

	/**
	 * 头像地址
	 */
	private String avatar;

	/**
	 * 地址
	 */
	private String address;

	/**
	 * 邮箱
	 */
	private String email;

	/**
	 * userBizId
	 */
	private Long userId;

	/**
	 * 昵称
	 */
	private String nickName;

}

