package com.math;

//股票的最大利润
//解法：
//遍历每一个数字，并保存之前最小的数字，两者差最大即为最大利润。
public class MaximalProfit {
	public int MaxDiff(int[] arr) {
		if (arr == null || arr.length < 2) {
			return -1;
		}
		int min = arr[0];
		// 最大利润可以是负数，只要亏损最小就行
		int maxDiff = arr[1] - min;
		for (int i = 1; i < arr.length; i++) {
			if (arr[i - 1] < min) { // 保存“之前”最小数字
				min = arr[i - 1];
			}
			if (arr[i] - min > maxDiff) {
				maxDiff = arr[i] - min;
			}
		}
		return maxDiff;
	}

}
