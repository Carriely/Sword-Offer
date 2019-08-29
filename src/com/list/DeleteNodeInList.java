package com.list;

//给定单向链表的头指针和一个节点指针，定义一个函数在 O(1) 时间内删除该节点。
//解法：判断要删除的节点是否是尾节点，若是，遍历删除；若不是，把要删除节点的下一个节点赋给要删除的节点即可。
//分析：进行n次操作，平均时间复杂度为：( (n-1) * O(1) + O(n) ) / n = O(1)，所以符合题目上说的O(1)

public class DeleteNodeInList {
	public static ListNode deleteNode(ListNode head, ListNode tobeDelete) {
		if (head == null || tobeDelete == null) {
			return head;
		}
		if (head == tobeDelete) {// 链表中只有一个节点
			head = null;
		} else if (tobeDelete.next != null) {// 删除的不是尾节点
			tobeDelete.val = tobeDelete.next.val;
			tobeDelete.next = tobeDelete.next.next;
		} else {// 删除的是尾节点，需要遍历删除
			ListNode temp = head;
			while (temp.next != tobeDelete) {
				temp = temp.next;
			}
			temp.next = null;
		}
		return head;
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
		ListNode head = deleteNode(node1, node5);
		if (head == null) {
			System.out.println("该链表为空！");
		}
		ListNode tt = head;
		while (tt != null) {
			System.out.println(tt.val);
			tt = tt.next;
		}
	}
}
