package com.math;

//斐波那契数列,求第n项，n从0开始
public class Fibonacci {
	// 解法一：递归，效率低
	public static int fibonacci(int n) {
		if (n < 2) {
			return n;
		}
		return fibonacci(n - 1) + fibonacci(n - 2);
	}

	// 非递归算法:从下往上计算，递推，时间复杂度 O(n)
	public static int fibonacci2(int n) {
		if (n < 2) {
			return n;
		}
		int[] res = new int[n + 1];
		res[0] = 0;
		res[1] = 1;
		for (int i = 2; i <= n; i++) {
			res[i] = res[i - 1] + res[i - 2];
		}
		return res[n];
	}
	
	public static void main(String[] args) {
		int num = fibonacci(5);
		System.out.println(num);
		System.out.println(fibonacci2(5));
	}
}