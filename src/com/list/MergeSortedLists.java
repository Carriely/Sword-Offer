package com.list;

//输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
public class MergeSortedLists {
	// 递归
	// @param list1 链表1
	// @param list2 链表2
	public ListNode Merge(ListNode list1, ListNode list2) {
		if (list1 == null) {
			return list2;
		} else if (list2 == null) {
			return list1;
		}
		if (list1.val < list2.val) {
			list1.next = Merge(list1.next, list2);
			return list1;
		} else {
			list2.next = Merge(list1, list2.next);
			return list2;
		}
	}

	// 非递归
	public ListNode mergeSortedList(ListNode head1, ListNode head2) {
		// 其中一个链表为空的情况，直接返回另一个链表头，O(1)
		if (head1 == null) {
			return head2;
		}
		if (head2 == null) {
			return head1;
		}

		ListNode mergeHead = null;
		// 先确定下来mergeHead是在哪里
		if (head1.val < head2.val) {
			mergeHead = head1;
			head1 = head1.next; // 跳过已经合并了的元素
			mergeHead.next = null; // 断开mergeHead和后面的联系
		} else {
			mergeHead = head2;
			head2 = head2.next;
			mergeHead.next = null;
		}

		ListNode mergeCur = mergeHead;
		while (head1 != null && head2 != null) {
			if (head1.val < head2.val) {
				mergeCur.next = head1; // 把找到较小的元素合并到merge中
				head1 = head1.next; // 跳过已经合并了的元素
				mergeCur = mergeCur.next; // 移动指针到merge尾部
				mergeCur.next = null; // 断开mergeCur和后面的联系
			} else {
				mergeCur.next = head2;
				head2 = head2.next;
				mergeCur = mergeCur.next;
				mergeCur.next = null;
			}
		}

		// 合并剩余的元素
		if (head1 != null) {
			mergeCur.next = head1;
		} else if (head2 != null) {
			mergeCur.next = head2;
		}

		return mergeHead;
	}
}
