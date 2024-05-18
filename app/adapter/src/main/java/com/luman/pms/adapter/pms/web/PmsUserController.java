/*
 * Copyright (c) Ye Yinghao
 * 2022.1 - 2024.1
 */

package com.luman.pms.adapter.pms.web;


import com.luman.pms.adapter.pms.enums.PmsEnum;
import com.luman.pms.client.pms.api.PmsUserManager;
import com.luman.pms.client.pms.model.info.UserDetailInfo;
import com.luman.pms.client.pms.model.info.UserPageInfo;
import com.luman.pms.client.pms.model.req.*;
import com.luman.smy.common.helper.ResultHelper;
import com.luman.smy.common.model.PageRes;
import com.luman.smy.common.template.WebTemplate;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

/**
 * Pms用户控制器
 *
 * @author yeyinghao
 * @date 2024/01/13
 */
@RequestMapping("/api/user")
@RestController
@RequiredArgsConstructor
public class PmsUserController {

	/**
	 * Pms用户Manager
	 */
	private final PmsUserManager pmsUserManager;

	/**
	 * 网页模板
	 */
	private final WebTemplate webTemplate;

	/**
	 * 创建
	 *
	 * @param req 请求
	 * @return {@link ResultHelper}<{@link Boolean}>
	 */
	@PostMapping
	public ResultHelper<Boolean> create(@RequestBody RegisterUserReq req) {
		webTemplate.execute(PmsEnum.USER_CREATE, () -> pmsUserManager.register(req));
		return ResultHelper.success();
	}

	/**
	 * 更新
	 *
	 * @param req 请求
	 * @return {@link ResultHelper}<{@link Boolean}>
	 */
	@PatchMapping
	public ResultHelper<Boolean> update(@RequestBody UpdateUserReq req) {
		webTemplate.execute(PmsEnum.USER_UPDATE, () -> pmsUserManager.update(req));
		return ResultHelper.success();
	}

	/**
	 * 删除
	 *
	 * @param id id
	 * @return {@link ResultHelper}<{@link Boolean}>
	 */
	@DeleteMapping("/{id}")
	public ResultHelper<Boolean> remove(@PathVariable Long id) {
		webTemplate.execute(PmsEnum.USER_REMOVE, () -> pmsUserManager.removeUser(id));
		return ResultHelper.success();
	}

	/**
	 * 细节
	 *
	 * @return {@link ResultHelper}<{@link UserDetailInfo}>
	 */
	@GetMapping("/detail")
	public ResultHelper<UserDetailInfo> detail() {
		return webTemplate.execute(PmsEnum.USER_DETAIL, pmsUserManager::detail);
	}

	/**
	 * 分页查询用户信息
	 *
	 * @param req 请求
	 * @return {@link ResultHelper}<{@link PageRes}<{@link UserPageInfo}>>
	 */
	@PostMapping("/page")
	public ResultHelper<PageRes<UserPageInfo>> page(@RequestBody UserPageReq req) {
		return webTemplate.execute(PmsEnum.USER_PAGE, () -> pmsUserManager.queryPage(req));
	}

	/**
	 * 更新配置文件
	 *
	 * @param req 请求
	 * @return {@link ResultHelper}<{@link Boolean}>
	 */
	@PatchMapping("/profile")
	public ResultHelper<Boolean> updateProfile(@RequestBody UpdateProfileReq req) {
		webTemplate.execute(PmsEnum.USER_UPDATE_PROFILE, () -> pmsUserManager.updateProfile(req));
		return ResultHelper.success();
	}

	/**
	 * 按用户名查找
	 *
	 * @param userName 用户名
	 * @return {@link ResultHelper}<{@link Boolean}>
	 */
	@GetMapping("/{userName}")
	public ResultHelper<Boolean> findByUsername(@PathVariable String userName) {
		webTemplate.execute(PmsEnum.USER_FIND_BY_USERNAME, () -> {
		});
		return ResultHelper.success();
	}

	/**
	 * 获取用户配置文件
	 *
	 * @param id id
	 * @return {@link ResultHelper}<{@link Boolean}>
	 */
	@GetMapping("/profile/{id}")
	public ResultHelper<Boolean> getUserProfile(@PathVariable Long id) {
		webTemplate.execute(PmsEnum.USER_GET_USER_PROFILE, () -> {
		});
		return ResultHelper.success();
	}

	/**
	 * 添加角色
	 *
	 * @param req 请求
	 * @return {@link ResultHelper}<{@link Boolean}>
	 */
	@PostMapping("/roles/add")
	public ResultHelper<Boolean> addRoles(@RequestBody AddUserRolesReq req) {
		webTemplate.execute(PmsEnum.USER_ADD_ROLES, () -> pmsUserManager.addRoles(req));
		return ResultHelper.success();
	}

	/**
	 * 重置密码
	 *
	 * @param req 请求
	 * @return {@link ResultHelper}<{@link Boolean}>
	 */
	@PatchMapping("/password/reset")
	public ResultHelper<Boolean> resetPassword(@RequestBody UpdatePasswordReq req) {
		webTemplate.execute(PmsEnum.USER_RESET_PASSWORD, () -> pmsUserManager.resetPassword(req));
		return ResultHelper.success();
	}

}
