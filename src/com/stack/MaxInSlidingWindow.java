package com.stack;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

//***
//滑动窗口的最大值
//给定一个数组和滑动窗口的大小，请找出所有滑动窗口里的最大值。
//注意：数据保证 k 大于 0，且 k 小于等于数组长度。
//解法：
//使用一个双端队列，保证队首存放的是窗口最大值的下标。遍历数组，
//   队尾元素比要入队的元素小，则把其移除（因为不可能成为窗口最大值）。
//   队首下标对应的元素不在窗口内（即窗口最大值），将其从队列中移除。
//	 把每次滑动值的下标加入队列中（经过步骤1、2，此时加入队列的下标要么是当前窗口最大值的下标，要么是小于窗口最大值的下标）。
//	 滑动窗口的首地址i大于size就写入窗口最大值。
public class MaxInSlidingWindow {
	public ArrayList<Integer> maxInWindows(int[] nums, int size) {
		ArrayList<Integer> result = new ArrayList<>();
		if (nums == null || size > nums.length || size < 0) {
			return result;
		}
		Deque<Integer> deque = new LinkedList<>();
		for (int i = 0; i < nums.length; i++) {
			// 队首下标对应的元素不在窗口内（即窗口最大值），将其从队列中移除
			if (!deque.isEmpty() && (i - deque.getFirst()) + 1 > size) {// ???
				deque.pollFirst();
			}
			// 队尾元素比要入队的元素小，则把其移除（因为不可能成为窗口最大值）
			while (!deque.isEmpty() && nums[i] >= nums[deque.getLast()]) {// 注意是大于等于！
				deque.pollLast();
			}
			// 把每次滑动的值加入到队列中
			deque.offer(i);
			// 滑动窗口的首地址i大于size就写入窗口最大值
			if (!deque.isEmpty() && i + 1 >= size) {
				result.add(nums[deque.getFirst()]);
			}
		}
		return result;
	}
}
