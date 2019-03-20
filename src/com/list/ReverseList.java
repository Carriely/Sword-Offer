package com.list;
//***
//输入一个链表，反转链表后，输出新链表的表头。
public class ReverseList {
	// 解法一：头插法
	public static ListNode reverse(ListNode head) {
		ListNode pre = head;
		ListNode cur = head.next;
		ListNode temp;
		while (cur != null) {// 当前节点不为空
			temp = cur.next;
			cur.next = pre;
			pre = cur;
			cur = temp;
		}
		head.next = null;// 必须置头节点的下一个节点为空
		return pre;
	}

	// 解法二：递归
//	public static ListNode reverse1() {
//
//	}

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
		ListNode newhead = reverse(null);
		ListNode temp = newhead;
		while (temp != null) {
			System.out.println(temp.val);
			temp = temp.next;
		}
	}
}
