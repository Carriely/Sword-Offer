package com.tree;

//输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
//解法：
//递归方式遍历：
//   在树A中找到和树B的根结点值一样的结点R
//   判断树A以R为根结点的子树是否包含与树B一样的结构
//时间复杂度：
//O(n * m)，其中n为root1的节点数，m为root2的节点数
public class SubstructureInTree {

	public boolean HasSubtree(TreeNode root1, TreeNode root2) {
		if (root1 == null || root2 == null) {
			return false;
		}
		//遍历树A所有的左子树和右子树是否含有树B一样的根结点
		return isSame(root1, root2) || HasSubtree(root1.left, root2) || HasSubtree(root1.right, root2);
	}

	public boolean isSame(TreeNode root1, TreeNode root2) {
		//递归结束条件：比较完树B的所有结点
		if (root2 == null) {
			return true;
		}
		// 在root2，root1遍历完成后，仍未找到符合的结构，返回false
		if (root1 == null) {
			return false;
		}
		if (root1.val != root2.val) {
			return false;
		}
		return isSame(root1.left, root2.left) && isSame(root1.right, root2.right);
	}
}
