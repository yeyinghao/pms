package com.luman.pms.infrastructure.db.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.luman.pms.infrastructure.db.dataobject.UserPO;
import org.apache.ibatis.annotations.Mapper;

/**
 * user表数据库访问层
 *
 * @author yeyinghao
 * @date 2024/01/10
 */
@Mapper
public interface UserMapper extends BaseMapper<UserPO> {
}
