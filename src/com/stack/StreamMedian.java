package com.stack;

import java.util.Comparator;
import java.util.PriorityQueue;

//数据流中的中位数
//解法：
//利用大根堆A存放较小的一半元素，小根堆B存放较大的一半元素。维持大小堆的元素个数差不超过 1。
//A内的元素都比B的小，B内的元素都比B的大。AB都是升序的。
public class StreamMedian {
	private PriorityQueue<Integer> minHeap = new PriorityQueue<>(Comparator.reverseOrder());
	private PriorityQueue<Integer> maxHeap = new PriorityQueue<>();

	public void insert(Integer number) {
		if (maxHeap.isEmpty() || number < maxHeap.peek()) {
			maxHeap.offer(number);
			if (maxHeap.size() - minHeap.size() > 1) {
				minHeap.offer(maxHeap.peek());
			}
		} else {
			minHeap.offer(number);
			if (minHeap.size() - maxHeap.size() > 1) {
				maxHeap.offer(minHeap.peek());
			}
		}
	}

	public Double getMedian() {
		int size1 = minHeap.size();
		int size2 = maxHeap.size();
		if (size1 < size2) {
			return (double) maxHeap.peek();
		}
		if (size1 > size2) {
			return (double) minHeap.peek();
		}
		return (minHeap.peek() + maxHeap.peek()) / 2.0;
	}

}
