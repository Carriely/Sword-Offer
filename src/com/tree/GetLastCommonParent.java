package com.tree;

import java.util.ArrayList;
import java.util.Iterator;

public class GetLastCommonParent {
	// 对于普通二叉树
	// 求二叉树中两个节点的最低公共祖先节点 (递归)
	public static TreeNode getLastCommonParentRec(TreeNode root, TreeNode n1, TreeNode n2) {
		if (root == null) {
			return null;
		}
		// 如果有一个match，则说明当前node就是要找的最低公共祖先
		if (root.equals(n1) || root.equals(n2)) {
			return root;
		}

		TreeNode commonInLeft = getLastCommonParentRec(root.left, n1, n2);
		TreeNode commonInRight = getLastCommonParentRec(root.right, n1, n2);
		// 如果一个左子树找到，一个在右子树找到，则说明root是唯一可能的最低公共祖先
		if (commonInLeft != null && commonInRight != null) {
			return root;
		}
		// 其他情况是要不然在左子树要不然在右子树
		if (commonInLeft != null) {
			return commonInLeft;
		}
		return commonInRight;
	}

	/*
	 * *** 
	 * 求二叉树中两个节点的最低公共祖先节点 (非递归)
	 * 先求从根节点到两个节点的路径，然后再比较对应路径的节点就行，最后一个相同的节点也就是他们在二叉树中的最低公共祖先节点
	 */
	public static TreeNode getLastCommonParent(TreeNode root, TreeNode n1, TreeNode n2) {
		if (root == null || n1 == null || n2 == null) {
			return null;
		}

		ArrayList<TreeNode> p1 = new ArrayList<TreeNode>();
		boolean res1 = getNodePath(root, n1, p1);
		ArrayList<TreeNode> p2 = new ArrayList<TreeNode>();
		boolean res2 = getNodePath(root, n2, p2);

		if (!res1 || !res2) {
			return null;
		}

		TreeNode last = null;
		Iterator<TreeNode> iter1 = p1.iterator();
		Iterator<TreeNode> iter2 = p2.iterator();

		while (iter1.hasNext() && iter2.hasNext()) {
			TreeNode tmp1 = iter1.next();
			TreeNode tmp2 = iter2.next();
			if (tmp1 == tmp2) {
				last = tmp1;
			} else { // 直到遇到非公共节点
				break;
			}
		}
		return last;
	}

	// 把从根节点到node路径上所有的点都添加到path中
	private static boolean getNodePath(TreeNode root, TreeNode node, ArrayList<TreeNode> path) {
		if (root == null) {
			return false;
		}
		path.add(root); // 把这个节点加到路径中
		if (root == node) {
			return true;
		}

		boolean found = false;
		found = getNodePath(root.left, node, path); // 先在左子树中找

		if (!found) { // 如果没找到，再在右子树找
			found = getNodePath(root.right, node, path);
		}
		if (!found) { // 如果实在没找到证明这个节点不在路径中，说明刚才添加进去的不是路径上的节点，删掉！
			path.remove(root);
		}
		return found;
	}
}
