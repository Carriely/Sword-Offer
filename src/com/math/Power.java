package com.math;

//数值的整数次方
//注意：
//判断值数是否小于 0。另外 0 的 0 次方没有意义。
public class Power {
	static double result = 1.0;

	public static double power(double base, int exponent) {
		int n = Math.abs(exponent);
		for (int i = 0; i < n; i++) {
			result *= base;
		}
		return exponent < 0 ? 1.0 / result : result;
	}
	
	public static void main(String[] args) {
		System.out.println(power(2, 0));
	}
}
