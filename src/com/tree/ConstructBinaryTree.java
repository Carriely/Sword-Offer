package com.tree;

//输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
//分析：
//在二叉树的前序遍历序列中，第一个数字总是根结点的值。
//在中序遍历序列中，根结点的值在序列的中间，左子树的结点位于根结点左侧，而右子树的结点位于根结点值的右侧。
//解法：
//遍历中序序列，找到根结点，递归构建左子树与右子树。
public class ConstructBinaryTree {
	public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
		if (pre == null || in == null || pre.length != in.length) {
			return null;
		}
		int n = pre.length;
		return constructBinaryTree(pre, 0, n - 1, in, 0, n - 1);
	}

	public TreeNode constructBinaryTree(int[] pre, int startPre, int endPre, int[] in, int startIn, int endIn) {
		TreeNode node = new TreeNode(pre[startIn]);
		if (startPre == endPre) {
			if (startIn == endIn) {
				return node;
			}
			throw new IllegalArgumentException("Invalid input!");
		}
		int inOrder = startIn;
		//寻找中序遍历中的根节点
		while (in[inOrder] != pre[startPre]) {
			inOrder++;
			if (inOrder > endIn) {
				throw new IllegalArgumentException("Invalid input!");
			}
		}
		//左子树的长度
		int len = inOrder - startIn;
		if (len > 0) {
			constructBinaryTree(pre, startPre + 1, startPre + len, in, startIn, inOrder - 1);
		}
		if (inOrder < endIn) {
			constructBinaryTree(pre, startPre + len + 1, endPre, in, inOrder + 1, endPre);
		}
		return node;
	}
}
