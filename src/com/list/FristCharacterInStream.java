package com.list;
//字符流中第一个不重复的字符

//使用HashMap来统计字符出现的次数

import java.util.HashMap;

public class FristCharacterInStream {
	private StringBuilder res = new StringBuilder();
	private HashMap<Character, Integer> hashMap = new HashMap<Character, Integer>();

	public void insert(char ch) {
		res.append(ch);
		hashMap.put(ch, hashMap.getOrDefault(ch, 0) + 1);
	}

	public char FirstAppearingOnce() {
		for (char ch : res.toString().toCharArray()) {
			if (hashMap.get(ch) == 1) {
				return ch;
			}
		}
		return '#';
	}
}
