package com.stringandarray;

//正则表达式匹配
//解法；
//判断模式中第二个字符是否是 *：
//	若是，看如果模式串第一个字符与字符串第一个字符是否匹配：
// 		若不匹配，在模式串上向右移动两个字符j+2，相当于 a* 被忽略（*匹配0次）。
//		若匹配，
//			字符串不移动，模式串可以移动两个字符j+2（*匹配0次）；
//			字符串后移i+1，模式串可以移动两个字符j+2（*匹配1次）；
//			字符串后移i+1，模式串也可以不移动j（*匹配多次）。
//	若不是，看当前字符与模式串的当前字符是否匹配，即 str[i] == pattern[j] || pattern[j] == '.'：
//		若匹配，则字符串与模式串都向右移动一位，i+1，j+1。
//		若不匹配，返回 fasle。
public class RegularExpressionsMatching {
	/**
	 * 判断字符串是否与模式串匹配
	 * 
	 * @param str     字符串
	 * @param pattern 模式串
	 * @return 是否匹配
	 */
	public boolean match(char[] str, char[] pattern) {
		if (str == null || pattern == null) {
			return false;
		}
		return match(str, 0, str.length, pattern, 0, pattern.length);
	}

	public boolean match(char[] str, int i, int len1, char[] pattern, int j, int len2) {
		if (i == len1 && j == len2) {
			return true;
		}
		// 模式串已经扫描完但还有没匹配的字符
		if (i != len1 && j == len2) {
			return false;
		}
		// 第二个字符是*
		if (j + 1 < len2 && pattern[j + 1] == '*') {
			// 模式串第一个字符与字符串第一个字符匹配
			if (i < len1 && str[i] == pattern[j] || pattern[j] == '.') {
				return match(str, i, len1, pattern, j + 2, len2) 
						|| match(str, i + 1, len1, pattern, j, len2)
						|| match(str, i + 1, len1, pattern, j + 2, len2);
			}
			// 不匹配
			return match(str, i, len1, pattern, j + 2, len2);
		}
		// 第二个字符不是*
		// 若匹配
		if (i < len1 && str[i] == pattern[j] || pattern[j] == '.') {
			return match(str, i + 1, len1, pattern, j + 1, len2);
		}
		// 不匹配
		return false;
	}

}
