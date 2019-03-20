package com.list;

//输入一个链表，按链表值从尾到头的顺序返回一个 ArrayList。
//格式化代码：command+shift+f 
import java.util.ArrayList;
import java.util.Stack;

public class PrintListInReversedOrder {
	// @param listNode 链表头指针
	// 循环鲁棒性比较好
	public static ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
		ArrayList<Integer> res = new ArrayList<Integer>();
		if (listNode == null) {
			return res;
		}
		Stack<Integer> stack = new Stack<Integer>();
		while (listNode != null) {
			stack.push(listNode.val);
			listNode = listNode.next;
		}
		while (!stack.isEmpty()) {
			res.add(stack.pop());
		}
		return res;
	}

	public static void main(String[] args) {
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(4);
		ListNode node5 = new ListNode(5);
		node1.setNext(node2);
		node2.setNext(node3);
		node3.setNext(node4);
		node4.setNext(node5);
		ArrayList<Integer> arrayList = printListFromTailToHead(node1);
		for (int i = 0; i < arrayList.size(); i++) {
			System.out.println(arrayList.get(i));
		}
	}
}
