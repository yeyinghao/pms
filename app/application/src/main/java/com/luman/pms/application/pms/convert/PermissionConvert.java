package com.luman.pms.application.pms.convert;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.lang.tree.Tree;
import cn.hutool.core.lang.tree.TreeNode;
import cn.hutool.core.lang.tree.TreeUtil;
import com.luman.pms.domain.pms.model.PmsPermission;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PermissionConvert {

	/**
	 * 生成权限树
	 *
	 * @param permissions 权限列表
	 * @return 权限树
	 */
	public static List<Tree<Long>> buildTreeNode(List<PmsPermission> permissions, Long parent) {
		List<TreeNode<Long>> nodes = permissions.stream().map(permission -> {
			TreeNode<Long> treeNode = new TreeNode<>();
			treeNode.setId(permission.getBizId());
			treeNode.setParentId(permission.getParentId());
			treeNode.setWeight(permission.getOrder());
			treeNode.setName(permission.getName());
			Map<String, Object> stringObjectMap = BeanUtil.beanToMap(permission);
			stringObjectMap.remove("id");
			treeNode.setExtra(stringObjectMap);
			return treeNode;
		}).collect(Collectors.toList());
		return TreeUtil.build(nodes, parent);
	}

}
