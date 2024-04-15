package com.luman.pms.application.user.impl;

import com.luman.pms.application.user.exc.qry.UserGetListExc;
import com.luman.pms.client.api.UserManager;
import com.luman.pms.client.dto.user.UserDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserManagerImpl implements UserManager {

	private final UserGetListExc userGetListExc;

	@Override
	public List<UserDTO> getUsers() {
		return userGetListExc.getUsers();
	}
}
