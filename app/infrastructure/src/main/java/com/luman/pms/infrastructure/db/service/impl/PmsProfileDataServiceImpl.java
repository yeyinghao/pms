package com.luman.pms.infrastructure.db.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.luman.pms.domain.dp.PmsProfile;
import com.luman.pms.infrastructure.db.dataobject.PmsProfilePO;
import com.luman.pms.infrastructure.db.mapper.PmsProfileMapper;
import com.luman.pms.infrastructure.db.service.PmsProfileDataService;
import com.luman.smy.common.util.CopyUtil;
import org.springframework.stereotype.Service;

/**
 * pms_profile表数据库服务实现
 *
 * @author yeyinghao
 * @date 2024/04/14
 */
@Service
public class PmsProfileDataServiceImpl extends ServiceImpl<PmsProfileMapper, PmsProfilePO> implements PmsProfileDataService {

	@Override
	public PmsProfile convertToDO(PmsProfilePO po) {
		return CopyUtil.copy(po, PmsProfile::new, (s, t) -> {
		});
	}

	@Override
	public PmsProfilePO convertToPO(PmsProfile dp) {
		return CopyUtil.copy(dp, PmsProfilePO::new, (s, t) -> {
		});
	}
}
