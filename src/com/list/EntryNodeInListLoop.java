package com.list;

//给一个链表，若其中包含环，请找出该链表的环的入口结点，否则，输出null
//解法：
//先利用快慢指针。若能相遇，说明存在环，且相遇点一定是在环上；若没有相遇，说明不存在环，返回 null。
//固定当前相遇点，用一个指针继续走，同时累积结点数。计算出环的结点个数 count。
//指针 p1 先走 count 步，p2 指向链表头部，之后 p1,p2 同时走，相遇时，相遇点一定是在环的入口处。因为 p1 比 p2 多走了环的一圈。
public class EntryNodeInListLoop {
	public ListNode entryNodeOfLoop(ListNode pHead) {
		if (pHead == null || pHead.next == null) {
			return null;
		}
		boolean flag = false;
		ListNode slow = pHead;
		ListNode fast = pHead;
		// 判断是否有环
		while (slow != null && slow.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast) {
				flag = true;
				break;
			}
		}
		// 无环
		if (!flag) {
			return null;
		}
		// 计算环中节点个数
		ListNode node = slow.next;
		int count = 1;
		while (node != slow) {
			node = node.next;
			count++;
		}
		// p1指针先走count步
		ListNode p1 = pHead;
		ListNode p2 = pHead;
		for (int i = 0; i < count; i++) {
			p1 = p1.next;
		}
		while (p1 != p2) {
			p1 = p1.next;
			p2 = p2.next;
		}
		return p1;
	}
}
