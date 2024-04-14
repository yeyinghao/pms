package com.luman.pms.app.user.exc.qry;

import com.luman.pms.client.dto.user.UserDTO;
import com.luman.pms.domain.user.gateway.UserGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class UserGetListExc {

	private final UserGateway userGateway;

	public List<UserDTO> getUsers() {
		return userGateway.getUsers();
	}
}
