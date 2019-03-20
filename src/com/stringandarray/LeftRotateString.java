package com.stringandarray;

//左旋转字符串
//字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。
//注意：数据保证 n 小于等于输入字符串的长度。
//解法：
//先翻转前 n 个字符，再翻转后面的字符，最后整体翻转。
public class LeftRotateString {
	public String leftRotateString(String str, int n) {
		if (str == null || n < 1 || n > str.length()) {
			return str;
		}
		char[] c = str.toCharArray();
		int length = c.length;
		reverse(c, 0, n - 1);
		reverse(c, n, length - 1);
		reverse(c, 0, length - 1);
		return new String(c);
	}

	public void reverse(char[] c, int p, int q) {
		while (p < q) {
			swap(c, p++, q--);
		}
	}

	public void swap(char[] c, int p, int q) {
		char temp = c[p];
		c[p] = c[q];
		c[q] = temp;
	}
}
