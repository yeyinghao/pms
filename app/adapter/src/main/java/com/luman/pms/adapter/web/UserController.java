package com.luman.pms.adapter.web;

import cn.dev33.satoken.annotation.SaIgnore;
import com.luman.pms.adapter.enums.UserEnum;
import com.luman.pms.client.api.UserManager;
import com.luman.pms.client.dto.user.UserDTO;
import com.luman.smy.common.helper.ResultHelper;
import com.luman.smy.common.template.WebTemplate;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController {

	private final UserManager userService;

	private final WebTemplate webTemplate;

	@RequestMapping("/getUsers")
	@SaIgnore
	public ResultHelper<List<UserDTO>> getUsers() {
		return webTemplate.execute(UserEnum.GET_USERS, userService::getUsers);
	}

}
