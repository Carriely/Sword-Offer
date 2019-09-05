package com.stringandarray;

//矩阵中的路径
//设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。路径可以从矩阵中的任意一个格子开始，每一步可以在矩阵中向左，向右，向上，向下移动一个格子。
//解法：回溯法
//首先，任选一个格子作为路径起点。假设格子对应的字符为 ch，并且对应路径上的第 i 个字符。
//若相等，到相邻格子寻找路径上的第 i+1 个字符。重复这一过程。
public class StringPathInMatrix {
	/**
	 * 判断矩阵中是否包含某条路径
	 * 
	 * @param matrix 矩阵
	 * @param rows   行数
	 * @param cols   列数
	 * @param str    路径
	 * @return bool
	 */
	public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
		if (matrix == null || rows < 1 || cols < 1 && str == null) {
			return false;
		}
		// 布尔值矩阵标识是否进入某个格子
		boolean[] visited = new boolean[matrix.length];
		// 记录比较到第几个字符
		int pathLength = 0;
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				hasPath(matrix, rows, cols, str, i, j, pathLength, visited);
			}
		}
		return false;
	}

	public boolean hasPath(char[] matrix, int rows, int cols, char[] str, int i, int j, int pathLength,
			boolean[] visited) {
		// 循环结束的条件
		if (pathLength == str.length) {
			return true;
		}
		boolean hathPath = false;
		if (i >= 0 && i < rows && j >= 0 && j < cols && matrix[i * cols + j] == str[pathLength]
				&& !(visited[i * cols + j])) {
			pathLength++;
			visited[i * cols + j] = true;
			hathPath = hasPath(matrix, rows, cols, str, i - 1, j, pathLength, visited)
					|| hasPath(matrix, rows, cols, str, i + 1, j, pathLength, visited)
					|| hasPath(matrix, rows, cols, str, i, j - 1, pathLength, visited)
					|| hasPath(matrix, rows, cols, str, i, j + 1, pathLength, visited);
		}
		if (!hathPath) {
			// 回到上一个字符
			pathLength--;
			visited[i * cols + j] = false;
		}
		return hathPath;
	}
}
