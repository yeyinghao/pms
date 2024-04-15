package com.luman.pms.infrastructure.user;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.luman.pms.domain.dp.User;
import com.luman.smy.common.util.CopyUtil;
import org.springframework.stereotype.Service;

/**
 * 用户数据服务实现
 *
 * @author yeyinghao
 * @date 2024/04/02
 */
@Service
public class UserDataServiceImpl extends ServiceImpl<UserMapper, UserPO> implements UserDataService {

	@Override
	public UserPO convertToPO(User dp) {
		return CopyUtil.copy(dp, UserPO::new, (s, t) -> {
		});
	}

	@Override
	public User convertToDO(UserPO po) {
		return CopyUtil.copy(po, User::new, (s, t) -> {
		});
	}

}