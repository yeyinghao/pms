package com.luman.pms.client.api;

import com.luman.pms.client.dto.user.UserDTO;
import com.luman.smy.common.helper.ResultHelper;

import java.util.List;

public interface UserManager {
	ResultHelper<List<UserDTO>> getUsers();
}
