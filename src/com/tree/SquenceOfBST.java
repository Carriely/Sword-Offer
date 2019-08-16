package com.tree;

//判断整数数组是不是某二叉搜索树的后序遍历序列
//解法：
//序列的最后一个元素是二叉搜索树的根节点。
//在序列中从左到右找到根节点的左子树(比根节点小)、右子树(比根节点大)。
//如果右子树中出现比根节点小的元素，那么为 false。
//否则递归左右子树。
public class SquenceOfBST {
	public boolean VerifySquenceOfBST(int[] sequence) {
		if (sequence == null || sequence.length < 1) {
			return false;
		}
		return verity(sequence, 0, sequence.length - 1);
	}

	public boolean verity(int[] sequence, int start, int end) {
		if (start >= end) {
			return true;
		}
		//根节点
		int root = sequence[end];
		int i = start;
		for (; i < end; i++) {
			if (sequence[i] >= root) {//找到左子树和右子树的分割点
				break;
			}
		}
		//检查右子树的节点
		for (int j = i; j < end; j++) {
			if (sequence[j] < root) {
				return false;
			}
		}
		//递归判断左子树和右子树
		return verity(sequence, start, i - 1) && verity(sequence, i, end - 1);//后序遍历：左子树，右子树，根节点
	}
}
