package com.stack;
//用两个队列来实现一个栈，完成栈的 Push 和 Pop 操作。 栈中的元素为 int 类型。

//解法：
//Push 操作，每次都存入 queue1； Pop 操作，每次从 queue1 取：
//将 queue1 中的元素依次倒入 queue2，直到 queue1 剩下一个元素，这个元素就是要 pop 出去的；
//将 queue1 与 queue2 进行交换，这样保证每次都从 queue1 中存取元素，queue2 只起到辅助暂存的作用。

import java.util.LinkedList;
import java.util.Queue;

public class StackWithTwoQueues {
	private Queue<Integer> queue1 = new LinkedList<>();
	private Queue<Integer> queue2 = new LinkedList<>();

	public void push(int node) {
		queue1.offer(node);
	}

	public int pop() {
		if (queue1.isEmpty()) {
			throw new RuntimeException("empty stack!");
		}
		while (queue1.size() > 1) {
			queue2.offer(queue1.poll());
		}
		int popNode = queue1.poll();
		// 交换queue1与queue2
		Queue<Integer> temp = new LinkedList<>();
		temp = queue1;
		queue1 = queue2;
		queue2 = temp;
		return popNode;
	}
}
