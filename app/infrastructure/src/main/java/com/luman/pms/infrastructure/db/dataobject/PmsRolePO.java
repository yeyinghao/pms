package com.luman.pms.infrastructure.db.dataobject;

import com.baomidou.mybatisplus.annotation.TableName;
import com.luman.smy.dal.model.BasePO;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * pms_role表实体类
 *
 * @author yeyinghao
 * @date 2024/04/14
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("pms_role")
public class PmsRolePO extends BasePO {

	/**
	 * 编号
	 */
	private String code;

	/**
	 * 名称
	 */
	private String name;

	/**
	 * 是否启用
	 */
	private Boolean enable;

}

