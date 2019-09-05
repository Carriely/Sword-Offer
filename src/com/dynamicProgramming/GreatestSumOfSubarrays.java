package com.dynamicProgramming;

//***
//输入一个非空整型数组，数组里的数可能为正，也可能为负。 数组中一个或连续的多个整数组成一个子数组。（注意：是连续的！）
//求所有子数组的和的最大值。要求时间复杂度为O(n)。
public class GreatestSumOfSubarrays {
	// 动态规划
	// res[i] 表示以第 i 个数字结尾的子数组的最大和，那么求出 max(res[i]) 即可：
	// res[i] = array[i], if res[i - 1] < 0
	// res[i] = res[i - 1] + array[i], if res[i - 1] >= 0
	// 解释：
	// 当以第i-1个数字结尾的字数组中所有数字的和小于0时，如果把这个负数与第i个数累加，则得到的结果比第i个数字本身还要小，所以这种情况下最大的子数组的和就是第i个数字本身。
	// 如果以第i-1个数字结尾的子数组中所有数字的和大于0，则与第i个数字累加就得到以第i个数字结尾的子数组中所有数字的和（有可能会是最大的子数组的和）
	public int FindGreatestSumOfSubArray(int[] array) {
		if (array == null && array.length <= 0) {
			return 0;
		}
		// res[i] 表示以第 i 个数字结尾的子数组的最大和
		int[] res = new int[array.length];
		res[0] = array[0];
		int max = res[0];
		for (int i = 1; i < array.length; i++) {
			res[i] = res[i - 1] > 0 ? res[i - 1] + array[i] : array[i];
			max = Math.max(max, res[i]);
		}
		return max;
	}
}
