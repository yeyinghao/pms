package com.luman.pms.domain.user.gateway;

import com.luman.pms.client.dto.user.UserDTO;

import java.util.List;

public interface UserGateway {
	List<UserDTO> getUsers();
}
