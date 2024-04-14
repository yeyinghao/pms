package com.luman.pms.infrastructure.gateway.user;

import com.luman.pms.client.dto.user.UserDTO;
import com.luman.pms.domain.dp.User;
import com.luman.pms.domain.user.gateway.UserGateway;
import com.luman.pms.infrastructure.db.service.UserDataService;
import com.luman.smy.common.util.CopyUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserGatewayImpl implements UserGateway {

	private final UserDataService userDataService;

	@Override
	public List<UserDTO> getUsers() {
		List<User> list = userDataService.findAll();
		return CopyUtil.copyList(list, UserDTO::new);
	}
}
