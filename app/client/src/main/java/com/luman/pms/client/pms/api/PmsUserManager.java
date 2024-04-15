/*
 * Copyright (c) Ye Yinghao
 * 2022.1 - 2024.1
 */

package com.luman.pms.client.pms.api;


import com.luman.pms.client.pms.dto.info.UserDetailInfo;
import com.luman.pms.client.pms.dto.info.UserPageInfo;
import com.luman.pms.client.pms.dto.req.*;
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
     * @return {@link Boolean}
     */
    Boolean register(RegisterUserReq req);

    /**
     * 重置密码
     *
     * @param req 请求
     * @return {@link Boolean}
     */
    Boolean resetPassword(UpdatePasswordReq req);

    /**
     * 添加角色
     *
     * @param req 请求
     * @return {@link Boolean}
     */
    Boolean addRoles(AddUserRolesReq req);

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
     * @return {@link Boolean}
     */
    Boolean updateProfile(UpdateProfileReq req);

    /**
     * @param id id
     * @return {@link Boolean}
     */
    Boolean removeUser(Long id);

    /**
     * @param req 请求
     * @return {@link PageRes}<{@link UserPageInfo}>
     */
    PageRes<UserPageInfo> queryPage(UserPageReq req);

    Boolean update(UpdateUserReq req);
}
