package com.tree;

import java.util.Stack;
//**=
//二叉搜索树与双向链表
//输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。要求不能创建任何新的结点，只能调整树中结点指针的指向。
//解法：
//由于是二叉搜索树，因此中序遍历的结果就是排序的。
//中序遍历利用栈来实现。
//遍历时，前一个结点的 right 指向后一个结点，后一个结点的 left 指向前一个结点。
public class ConvertBinarySearchTree {
	public TreeNode Convert(TreeNode root) {
		if (root == null) {
			return null;
		}
		Stack<TreeNode> stack = new Stack<>();

		TreeNode cur = root;// 后一个节点
		TreeNode pre = null;// 前一个节点
		TreeNode res = null;

		while (cur != null || !stack.isEmpty()) {
			if (cur != null) {
				stack.push(cur);
				cur = cur.left;
			} else {
				cur = stack.pop();
				if (pre == null) {
					pre = cur;
					res = pre;
				} else {
					// 前一个结点的 right 指向后一个结点，后一个结点的 left 指向前一个结点
					pre.right = cur;
					cur.left = pre;
					pre = cur;
				}
				cur = cur.right;
			}
		}
		return res;
	}
}
