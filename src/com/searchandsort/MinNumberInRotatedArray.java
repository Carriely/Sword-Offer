package com.searchandsort;
//***
//求旋转数组（含有两个递增子数组）的最小数字
//解法：
//利用指针 p,q 指向数组的首尾，如果 array[p] < array[q]，说明数组是递增数组，直接返回 array[p]。否则进行如下讨论。
//计算中间指针 mid：
//如果此时 array[p], array[q], array[mid] 两两相等，此时无法采用二分方式，只能通过遍历区间 [p,q] 获取最小值；
//如果此时 p,q 相邻，说明此时 q 指向的元素是最小值，返回 array[q]；
//如果此时 array[mid] >= array[p]，说明 mid 位于左边的递增数组中，最小值在右边，因此，把 p 指向 mid；
//如果此时 array[mid] <= array[q]，说明 mid 位于右边的递增数组中，最小值在左边，因此，把 q 指向 mid。
//分析：
//第一个指针总是指向前面递增数组的元素，而第二个指针总是指向后面递增数组的元素
//最终第一个指针会指向前面子数组的最后一个元素，而第二个指针会指向后面子数组的第一个元素，也就是他们最终会指向两个相邻的元素。
public class MinNumberInRotatedArray {
	public static int minNumberInRotateArray(int[] array) {
		if (array.length == 0 || array == null) {
			return 0;
		}
		int p = 0;
		int mid = p;
		int q = array.length - 1;
		// 非递增数组
		while (array[p] >= array[q]) {
			if (q - p == 1) {
				mid = q;
				break;
			}
			mid = p + ((q - p) >> 1);
			if (array[p] == array[q] && array[mid] == array[p]) {
				mid = getMinIndex(array, p, q);
				break;
			}
			if (array[mid] >= array[p]) {
				p = mid;
			} else if (array[mid] <= array[q]) {
				q = mid;
			}
		}
		return array[mid];
	}

	// 遍历区间取最小
	public static int getMinIndex(int[] array, int p, int q) {
		int minIndex = p;
		for (int i = p + 1; i <= q; i++) {
			minIndex = array[i] < array[minIndex] ? i : minIndex;
		}
		return minIndex;
	}

	public static void main(String[] args) {
		int[] arr = { 3, 4, 5, 1, 2 };
		System.out.println(minNumberInRotateArray(arr));
	}
}
