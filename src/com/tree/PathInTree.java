package com.tree;

import java.util.ArrayList;

//二叉树中和为某一值的路径
public class PathInTree {
	// 解法一
	private ArrayList<ArrayList<Integer>> res = new ArrayList<>();

	public ArrayList<ArrayList<Integer>> findPath(TreeNode root, int target) {
		findPath(root, target, new ArrayList<>());
		return res;
	}

	private void findPath(TreeNode root, int target, ArrayList<Integer> list) {
		if (root == null) {
			return;
		}
		list.add(root.val);
		target = target - root.val;
		//满足条件，即加入res
		if (target == 0 && root.left == null && root.right == null) {//叶节点
			res.add(new ArrayList<>(list));
		} else {
			findPath(root.left, target, list);
			findPath(root.right, target, list);
		}
		//遍历完所有子节点依然不满足条件，将这条list路径删除
		list.remove(list.size() - 1);
	}
}
