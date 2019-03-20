package com.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

//从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行。
//解法:
//需要两个变量，一个记录当前层中还没有打印的节点数，另一个变量表示下一层的节点数。
public class PrintTreesInLines {
	public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
		ArrayList<ArrayList<Integer>> list = new ArrayList<>();
		if (pRoot == null) {
			return list;
		}
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(pRoot);
		int cnt = 1;
		while (cnt > 0) {
			ArrayList<Integer> res = new ArrayList<>();
			// 当前层节点数
			int num = cnt;
			// 下一层节点数
			cnt = 0;
			for (int i = 0; i < num; i++) {
				TreeNode node = queue.poll();
				if (node.left != null) {
					queue.offer(node.left);
					cnt++;
				}
				if (node.right != null) {
					queue.offer(node.right);
					cnt++;
				}
				res.add(node.val);
			}
			list.add(res);
		}
		return list;
	}
}
