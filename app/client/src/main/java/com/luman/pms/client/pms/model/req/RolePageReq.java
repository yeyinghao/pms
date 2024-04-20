/*
 * Copyright (c) Ye Yinghao
 * 2022.1 - 2024.1
 */

package com.luman.pms.client.pms.model.req;

import com.luman.smy.common.model.PageReq;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 分页
 *
 * @author yeyinghao
 * @date 2024/04/20
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class RolePageReq extends PageReq {

    /**
     * 名称
     */
    private String name;

    /**
     * 启用
     */
    private Boolean enable;

}
