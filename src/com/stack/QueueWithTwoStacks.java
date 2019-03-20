package com.stack;
//用两个栈来实现一个队列，完成队列的 Push 和 Pop 操作。 队列中的元素为 int 类型。
//解法：
//Push 操作，每次都存入 stack1； Pop 操作，每次从 stack2 取：
//stack2 栈不为空时，不能将 stack1 元素倒入；
//stack2 栈为空时，需要一次将 stack1 元素全部倒入。

import java.util.Stack;

public class QueueWithTwoStacks {
	Stack<Integer> stack1 = new Stack<Integer>();
	Stack<Integer> stack2 = new Stack<Integer>();
	
	public void push(int node) {
		stack1.push(node);
	}
	public int pop() {
		if(stack2.isEmpty()) {
			if(stack1.isEmpty()) {
				return -1;
			}
			while(!stack1.empty()) {
				stack2.push(stack1.pop());
			}
		}
		return stack2.pop();
	}
}
