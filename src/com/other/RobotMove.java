package com.other;

//机器人的移动范围（回溯）
//解法：
//从坐标(0, 0) 开始移动，当它准备进入坐标(i, j)，判断是否能进入。
//如果能，再判断它能否进入 4 个相邻的格子 (i-1, j), (i+1, j), (i, j-1), (i, j+1)。
public class RobotMove {
	public int movingCount(int threshold, int rows, int cols) {
		if (rows < 0 || cols < 0 || threshold < 0) {
			return 0;
		}
		boolean[] visited = new boolean[rows * cols];
		return getCount(threshold, 0, 0, rows, cols, visited);
	}

	// 递归
	private int getCount(int threshold, int i, int j, int rows, int cols, boolean[] visited) {
		if (check(threshold, i, j, rows, cols, visited)) {
			visited[i * rows + j] = true;
			return 1 + getCount(threshold, i - 1, j, rows, cols, visited)
					+ getCount(threshold, i + 1, j, rows, cols, visited)
					+ getCount(threshold, i, j - 1, rows, cols, visited)
					+ getCount(threshold, i, j + 1, rows, cols, visited);
		}
		return 0;
	}
	
	private boolean check(int threshold, int i, int j, int rows, int cols, boolean[] visited) {
		return i >= 0 && i < rows 
				&& j >= 0 && j < cols 
				&& !visited[i * rows + j]
				&& (getDigitSum(i) + getDigitSum(j) <= threshold);// 检查行坐标和列坐标的数位之和
	}

	// 求坐标数位之和
	private int getDigitSum(int i) {
		int res = 0;
		while (i > 0) {
			res += i % 10;
			res /= 10;
		}
		return res;
	}
}
