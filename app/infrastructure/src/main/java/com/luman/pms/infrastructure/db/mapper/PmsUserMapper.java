package com.luman.pms.infrastructure.db.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.luman.pms.infrastructure.db.dataobject.PmsUserPO;
import org.springframework.stereotype.Repository;

/**
 * pms_user表数据库访问层
 *
 * @author yeyinghao
 * @date 2024/04/14
 */
@Repository
public interface PmsUserMapper extends BaseMapper<PmsUserPO> {

}
