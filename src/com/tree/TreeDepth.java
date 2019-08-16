package com.tree;

import java.util.LinkedList;

//二叉树的深度
public class TreeDepth {
	/**
	 * 求二叉树的深度（高度） 
	 *  O(n) 
	 * 递归解法：（1）如果二叉树为空，二叉树的深度为0 （2）如果二叉树不为空，二叉树的深度 = max(左子树深度，右子树深度) + 1
	 */
	public static int getDepthRec(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int leftDepth = getDepthRec(root.left);
		int rightDepth = getDepthRec(root.right);
		return Math.max(leftDepth, rightDepth) + 1;
	}

	/**
	 * 求二叉树的深度（高度） 
	 *  O(n) 
	 * 迭代解法：基本思想同LevelOrderTraversal，还是用一个Queue
	 */
	public static int getDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}

		int depth = 0; // 深度
		int currentLevelNodes = 1; // 当前Level，node的数量
		int nextLevelNodes = 0; // 下一层Level，node的数量

		LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);

		while (!queue.isEmpty()) {
			TreeNode cur = queue.remove(); // 从队头位置移除
			currentLevelNodes--; // 减少当前Level node的数量
			if (cur.left != null) { // 如果有左孩子，加到队尾
				queue.add(cur.left);
				nextLevelNodes++; // 并增加下一层Level node的数量
			}
			if (cur.right != null) { // 如果有右孩子，加到队尾
				queue.add(cur.right);
				nextLevelNodes++;
			}
			if (currentLevelNodes == 0) { // 说明已经遍历完当前层的所有节点
				depth++; // 增加高度
				currentLevelNodes = nextLevelNodes; // 初始化下一层的遍历
				nextLevelNodes = 0;
			}
		}
		return depth;
	}
}
