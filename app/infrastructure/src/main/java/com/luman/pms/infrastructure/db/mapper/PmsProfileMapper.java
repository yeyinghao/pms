package com.luman.pms.infrastructure.db.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.luman.pms.infrastructure.db.dataobject.PmsProfilePO;
import org.springframework.stereotype.Repository;

/**
 * pms_profile表数据库访问层
 *
 * @author yeyinghao
 * @date 2024/04/14
 */
@Repository
public interface PmsProfileMapper extends BaseMapper<PmsProfilePO> {

}
