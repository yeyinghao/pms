package com.luman.pms.app.task;

import com.luman.pms.client.dto.user.UserDTO;
import com.luman.pms.infrastructure.gateway.user.UserGatewayImpl;
import com.luman.smy.common.util.LoggerUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class TaskService implements com.luman.smy.task.TaskService<UserDTO> {

	private final UserGatewayImpl userGateway;

	@Override
	public List<UserDTO> datas() {
		return userGateway.getUsers();
	}

	@Override
	public void handle(UserDTO userDTO) {
		LoggerUtil.info(log, userDTO);
	}
}
