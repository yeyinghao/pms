/*
 * Copyright (c) Ye Yinghao
 * 2022.1 - 2024.1
 */

package com.luman.pms.infrastructure.pms.util;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.lang.tree.Tree;
import cn.hutool.core.lang.tree.TreeNode;
import cn.hutool.core.lang.tree.TreeUtil;
import com.luman.pms.domain.pms.model.PmsPermission;
import lombok.experimental.UtilityClass;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 权限相关工具类
 *
 * @author dhb
 */
@UtilityClass
public class PermissionUtil {

    /**
     * 生成权限树
     *
     * @param permissions 权限列表
     * @return 权限树
     */
    public List<Tree<Long>> toTreeNode(List<PmsPermission> permissions, Long parent) {
        List<TreeNode<Long>> nodes = permissions.stream().map(permission -> {
            TreeNode<Long> treeNode = new TreeNode<>();
            treeNode.setId(permission.getId());
            treeNode.setParentId(permission.getParentId());
            treeNode.setWeight(permission.getOrder());
            treeNode.setName(permission.getName());
            treeNode.setExtra(BeanUtil.beanToMap(permission));
            return treeNode;
        }).collect(Collectors.toList());
        return TreeUtil.build(nodes, parent);
    }
}

