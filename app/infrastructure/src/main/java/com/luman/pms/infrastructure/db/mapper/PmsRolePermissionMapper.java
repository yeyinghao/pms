package com.luman.pms.infrastructure.db.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.luman.pms.infrastructure.db.dataobject.PmsRolePermissionPO;
import org.springframework.stereotype.Repository;

/**
 * pms_role_permission表数据库访问层
 *
 * @author yeyinghao
 * @date 2024/04/14
 */
@Repository
public interface PmsRolePermissionMapper extends BaseMapper<PmsRolePermissionPO> {

}
