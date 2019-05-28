package com.math;

import java.util.ArrayList;

//丑数
//把只包含质因子2、3和5的数称作丑数（Ugly Number）。求按从小到大的顺序的第N个丑数。
public class UglyNumber {
	// 解法一：暴力破解
	public static boolean isUgly(int number) {
		while (number % 2 == 0) {
			number /= 2;
		}
		while (number % 3 == 0) {
			number /= 3;
		}
		while (number % 5 == 0) {
			number /= 5;
		}
		return number == 1;
	}

	public static int GetUglyNumber_Solution(int index) {
		if (index <= 0) {
			return 0;
		}
		int number = 0;
		int count = 0;
		while (count < index) {
			number++;
			if (isUgly(number)) {
				// System.out.println(number);
				count++;
			}
		}
		return number;
	}

	// 解法二
	// 由于新丑数必定是旧丑数乘以因子2、3或者5得来的，所以可以使用一个list来存储已经出现的丑数以此来计算出新的丑数，从而避免对非丑数的计算。
	// 通过维护3个指针i2，i3，i5和它们对应的值m2，m3，m5，每次向list中添加的为m2，m3，m5中的最小值，以此来维护list的有序性。
	// 用空间换时间：时间复杂度O（n），空间复杂度O（n）
	public static int GetUglyNumber(int index) {
		if (index <= 0) {
			return 0;
		}
		ArrayList<Integer> result = new ArrayList<>();
		// 第一个丑数为1
		result.add(1);
		int i2 = 0, i3 = 0, i5 = 0;
		while (result.size() < index) {
			int m2 = result.get(i2) * 2;
			int m3 = result.get(i3) * 3;
			int m5 = result.get(i5) * 5;

			// 求出m2、m3、m5中的最小值，该值为加入list的丑数
			int min = Math.min(m2, Math.min(m3, m5));
			if (min == m2) {
				i2++;
			}
			if (min == m3) {
				i3++;
			}
			if (min == m5) {
				i5++;
			}
			// System.out.println(min);
			result.add(min);
		}
		return result.get(result.size() - 1);
	}

	public static void main(String[] args) {
		System.out.println("res1:" + GetUglyNumber_Solution(1500));
		int res = GetUglyNumber(1500);
		System.out.println("res2:" + res);
	}
}
