package com.stringandarray;

/**
 * 请实现一个函数，把字符串中的每个空格替换成"%20"。 例如输入"We are happy"，则输出"We%20are%20happy"
 */
public class ReplaceSpaces {
	public static String change(char[] charArray) {
		int n = charArray.length;
		//计算有多少个空格
		int count = 0;
		for (int i = 0; i < n; i++) {
			if (charArray[i] == ' ') {
				count++;
			}
		}
		if (count == 0) {
			//将char数组转为string
			return String.valueOf(charArray);
		}
		System.out.println("count---" + count);
		char[] temp = new char[n + 2 * count];
		int j = n + 2 * count - 1;
		int i = n - 1;
		while (i >= 0) {// i>1不正确
			if (charArray[i] == ' ') {
				temp[j] = '0';
				temp[j - 1] = '2';
				temp[j - 2] = '%';
				j = j - 3;
			} else {
				temp[j] = charArray[i];
				j--;
			}
			i--;
		}
		return new String(temp);
	}

	public static String change2(StringBuffer str) {
		return str.toString().replaceAll("\\s", "%20");
	}

	public static void main(String[] args) {
		String str = "We are happy";
		char[] charArray = str.toCharArray();
		System.out.println(change(charArray));
		String str2 = "helloworld";
		char[] charArray2 = str2.toCharArray();
		System.out.println(change(charArray2));
		StringBuffer sBuffer = new StringBuffer("We are happy");
		System.out.println(change2(sBuffer));
	}
}
