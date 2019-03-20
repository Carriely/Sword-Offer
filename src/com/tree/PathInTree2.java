package com.tree;
//二叉树中和为某一值的路径

import java.util.ArrayList;
import java.util.Stack;

public class PathInTree2 {
	// 解法二：使用前序遍历，通过栈保存路径
	public ArrayList<ArrayList<Integer>> findPath(TreeNode root, int target) {
		ArrayList<ArrayList<Integer>> pathList = new ArrayList<>();
		if (root == null) {
			return null;
		}
		// 定义栈存储一条路径
		Stack<Integer> path = new Stack<Integer>();
		findPath(root, target, path, pathList);
		return pathList;
	}

	public void findPath(TreeNode root, int target, Stack<Integer> path, ArrayList<ArrayList<Integer>> pathList) {
		if (root == null) {
			return;
		}
		// 判断root是否是叶子节点
		if (root.left == null && root.right == null) {
			// 如果等于期望值，则添加到list集合中
			if (root.val == target) {
				ArrayList<Integer> list = new ArrayList<>();
				for (int value : path) {
					list.add(value);
				}
				// 将根节点值添加入集合
				list.add(root.val);
				pathList.add(list);
			}
		} else {
			// 不是叶子结点，前序遍历，将当前结点值放入path栈中
			path.push(root.val);
			findPath(root.left, target - root.val, path, pathList);
			findPath(root.right, target - root.val, path, pathList);
			// 在返回到父结点之前，在路径上删除当前结点的值
			path.pop();
		}
	}
}
