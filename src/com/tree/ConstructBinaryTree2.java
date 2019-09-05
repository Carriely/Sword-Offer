package com.tree;

import java.util.HashMap;

//输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
public class ConstructBinaryTree2 {
	// 从前序遍历的第一个节点开始
	int pre_idx = 0;
	int[] preorder;
	int[] inorder;
	// 用一个hashmap存放树节点
	HashMap<Integer, Integer> idx_map = new HashMap<Integer, Integer>();

	private TreeNode helper(int in_left, int in_right) {
		if (in_left == in_right)
			return null;

		// 前序遍历的pre_idx为根节点
		int root_val = preorder[pre_idx];
		TreeNode root = new TreeNode(root_val);

		// 根节点将中序遍历切分成左子树和右子树
		int index = idx_map.get(root_val);

		// 递归
		pre_idx++;
		// 构建左子树
		root.left = helper(in_left, index);
		// 构建右子树
		root.right = helper(index + 1, in_right);
		return root;
	}

	public TreeNode buildTree(int[] preorder, int[] inorder) {
		this.preorder = preorder;
		this.inorder = inorder;

		int idx = 0;
		for (Integer val : inorder)
			idx_map.put(val, idx++);
		return helper(0, inorder.length);
	}
}
