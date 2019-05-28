package com.list;

import java.util.HashMap;

//第一个只出现一次的字符
//解法:
//使用HashMap来统计字符出现的次数，因为字符的多少是固定的（大小写字母一共52个），所以可以认为使用HashMap的空间复杂度为O(1)。
//该解法时间复杂度为O(n)。
public class FirstNotRepeatingChar {
	public int getFirstNotRepeatingChar(String str) {
		if (str.length() == 0 || str == null) {
			return -1;
		}
		HashMap<Character, Integer> hashMap = new HashMap<>();
		for (int i = 0; i < str.length(); i++) {
			hashMap.put(str.charAt(i), hashMap.getOrDefault(str.charAt(i), 0) + 1);
		}
		for (int i = 0; i < str.length(); i++) {
			if (hashMap.get(str.charAt(i)) == 1) {
				return i;
			}
		}
		return -1;
	}

}
