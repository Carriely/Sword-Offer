package com.tree;

//二叉树的镜像
//解法：
//将根结点的左右孩子互换，之后递归左右孩子。
public class MirrorOfBinaryTree {
	public void Mirror(TreeNode root) {
		if (root == null || !hasChild(root)) {
			return;
		}
		TreeNode node = root.left;
		root.left = root.right;
		root.right = node;
		Mirror(root.left);
		Mirror(root.right);
	}

	public boolean hasChild(TreeNode root) {
		return root.left != null || root.right != null;
	}
}
