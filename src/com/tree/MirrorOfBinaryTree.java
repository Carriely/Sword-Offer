package com.tree;

import java.util.Stack;

//二叉树的镜像
public class MirrorOfBinaryTree {
	// 1. 破坏原来的树，把原来的树改成其镜像
	// 将根结点的左右孩子互换，之后递归左右孩子。
	public TreeNode mirrorRec(TreeNode root) {
		if (root == null || !hasChild(root)) {
			return null;
		}
		TreeNode node = root.left;
		root.left = root.right;
		root.right = node;
		mirrorRec(root.left);
		mirrorRec(root.right);
		return root;
	}

	public boolean hasChild(TreeNode root) {
		return root.left != null || root.right != null;
	}

	// 2. 不破坏原来的树，返回一个新的镜像树
	public static TreeNode mirrorCopyRec(TreeNode root) {
		if (root == null) {
			return null;
		}

		TreeNode newNode = new TreeNode(root.val);
		newNode.left = mirrorCopyRec(root.right);
		newNode.right = mirrorCopyRec(root.left);

		return newNode;
	}

	// 非递归
	// 1. 破坏原来的树，把原来的树改成其镜像
	public static void mirror(TreeNode root) {
		if (root == null) {
			return;
		}

		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(root);
		
		while (!stack.isEmpty()) {
			TreeNode cur = stack.pop();
			// 交换左右孩子
			TreeNode temp = cur.right;
			cur.right = cur.left;
			cur.left = temp;
			if (cur.right != null) {
				stack.push(cur.right);
			}
			if (cur.left != null) {
				stack.push(cur.left);
			}
		}
	}

	// 2. 不破坏原来的树，返回一个新的镜像树
	public static TreeNode mirrorCopy(TreeNode root) {
		if (root == null) {
			return null;
		}

		Stack<TreeNode> stack = new Stack<TreeNode>();
		Stack<TreeNode> newStack = new Stack<TreeNode>();
		stack.push(root);
		TreeNode newRoot = new TreeNode(root.val);
		newStack.push(newRoot);

		while (!stack.isEmpty()) {
			TreeNode cur = stack.pop();
			TreeNode newCur = newStack.pop();
			if (cur.right != null) {
				stack.push(cur.right);
				newCur.left = new TreeNode(cur.right.val);
				newStack.push(newCur.left);
			}
			if (cur.left != null) {
				stack.push(cur.left);
				newCur.right = new TreeNode(cur.left.val);
				newStack.push(newCur.right);
			}
		}
		return newRoot;
	}
}
