package com.tree;

//二叉搜索树的后序遍历序列
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
		int val = sequence[end];
		int i = start;
		for (; i < end; i++) {
			if (sequence[i] >= val) {
				break;
			}
		}
		for (int j = i; j < end; j++) {
			if (sequence[j] < val) {
				break;
			}
		}
		return verity(sequence, start, i - 1) & verity(sequence, i, end - 1);
	}
}
