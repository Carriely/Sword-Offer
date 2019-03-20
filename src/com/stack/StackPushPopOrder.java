package com.stack;

import java.util.Stack;

//输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否可能为该栈的弹出顺序。假设压入栈的所有数字均不相等。（注意：这两个序列的长度是相等的）

//解法：
//建立辅助栈，
//判断下一个要弹出的元素：
//如果刚好是栈顶元素，直接弹出。
//如果不在辅助栈顶，则把压栈序列中还没有入栈的数字压入辅助栈，直到待弹出的数字压入栈顶。
//如果所有数字都压入辅助栈，依然没有在辅助栈顶找到下一个弹出的数字，则不可能是弹出序列。

public class StackPushPopOrder {
	public boolean IsPopOrder(int[] pushA, int[] popA) {
		if (pushA == null || popA == null || pushA.length != popA.length) {
			return false;
		}

		Stack<Integer> stack = new Stack<>();
		int i = 0;
		// 判断循环终止的布尔值
		boolean flag = false;
		for (int val : popA) {
			// 不在栈顶
			while (stack.isEmpty() || stack.peek() != val) {
				if (i >= popA.length) {
					flag = true;
					break;
				}
				stack.push(pushA[i++]);
			}
			if (flag) {
				break;
			}
			// 栈顶元素，直接弹出
			stack.pop();
		}
		return stack.isEmpty();
	}
}
