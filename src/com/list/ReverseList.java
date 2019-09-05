package com.list;

//***
//输入一个链表，反转链表后，输出新链表的表头。
public class ReverseList {
	// 易于理解的遍历
	public static ListNode reverseList2(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		
		ListNode newHead = null;
		while (head != null) {
			ListNode next = head.next;// 将下一个节点存储起来用作遍历
			head.next = newHead;// 将当前节点的指针指向前一个节点
			newHead = head;// 将反转的list赋给newHead
			head = next;// head指针后移
		}
		return newHead;
	}

	// 解法一：遍历
	// 从头到尾遍历原链表，每遍历一个结点，
	// 将其摘下放在新链表的最前端。
	// 注意链表为空和只有一个结点的情况。时间复杂度为O（n）
	public static ListNode reverseList(ListNode head) {
		// 如果链表为空或只有一个节点，无需反转，直接返回原链表表头
		if (head == null || head.next == null) {
			return head;
		}

		ListNode reHead = null; // 反转后新链表头指针
		ListNode cur = head;

		while (cur != null) {// 当前节点不为空
			ListNode preCur = cur; // 用preCur保存住对要处理节点的引用
			cur = cur.next; // cur更新到下一个节点
			preCur.next = reHead; // 更新要处理节点的next引用
			reHead = preCur; // reHead指向要处理节点的前一个节点
		}

		return reHead;
	}

	// 解法二：递归
	public static ListNode reverseListRec(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode reHead = reverseListRec(head.next);
		head.next.next = head; // 把head接在reHead串的最后一个后面
		head.next = null; // 防止循环链表
		return reHead;
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
//		ListNode newhead = reverseList(node1);
		ListNode newhead = reverseListRec(node1);
		ListNode temp = newhead;
		while (temp != null) {
			System.out.println(temp.val);
			temp = temp.next;
		}
	}
}
