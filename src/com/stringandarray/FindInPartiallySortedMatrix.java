package com.stringandarray;

// 二维数组中的查找
//解法：
//从二维数组的右上方开始查找：
//若元素值等于 target，返回 true；
//若元素值大于 target，砍掉这一列，即 --j；
//若元素值小于 target，砍掉这一行，即 ++i。
//ps:也可以从二维数组的左下方开始查找，以下代码使用左下方作为查找的起点。
public class FindInPartiallySortedMatrix {
	// 从二维数组的左下方开始查找
	public boolean find(int target, int[][] array) {
		if (array == null) {
			return false;
		}
		int row = array.length;
		int columns = array[0].length;

		int i = row - 1;
		int j = 0;
		while (i >= 0 && j < columns) {
			if (array[i][j] == target) {
				return true;
			}
			if (array[i][j] < target) {
				j++;
			} else {
				i--;
			}
		}
		return false;
	}

	// 从二维数组的右上方开始查找
	public boolean find2(int target, int[][] array) {
		if (array == null) {
			return false;
		}
		int row = array.length;
		int columns = array[0].length;

		int i = 0;
		int j = columns;
		while (i < row && j >= 0) {
			if (array[i][j] == target) {
				return true;
			}
			if (array[i][j] < target) {
				i++;
			} else {
				j--;
			}
		}
		return false;
	}
}