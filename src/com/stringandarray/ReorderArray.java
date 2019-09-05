package com.stringandarray;

import java.util.Arrays;

//调整数组顺序使奇数位于偶数前面

public class ReorderArray {
	// 解法一：维护两个指针，分别指向数组第一个数字和最后一个数字，如果第一个指针指向偶数，同时第二个指针指向奇数，则交换这两个数字
	public static void mysort(int[] array) {
		if (array == null || array.length < 2) {
			return;
		}
		int left = 0;
		int right = array.length - 1;
		while (left < right) {
			while (!isEven(array[left])) {
				left++;
			}
			while (isEven(array[right])) {
				right--;
			}
			int temp = array[right];
			array[right] = array[left];
			array[left] = temp;
			
			if (left >= right) {
				break;
			}
		}
	}

	public static boolean isEven(int i) {
		if (i % 2 == 0) {
			return true;
		} else {
			return false;
		}
	}

	// 解法二：统计数组中奇数的个数，借助一个同样大小的一个数组空间（可以保证奇数和奇数，偶数和偶数之间的相对位置不变）
	public static void reOrderArray(int[] array) {
		if (array == null && array.length < 2) {
			return;
		}
		int numsOfOdd = 0;
		for (int i : array) {
			if (i % 2 != 0) {
				numsOfOdd++;
			}
		}
		int i = 0;
		int j = numsOfOdd;
		int[] copyArray = Arrays.copyOf(array, array.length);
		for (int val : copyArray) {
			if (val % 2 != 0) {
				array[i++] = val;
			} else {
				array[j++] = val;
			}
		}
	}

	public static void main(String[] args) {
		int[] array = { 3, 7, 4, 8, 23, 56, 77, 89, 46, 11, 66, 77 };
		mysort(array);
		//reOrderArray(array);
		for (int a : array) {
			System.out.println(" " + a);
		}
	}
}
