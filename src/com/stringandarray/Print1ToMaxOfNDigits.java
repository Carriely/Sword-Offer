package com.stringandarray;

//***
//打印从 1 到最大的 n 位数
//比如输入 3，则打印出 1、2、3 一直到最大的 3 位数即 999。
//解法：全排列
//如果在所有的数字前面补0，n位所有的十进制数其实就是n个从0到9的全排列。
//在打印时，数字排在前面的0不打印。
public class Print1ToMaxOfNDigits {
	public static void printToMaxOfDigits(int n) {
		if (n <= 0) {
			System.out.println("输入的n没有意义");
			return;
		}
		char[] number = new char[n];
		for (int i = 0; i < number.length; i++) {
			number[i] = '0';
		}
		for (int i = 0; i < 10; i++) {
			number[0] = (char) (i + '0');
			printToMaxOfNDigitsRecursively(number, n, 0);
		}
	}

	// 利用递归实现1到最大的n位数的全排列
	public static void printToMaxOfNDigitsRecursively(char[] number, int n, int index) {
		if (index == n - 1) {
			printNumber(number);
			return;
		}
		for (int i = 0; i < 10; i++) {
			number[index+1] = (char) (i + '0');
			printToMaxOfNDigitsRecursively(number, n, index + 1);
		}
	}

	// 输出
	public static void printNumber(char[] number) {
		boolean isNotBegin0 = false;
		for (int i = 0; i < number.length; i++) {
			if (!isNotBegin0 && number[i] != '0') {
				isNotBegin0 = true;
			}
			if (isNotBegin0) {
				System.out.println(number[i]);
			}
		}
		System.out.println();
	}

	public static void main(String[] args) {
		printToMaxOfDigits(3);
	}
}
