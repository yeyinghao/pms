package com.luman.pms.infrastructure.pms.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.luman.pms.infrastructure.pms.dataobject.PmsPermissionPO;
import org.springframework.stereotype.Repository;

/**
 * pms_permission表数据库访问层
 *
 * @author yeyinghao
 * @date 2024/04/14
 */
@Repository
public interface PmsPermissionMapper extends BaseMapper<PmsPermissionPO> {

}
