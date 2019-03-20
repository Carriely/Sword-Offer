package com.other;

import java.util.Arrays;

//扑克牌中的顺子
public class IsContinuous {

	// 1.把数组排序
	// 2.统计数组中0的个数
	// 3.统计排序之后的数组中相邻数字之间的空缺总数，如果空缺总数小于等于0的个数，则数组是连续的，否则是不连续的
	// 注意：如果数组中非0数字重复出现，则肯定是不连续的

	public static boolean isContinuous(int[] numbers) {
		if (numbers.length < 1 && numbers == null) {
			return false;
		}
		Arrays.sort(numbers);
		//quickSort(numbers, 0, numbers.length - 1);
		int count0 = 0;
		// 统计0的个数
		for (int i = 0; i < numbers.length && numbers[i] == 0; i++) {
			count0++;
		}
		System.out.println("count0:" + count0);
		// 统计数组中相邻数字之间的空缺总数
		int countGap = 0;
		int low = count0;// 因为数组已排序
		int high = low + 1;
		while (high < numbers.length) {
			// 数组中存在相邻两元素相同，则不可能为连续数组
			if (numbers[low] == numbers[high]) {
				return false;
			} else {
				countGap += numbers[high] - numbers[low] - 1;
				low++;
				high++;
			}
		}
		System.out.println("countGap:" + countGap);
		return (count0 >= countGap) ? true : false;
	}

	// 快速排序
	public static void quickSort(int[] data, int s, int t) {
		int i = s;
		int j = t;
		int temp;
		if (s < t) {
			temp = data[s];
			while (i != j) {
				while (j > i && data[j] >= temp) {
					j--;
				}
				data[i] = data[j];
				while (i < j && data[i] <= temp) {
					i++;
				}
				data[j] = data[i];
			}
			data[i] = temp;
			quickSort(data, s, i - 1);
			quickSort(data, i + 1, t);
		}
	}

	// 交换
	public void swap(int[] data, int i, int j) {
		int temp = data[i];
		data[i] = data[j];
		data[j] = temp;
	}

	// 测试
	public static void main(String[] args) {
		int[] array = new int[] { 2, 3, 5, 0, 1 };
		quickSort(array, 0, array.length - 1);
		for (int i = 0; i < array.length; i++) {
			System.out.println(array[i]);
		}
		System.out.println(isContinuous(array));

	}

}
