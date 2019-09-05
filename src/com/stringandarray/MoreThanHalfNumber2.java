package com.stringandarray;

//**
//数组中出现次数超过一半的数字
public class MoreThanHalfNumber2 {
//	解法二：
//	利用多数投票算法，从头到尾遍历数组，遇到两个不一样的数就把这两个数同时除去。
//	除去的两个数可能都不是 majority，也可能一个是 majority 另一个不是，但是因为 majority 总数大于一半，所以这么删完最后剩下的肯定是 majority。
//	此方法时间复杂度为 O(n)，且不会改变数组。
	private static int MoreThanHalfNum(int[] array) {
		if (array == null | array.length == 0) {
			return 0;
		}
		int res = array[0];
		// 计算次数
		int times = 1;
		for (int i = 1; i < array.length; i++) {
			if (times == 0) {
				res = array[i];
				// 重新计数
				times = 1;
			} else if (res == array[i]) {
				times++;
			} else {// 遇到两个不一样的数就把这两个数同时除去
				times--;
			}
		}
		// 如果找到超过数组元素个数一半的数字就返回该数字，否则返回0
		return isMoreThanHalf(array, res) ? res : 0;
	}

	// 判断val元素是否真的超过数组元素个数的一半（检验输入的数组是否有效）
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
		int[] array = new int[]{1,2,3,2,2,2,5,4,2};
		System.err.println(MoreThanHalfNum(array));
	}
}
