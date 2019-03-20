package com.stringandarray;
//输入 n 个整数，找出其中最小的 K 个数。

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class KLeastNumbers {

	// 解法一：
	// 利用快排中的 partition 思想。
	// 判断选中数字的下标 index：
	// 如果 index = k-1，结束循环，返回前 k 个数。
	// 如果 index > k-1，那么接着在 index 的左边进行 partition。
	// 如果 index < k-1，则在 index 的右边继续进行 partition。
	// 注意：这种方法会修改输入的数组。时间复杂度为 O(n)。
	public ArrayList<Integer> GetLeastNumbers_1(int[] input, int k) {
		ArrayList<Integer> res = new ArrayList<Integer>();
		if (input == null || input.length == 0 || input.length < k || k < 0) {
			return res;
		}
		return res;
	}

	public static int partition(int[] input, int start, int end) {
		int index = 0;
		return index;

	}

	public static void swap(int[] input, int i, int j) {
		int t = input[i];
		input[i] = input[j];
		input[j] = t;
	}

	// 解法二：
	// 利用最大堆，存储最小的 k 个数，最后返回即可。
	// 此方法时间复杂度为 O(nlogk)。虽然慢一点，但是它不会改变输入的数组，并且它适合海量数据的输入。
	public static ArrayList<Integer> GetLeastNumbers_2(int[] input, int k) {
		ArrayList<Integer> res = new ArrayList<Integer>();
		if (input == null || input.length == 0 || input.length < k || k < 0) {
			return res;
		}
		// 优先队列（最大堆）
		PriorityQueue<Integer> maxHeap = new PriorityQueue<>(k, Comparator.reverseOrder());
		System.out.println("堆的大小：" + maxHeap.size());
		for (int i : input) {
			if (maxHeap.size() < k) {
				maxHeap.add(i);
			} else {
				if (maxHeap.peek() > i) {
					maxHeap.poll();
					maxHeap.add(i);
				}
			}
		}
		res.addAll(maxHeap);
		return res;
	}
	
	public static void main(String[] args) {
		int[] array = { 3, 7, 4, 8, 23, 56, 77, 89, 46, 11, 66, 77 };
		ArrayList<Integer> res = GetLeastNumbers_2(array, 4);
		for (int a : res) {
			System.out.println(" " + a);
		}
	}
}
