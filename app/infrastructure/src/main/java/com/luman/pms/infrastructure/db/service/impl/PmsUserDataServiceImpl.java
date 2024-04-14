package com.luman.pms.infrastructure.db.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.luman.pms.domain.dp.PmsUser;
import com.luman.pms.infrastructure.db.dataobject.PmsUserPO;
import com.luman.pms.infrastructure.db.mapper.PmsUserMapper;
import com.luman.pms.infrastructure.db.service.PmsUserDataService;
import com.luman.smy.common.util.CopyUtil;
import org.springframework.stereotype.Service;

/**
 * pms_user表数据库服务实现
 *
 * @author yeyinghao
 * @date 2024/04/14
 */
@Service
public class PmsUserDataServiceImpl extends ServiceImpl<PmsUserMapper, PmsUserPO> implements PmsUserDataService {

	@Override
	public PmsUser convertToDO(PmsUserPO po) {
		return CopyUtil.copy(po, PmsUser::new, (s, t) -> {
		});
	}

	@Override
	public PmsUserPO convertToPO(PmsUser dp) {
		return CopyUtil.copy(dp, PmsUserPO::new, (s, t) -> {
		});
	}
}