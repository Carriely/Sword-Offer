package com.stringandarray;
//***

//字符串的排列
//解法：DFS+回溯
//对整个字符串的排列可以看成两部分：
//第一步求所有可能出现在第一个位置的字符，即把第一个字符与后面所有非重复的字符进行交换。
//第二步固定第一个字符，求后面所有字符的排列；第二步中后面的所有字符又可以看成一个完整的字符，继续执行这两个步骤。
//注意存在重复值的情况，比如输入字符串bab，将首字符b作为固定字符串，对于将第2个下标的b换到首位仍然是bab，所有这种情况无需输出。
//参考：https://blog.csdn.net/zjxxyz123/article/details/79709240
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class StringPermutation {
	// 全排列
	public ArrayList<String> Permutation(String str) {
		ArrayList<String> result = new ArrayList<>();
		if (str == null || str.length() == 0) {
			return result;
		}
		char[] chars = str.toCharArray();
		// 递归输出字符串排列
		permutationHelper(chars, 0, result);
		// 排序（字典序排序）
		Collections.sort(result);
		return result;
	}

	private void permutationHelper(char[] chars, int index, ArrayList<String> list) {
		if (index == chars.length - 1) {
			list.add(new String(chars));
			return;
		}
		// 去重
		Set<Character> set = new HashSet<>();// hash表，查询花费O(1)
		for (int i = index; i < chars.length - 1; i++) {
			// 排除出现重复字符
			if (!(set.contains(chars[i]))) {
				set.add(chars[i]);
				// 交换第一个字符和后面的字符（包括自己）
				swap(chars, index, i);
				// 固定第一个字符，递归剩余字符[index+1,length-1]
				permutationHelper(chars, index + 1, list);
				// 还原
				swap(chars, index, i);
				// 为什么要进行两次swap？
				// 将确定的字符与当前第i个字符相交换，然后i+1～N-1依然是剩下的字符
				// 这样做改变了字符数组，必须进行完一次dfs过程后，将数组复原，便于确定i位置其他元素时，不会受到影响。
			}
		}
	}

	private void swap(char[] chars, int i, int j) {
		char temp = chars[i];
		chars[i] = chars[j];
		chars[j] = temp;
	}
}
