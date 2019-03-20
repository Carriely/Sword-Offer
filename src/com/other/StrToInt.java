package com.other;

//将一个字符串转换成一个整数(实现Integer.valueOf(string)的功能，数值为0或者字符串不是一个合法的数值则返回0。
/*
注意：
1. 异常输入和0输入的区分
2. 正负号的处理
3. 溢出处理
*/
public class StrToInt {
	public static int strToInt(String str) {
		char[] array = str.toCharArray();
		// 字符串为空
		if (array.length == 0 || array == null) {
			return 0;
		}
		// 判断正负号
		int flag = 0;
		if (array[0] == '+') {
			flag = 1;
		}
		if (array[0] == '-') {
			flag = 2;
		}
		int start = flag > 0 ? 1 : 0;
		int result = 0;
		for (int i = start; i < array.length; i++) {
			if (array[i] >= '0' && array[i] <= '9') {
				result = result * 10 + array[i] - '0';
			} else {
				return 0;
			}
		}
		// 溢出处理
		if ((flag == 1 && result > Integer.MAX_VALUE) || (flag == 2) && result <= Integer.MIN_VALUE) {
			return 0;
		}
		return flag == 1 ? result : -result;
	}

	public static void main(String[] args) {
		String s = "-12312312";
		System.out.println("使用库函数转换：" + Integer.valueOf(s));
		int res = strToInt(s);
		System.out.println("使用自己写的方法转换：" + res);

	}

}
