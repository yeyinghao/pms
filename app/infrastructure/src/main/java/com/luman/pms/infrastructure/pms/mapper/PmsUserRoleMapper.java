package com.luman.pms.infrastructure.pms.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.luman.pms.infrastructure.pms.dataobject.PmsUserRolePO;
import org.springframework.stereotype.Repository;

/**
 * pms_user_role表数据库访问层
 *
 * @author yeyinghao
 * @date 2024/04/14
 */
@Repository
public interface PmsUserRoleMapper extends BaseMapper<PmsUserRolePO> {

}
