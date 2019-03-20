package com.stringandarray;

//翻转单词顺序
//输入一个英文句子，翻转句子中单词的顺序，但单词内字符的顺序不变。
//为简单起见，标点符号和普通字母一样处理。
//解法:
//先对字符串按空格切割成数组，再逆序数组后，最后将元素拼接并返回。
public class ReverseWordsInSentence {
	public String reverseWords(String str) {
		if (str == null || str.length() == 0 || str.trim().equals("")) {
			return str;
		}
		String[] array = str.split(" ");
		int p = 0;
		int q = array.length - 1;
		while (p < q) {
			swap(array, p++, q--);
		}
		return String.join(" ", array);
	}

	public void swap(String[] arr, int p, int q) {
		String string = arr[p];
		arr[p] = arr[q];
		arr[q] = string;
	}
}
