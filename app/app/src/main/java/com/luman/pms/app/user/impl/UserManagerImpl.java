package com.luman.pms.app.user.impl;

import com.luman.pms.app.user.exc.qry.UserGetListExc;
import com.luman.pms.client.api.UserManager;
import com.luman.pms.client.dto.user.UserDTO;
import com.luman.smy.common.helper.ResultHelper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserManagerImpl implements UserManager {

	private final UserGetListExc userGetListExc;

	@Override
	public ResultHelper<List<UserDTO>> getUsers() {
		return ResultHelper.of(userGetListExc.getUsers());
	}
}
