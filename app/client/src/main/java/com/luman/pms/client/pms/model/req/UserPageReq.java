/*
 * Copyright (c) Ye Yinghao
 * 2022.1 - 2024.1
 */

package com.luman.pms.client.pms.model.req;

import com.luman.smy.common.model.PageReq;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 用户分页查询
 *
 * @author dhb
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class UserPageReq extends PageReq {

    private String username;

    private Integer gender;

    private Boolean enable;
}
