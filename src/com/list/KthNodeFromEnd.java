package com.list;

//输入一个链表，输出该链表中倒数第k个结点。
//简单解法：遍历两次，第一次计算节点个数，第二次从头开始走n-k+1步
//推荐解法：pre 指针走 k-1 步。之后 cur 指针指向 phead，然后两个指针同时走，直至 pre 指针到达尾结点。
//注意特殊情况：比如k 的值小于 1 或者大于链表长度。
public class KthNodeFromEnd {
	public static ListNode FindKthToTail(ListNode head, int k) {
		if (head == null || k < 1) {
			return null;
		}
		ListNode pre = head;
		for (int i = 0; i < k - 1; i++) {
			if (pre.next != null) {
				pre = pre.next;
			}
		}
		// 如果k 的值大于链表长度
		if (pre == null) {
			return null;
		}
		ListNode cur = head;
		while (pre.next != null) {
			cur = cur.next;
			pre = pre.next;
		}
		return cur;
	}

	// 递归
	static int level = 0;

	public static void reGetKthNodeRec(ListNode head, int k) {
		if (head == null) {
			return;
		}
		if (k == 1) {
			return;
		}
		reGetKthNodeRec(head.next, k);
		level++;
		if (level == k) {
			System.out.println(head.val);
		}
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
		ListNode find = FindKthToTail(node1, 3);
		System.err.println(find.val);
	}
}
