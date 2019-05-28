package com.dynamicProgramming;

//把数字翻译成字符串
//递归解法：用f(i)来表示从第i位开始的不同翻译数目，可以得到有：f(i)=f(i+1)+g(i,i+1)*f(i+2)。i和i+1位数字拼起来在10~25范围内时g(i,i+1)的值为1，否则为0。
//动态规划解法：由于递归解法存在重复的子问题，我们从数字的末尾开始计算f(i)，自下而上解决问题
//因此，对于12258：
//f(5) = 0
//f(4) = 1
//f(3) = f(4)+0*f(5) = 1------因为58不在10～25之间
//f(2) = f(3)+1*f(4) = 2
//f(1) = f(2)+1*f(3) = 3 
//f(0) = f(1)+1*f(2) = 5
public class TranslateNumbersToStrings {
	public int getTranslationCount(String str) {
		if (str == null || str.length() < 2) {
			return 1;
		}
		// 排除负数
		if (str.charAt(0) == '-') {
			return 0;
		}
		int len = str.length();
		// count[i]表示从第i位开始的不同翻译数目
		int[] count = new int[len];
		for (int i = len - 1; i >= 0; i--) {
			if (i == len - 1) {
				count[i] = 1;
			} else {
				count[i] = count[i + 1];
				// 判断i和i+1位数字拼起来是否在10~25范围内
				if (isInRange(str.charAt(i), str.charAt(i + 1))) {
					// 必须要先判断i=len-2的情况，否则数组越界
					// 或者count数组大小设置为len+1，count[len]=0
					if (i == len - 2) {
						count[i] += 1;
					} else {
						count[i] += count[i + 2];
					}
				}
			}
		}
		return count[0];
	}

	private boolean isInRange(char a, char b) {
		int s = (a - '0') * 10 + (b - '0');
		return s >= 10 && s <= 25;
	}

	public static void main(String[] args) {
		TranslateNumbersToStrings demo = new TranslateNumbersToStrings();
		System.out.println(demo.getTranslationCount("0") == 1);
		System.out.println(demo.getTranslationCount("10") == 2);
		System.out.println(demo.getTranslationCount("12258") == 5);
		System.out.println(demo.getTranslationCount("-100") == 0);
	}
}
