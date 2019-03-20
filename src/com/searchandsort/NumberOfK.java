package com.searchandsort;
//统计一个数字在排序数组中出现的次数。

//解法：
//找出第一个 k 和最后一个 k 出现的位置。
//找第一个 k 时，利用二分法，如果 nums[m] == k，判断它的前一个位置是不是也是 k，如果不是，说明这是第一个 k，直接返回。如果是，那么递归在左边查找第一个 k。
//找最后一个 k 也同理。

//<< : 左移运算符，num << 1,相当于num乘以2
//>> : 右移运算符，num >> 1,相当于num除以2
public class NumberOfK {

	public static int getNumberOfK(int[] nums, int k) {
		// 判断数组不为空
		if (nums.length == 0 || nums == null) {
			return -1;
		}
		int start = 0;
		int end = nums.length - 1;
		int first = getFirstK(nums, start, end, k);
		int last = getLastK(nums, start, end, k);
		if (first > -1 && last > -1) {
			return (last - first + 1);
		}
		return 0;
	}

	// 寻找第一个k
	public static int getFirstK(int[] nums, int start, int end, int k) {
		if (start > end) {
			return -1;
		}
		// 计算中间位置
		int m = start + ((end - start) >> 1);
		if (nums[m] == k) {
			if (m == 0 || (m > 0 && nums[m - 1] != k)) {
				return m;
			} else {
				end = m - 1;
			}
		} else {
			if (nums[m] > k) {
				end = m - 1;
			} else {
				start = m + 1;
			}
		}
		return getFirstK(nums, start, end, k);
	}

	// 寻找最后一个k
	public static int getLastK(int[] nums, int start, int end, int k) {
		if (start > end) {
			return -1;
		}
		int m = start + ((end - start) >> 1);
		if (nums[m] == k) {
			if (m == nums.length - 1 || (m < nums.length - 1 && nums[m + 1] != k)) {
				return m;
			} else {
				start = m + 1;
			}
		} else {
			if (nums[m] > k) {
				end = m - 1;
			} else {
				start = m + 1;
			}
		}
		return getLastK(nums, start, end, k);
	}

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 3, 3, 3, 4, 5 };
		System.out.println(getNumberOfK(arr, 3));
	}

}
