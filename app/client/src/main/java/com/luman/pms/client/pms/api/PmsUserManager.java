/*
 * Copyright (c) Ye Yinghao
 * 2022.1 - 2024.1
 */

package com.luman.pms.client.pms.api;


import com.luman.pms.client.pms.model.info.UserDetailInfo;
import com.luman.pms.client.pms.model.info.UserPageInfo;
import com.luman.pms.client.pms.model.req.*;
import com.luman.smy.common.model.PageRes;

/**
 * Pms用户Manager
 *
 * @author yeyinghao
 * @date 2024/01/12
 */
public interface PmsUserManager {

    /**
     * 注册
     *
     * @param req 请求
     */
    void register(RegisterUserReq req);

    /**
     * 重置密码
     *
     * @param req 请求
     */
    void resetPassword(UpdatePasswordReq req);

    /**
     * 添加角色
     *
     * @param req 请求
     */
    void addRoles(AddUserRolesReq req);

    /**
     * 细节
     *
     * @return {@link UserDetailInfo}
     */
    UserDetailInfo detail();

    /**
     * 更新配置文件
     *
     * @param req 请求
     */
    void updateProfile(UpdateProfileReq req);

    /**
     * @param id id
     */
    void removeUser(Long id);

    /**
     * @param req 请求
     * @return {@link PageRes}<{@link UserPageInfo}>
     */
    PageRes<UserPageInfo> queryPage(UserPageReq req);

    void update(UpdateUserReq req);
}
