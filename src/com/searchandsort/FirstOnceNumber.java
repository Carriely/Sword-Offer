package com.searchandsort;

import java.util.LinkedHashMap;

//在字符串中找出第一个只出现一次的字符。
//采用哈希表,key是字母,value是字母出现的次数
public class FirstOnceNumber {
	public static Character firstOnceNumber(String str) {
		if (str == null) {
			return null;
		}
		char[] strChar = str.toCharArray();
		LinkedHashMap<Character, Integer> hashMap = new LinkedHashMap<Character, Integer>();
		for (char item : strChar) {
			if (hashMap.containsKey(item)) {
				hashMap.put(item, hashMap.get(item) + 1);
			} else {
				hashMap.put(item, 1);
			}
		}
		for (char key : hashMap.keySet()) {
			if (hashMap.get(key) == 1) {
				return key;
			}
		}
		return null;
	}

	public static void main(String[] args) {
		System.out.println(firstOnceNumber("abaccdeff"));
	}
}
