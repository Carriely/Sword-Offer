package com.tree;

//二叉树的深度
public class TreeDepth {
	public int treeDepth(TreeNode node) {
		if (node == null) {
			return 0;
		}
		int lDepth = treeDepth(node.left);
		int rDepth = treeDepth(node.right);
		return 1 + Math.max(lDepth, rDepth);
	}
}
