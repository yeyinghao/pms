package com.luman.pms.infrastructure.pms.gateway;

import com.luman.pms.domain.pms.gateway.PmsProfileGateway;
import com.luman.pms.domain.pms.model.PmsProfile;
import com.luman.pms.infrastructure.pms.dataobject.PmsProfilePO;
import com.luman.smy.common.util.CopyUtil;
import com.luman.smy.dal.gateway.GatewayImpl;
import org.springframework.stereotype.Service;

/**
 * pms_profile表数据库服务实现
 *
 * @author yeyinghao
 * @date 2024/04/14
 */
@Service
public class PmsProfileGatewayImpl extends GatewayImpl<PmsProfilePO, PmsProfile> implements PmsProfileGateway {

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

	@Override
	public PmsProfile findByUserId(Long userId) {
		PmsProfilePO entity = lambdaQuery().eq(PmsProfilePO::getStatus, Boolean.TRUE)
				.eq(PmsProfilePO::getUserId, userId).one();
		return convertToDO(entity);
	}

	@Override
	public void deleteByUserId(Long userId) {
		lambdaUpdate().eq(PmsProfilePO::getUserId, userId).remove();
	}

	@Override
	public void updateByUserId(PmsProfile entity) {
		lambdaUpdate().eq(PmsProfilePO::getUserId, entity.getUserId())
				.update(convertToPO(entity));
	}
}
