package com.tree;

//从上往下打印出二叉树的每个节点，同层节点从左至右打印。
//解法：
//借助一个队列
//先将根节点进入队列。
//队头元素出队，将值存入 list，判断该元素是否有左/右子树，有的话依次进入队列中。队列为空时结束。
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class PrintTreeFromTopToBottom {
	public static ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
		ArrayList<Integer> list = new ArrayList<>();
		if (root == null) {
			return list;
		}
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		while (!queue.isEmpty()) {
			TreeNode node = queue.poll();
			if (node.left != null) {
				queue.offer(node.left);
			}
			if (node.right != null) {
				queue.offer(node.right);
			}
			list.add(node.val);
		}
		return list;
	}
	
	public static void main(String[] args) {
		TreeNode r1 = new TreeNode(1);
		TreeNode r2 = new TreeNode(2);
		TreeNode r3 = new TreeNode(3);
		TreeNode r4 = new TreeNode(4);
		TreeNode r5 = new TreeNode(5);
		TreeNode r6 = new TreeNode(6);

		r1.left = r2;
		r1.right = r3;
		r2.left = r4;
		r2.right = r5;
		r3.right = r6;

		ArrayList<Integer> list = PrintFromTopToBottom(r1);
		for(int i = 0;i<list.size();i++) {
			System.out.println(list.get(i));
		}
	}
}
