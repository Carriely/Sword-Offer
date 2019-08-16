package com.tree;
//给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。

//注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针next。
//解法：
//对于结点 pNode：
//如果它有右子树，则右子树的最左结点就是它的下一个结点；
//如果它没有右子树，判断它与父结点 pNode.next 的位置情况：
//   如果它是父结点的左孩子，那么父结点 pNode.next 就是它的下一个结点；
//   如果它是父结点的右孩子，一直向上寻找，直到找到某个结点，它是父结点的左孩子，那么该结点的父结点就是 pNode 的下一个结点。

public class NextNodeInBinaryTrees {
	public TreeLinkNode GetNext(TreeLinkNode pNode) {
		if (pNode == null) {
			return null;
		}
		// 如果有右子树
		if (pNode.right != null) {
			TreeLinkNode treeLinkNode = pNode.right;
			while (treeLinkNode.left != null) {
				treeLinkNode = treeLinkNode.left;
			}
			return treeLinkNode;
		}
		// 如果没有右子树
		// 它是父结点的左孩子
		if (pNode.next != null && pNode.next.left == pNode) {
			return pNode.next;
		}
		// 它是父结点的右孩子
		while (pNode.next != null) {
			if (pNode.next.left == pNode) {
				return pNode.next;
			}
			pNode = pNode.next;
		}
		return null;
	}
}
