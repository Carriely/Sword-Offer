package com.dynamicProgramming;
//***
//礼物的最大价值
//在一个 m×n 的棋盘的每一格都放有一个礼物，每个礼物都有一定的价值（价值大于 0）。你可以从棋盘的左上角开始拿格子里的礼物，并每次向左或者向下移动一格直到到达棋盘的右下角。给定一个棋盘及其上面的礼物，请计算你最多能拿到多少价值的礼物？
//解法：
//写出递推式，res 表示获得的最大礼物。
//res[i][j] = Math.max(res[i - 1][j], res[i][j - 1]) + grid[i][j];
public class MaxValueOfGifts {
	public int getMaxValue(int[][] value) {
		if (value == null || value.length == 0) {
			return 0;
		}
		int rows = value.length;
		int cols = value[0].length;
		int[][] res = new int[rows][cols];
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				int left = 0;
				int up = 0;
				if (i > 0) {
					up = res[i - 1][j];
				}
				if (j > 0) {
					left = res[i][j - 1];
				}
				res[i][j] = Math.max(up, left) + value[j][j];
			}
		}
		return res[rows - 1][cols - 1];
	}

	// 优化：辅助数组不用和m*n的二维数组一样大，只需要保存上一层的最大值就可以，使用长度为列数n的一位数组作为辅助数组。
	public int getMaxValue1(int[][] value) {
		if (value == null || value.length == 0) {
			return 0;
		}
		int rows = value.length;
		int cols = value[0].length;
		int[] res = new int[cols];
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				int left = 0;
				int up = 0;
				if (i > 0) {
					up = res[j];
				}
				if (j > 0) {
					left = res[j - 1];
				}
				res[j] = Math.max(up, left) + value[j][j];
			}
		}
		return res[cols - 1];
	}
}
