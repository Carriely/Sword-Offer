package com.stringandarray;

//查找数组中的重复数字
//解法一：先排序，遍历判断是否有重复数字，时间复杂度为O（nlogn）
//解法二：利用一个空间复杂度为O（n）哈希表，遍历数组判断哈希表是否已经包含该数字，时间复杂度为O（n）
//***
//解法三：同时进行比较和交换，排序的过程即为寻找重复数字的过程，目标是使第i个位置上的数字为i
//从头到尾遍历数组，当扫描到下标 i 的数字 nums[i]：
//	如果等于 i，继续向下扫描；
//	如果不等于 i，拿它与第 nums[i] 个数进行比较，
//		如果相等，说明有重复值，返回 nums[i]。
//		如果不相等，就把第 i 个数 和第 nums[i] 个数交换。重复这个比较交换的过程。
//此算法时间复杂度为 O(n)，因为每个元素最多只要两次交换，就能确定位置。空间复杂度为 O(1)。
public class DuplicationInArray {
	public static int duplicate(int[] array) {
		if (array == null && array.length < 1) {
			return -1;
		}
		// 判断输入数组的合法性
		for (int i = 0; i < array.length; i++) {
			if (array[i] < 0 || array[i] > array.length - 1) {
				return -1;
			}
		}
		for (int i = 0; i < array.length; i++) {
			while (i != array[i]) {// m=array[i]
				// 数字重复
				if (array[i] == array[array[i]]) {
					return array[i];
				}
				// 将数字与第m个位置上的数字交换
				swap(array, i, array[i]);
			}
		}
		return -1;
	}

	private static void swap(int[] array, int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
}
