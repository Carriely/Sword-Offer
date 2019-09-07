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
		if (startPre > endPre) {
			return null;
		}
		// 创建当前的根节点
		TreeNode node = new TreeNode(pre[startPre]);
		// 只有一个节点
		if (startPre == endPre && startIn == endIn) {
			return node;
		}
		int index = -1;
		// 寻找中序遍历中根节点的位置
		for (int i = startIn; i <= endIn; i++) {
			if (in[i] == pre[startPre]) {
				index = i;
				break;
			}
		}
		// 左子树的长度
		int leftLength = index - startIn;
		// 构建左子树
		node.left = constructBinaryTree(pre, startPre + 1, startPre + leftLength, in, startIn, index - 1);
		// 构建右子树
		node.right = constructBinaryTree(pre, startPre + leftLength + 1, endPre, in, index + 1, endIn);
		return node;
	}
}
