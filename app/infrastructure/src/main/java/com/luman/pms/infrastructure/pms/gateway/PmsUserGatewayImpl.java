package com.luman.pms.infrastructure.pms.gateway;

import com.luman.pms.domain.pms.gateway.PmsUserGateway;
import com.luman.pms.domain.pms.model.PmsUser;
import com.luman.pms.infrastructure.pms.dataobject.PmsUserPO;
import com.luman.smy.common.util.CopyUtil;
import com.luman.smy.dal.gateway.GatewayImpl;
import org.springframework.stereotype.Service;

/**
 * pms_user表数据库服务实现
 *
 * @author yeyinghao
 * @date 2024/04/14
 */
@Service
public class PmsUserGatewayImpl extends GatewayImpl<PmsUserPO, PmsUser> implements PmsUserGateway {

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

	@Override
	public PmsUser findByName(String userName) {
		PmsUserPO entity = lambdaQuery().eq(PmsUserPO::getUserName, userName).one();
		return convertToDO(entity);
	}

	@Override
	public PmsUser findByUserCode(String userCode) {
		PmsUserPO entity = lambdaQuery().eq(PmsUserPO::getUserCode, userCode).one();
		return convertToDO(entity);
	}
}
