package com.math;

//***
//二进制中 1 的个数
public class NumberOf1InBinary {
//  解法一：
//	利用整数 1，依次左移每次与 n 进行与运算，若结果不为0，说明这一位上数字为 1，++count。
//	此解法 i 需要左移 32 次。
//	不要用 n 去右移并与 1 进行与运算，因为 n 可能为负数，右移时会陷入死循环。
	public static int NumberOf1(int n) {
		int count = 0;
		int i = 1;
		while (i != 0) {
			if ((n & i) != 0) {
				count++;
			}
			i <<= 1;
		}
		return count;
	}

//  解法二（推荐算法）：
//  运算 (n - 1) & n，直至 n 为 0。运算的次数即为 n 的二进制中 1 的个数。
//  因为 n-1 会将 n 的最右边一位 1 改为 0，如果右边还有 0，则所有 0 都会变成 1。结果与 n 进行与运算，会去除掉最右边的一个1。
//  举例：
//	若 n = 1100，
//	n - 1 = 1011
//	n & (n - 1) = 1000
//	即：把最右边的 1 变成了 0。
//  结论：
//	把一个整数减去 1 之后再和原来的整数做位与运算，得到的结果相当于把整数的二进制表示中最右边的 1 变成 0。很多二进制的问题都可以用这种思路解决。
	public static int NumberOf1_1(int n) {
		int count = 0;
		while (n != 0) {
			n = (n - 1) & n;
			count++;
		}
		return count;
	}

	public static void main(String[] args) {
		int n = 10;
		System.out.println(Integer.toBinaryString(n));
		System.out.println("统计二进制数1的个数：" + NumberOf1(n));
		System.out.println("统计二进制数1的个数：" + NumberOf1_1(n));
	}
}
