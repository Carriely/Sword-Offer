package com.list;

// 输入两个链表，找出它们的第一个公共结点。
// 分析：两个有公共节点且部分重合的单链表，拓扑形状看起来像一个Y，而不可能是X
public class FirstCommonNodesInLists {
	// 方法一：蛮力法，时间复杂度O（mn）
	// 方法二：借助两个辅助栈，时间复杂度O（m+n），空间复杂度O（m+n）
	// 方法三
	public static ListNode findFirstCommonNode(ListNode head1, ListNode head2) {
		if (head1 == null || head2 == null) {
			return null;
		}
		int n1 = len(head1);
		int n2 = len(head2);
		ListNode p1 = head1;
		ListNode p2 = head2;
		if (n1 < n2) {
			for (int i = 0; i < n2 - n1; i++) {
				p2 = p2.next;
			}
		} else {
			for (int i = 0; i < n1 - n2; i++) {
				p1 = p1.next;
			}
		}
		while (p1 != p2 && p1 != null && p2 != null) {
			p1 = p1.next;
			p2 = p2.next;
		}
		return (p1 == null || p2 == null) ? null : p1;
	}

	private static int len(ListNode head) {
		int count = 0;
		ListNode node = head;
		while (node.next != null) {
			count++;
			node = node.next;
		}
		return count;
	}
}
