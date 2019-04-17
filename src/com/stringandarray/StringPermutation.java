package com.stringandarray;
//字符串的排列
//解法：
//对整个字符串的排列可以看成两部分：
//第一步求所有可能出现在第一个位置的字符，即把第一个字符与后面所有非重复的字符进行交换。
//第二步固定第一个字符，求后面所有字符的排列；第二步中后面的所有字符又可以看成一个完整的字符，继续执行这两个步骤。
//注意存在重复值得情况，比如输入字符串bab，将首字符b作为固定字符串，对于将第2个下标的b换到首位仍然是bab，所有这种情况无需输出。

import java.util.ArrayList;

public class StringPermutation {
	// 全排列
	public ArrayList<String> Permutation(String str) {
		ArrayList<String> result = new ArrayList<>();
		return result;
	}
}
