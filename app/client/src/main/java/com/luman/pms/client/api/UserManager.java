package com.luman.pms.client.api;

import com.luman.pms.client.dto.user.UserDTO;

import java.util.List;

public interface UserManager {
	List<UserDTO> getUsers();
}
