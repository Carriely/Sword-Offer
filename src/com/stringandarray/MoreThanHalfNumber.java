package com.stringandarray;
//**
//数组中出现次数超过一半的数字
public class MoreThanHalfNumber {
//	解法一：
//	利用快排中的 partition 思想。
//	数组中有一个数字出现次数超过了数组长度的一半，那么排序后，数组中间的数字一定就是我们要找的数字。
//	判断选中数字的下标 index：
//	   如果 index = n/2，那么这个数字就是中位数。
//	   如果 index > n/2，那么接着在 index 的左边进行 partition。
//	   如果 index < n/2，则在 index 的右边继续进行 partition。
//	这种方法会修改输入的数组。时间复杂度为 O(n)。
	private static int MoreThanHalfNum(int[] array) {
		if (array == null | array.length == 0) {
			return 0;
		}
		int n = array.length - 1;
		int start = 0;
		int end = n;
		// 要找到排序后的数组中间的数字
		int mid = n >> 1;// 移位操作，相当于除以2
		// 先随机选取一个数字
		int index = partition(array, start, end);
		while (index != mid) {
			if (index > mid) {
				end = index - 1;
			} else {
				start = index + 1;
			}
			index = partition(array, start, end);
		}
		return isMoreThanHalf(array, array[index]) ? array[index] : 0;
	}

	// ???
	// 快排中的 partition 方法
	private static int partition(int[] array, int start, int end) {
		int small = start - 1;
		for (int i = start; i < end; ++i) {
			if (array[i] < array[end]) {
				swap(array, i, ++small);
			}
		}
		++small;
		swap(array, small, end);
		return small;
	}

	public static void swap(int[] array, int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}

	// 判断val元素是否真的超过数组元素个数的一半
	public static boolean isMoreThanHalf(int[] array, int val) {
		int count = 0;
		for (int i : array) {
			if (i == val) {
				count++;
			}
		}
		return (count * 2) > array.length;
	}

	public static void main(String[] args) {
		int[] array = new int[] { 1, 2, 3, 2, 2, 2, 5, 4, 2 };
		System.err.println(MoreThanHalfNum(array));
	}

}
