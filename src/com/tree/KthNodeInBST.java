package com.tree;

//二叉搜索树的第k个结点
//中序遍历即可，时间复杂度为O(logn)
public class KthNodeInBST {
	// 设置一个全局计数器即可在中序遍历的过程中直接获取值
	private int count = 0;

	public TreeNode KthNode(TreeNode root, int k) {
		if (root == null || k == 0) {
			return null;
		}
		// 左递归
		TreeNode p = KthNode(root.left, k);
		if (p != null) {
			return p;
		}
		count++;
		if (count == k) {
			return root;
		}
		// 右递归
		TreeNode q = KthNode(root.right, k);
		if (q != null) {
			return q;
		}
		return null;
	}                               

}
