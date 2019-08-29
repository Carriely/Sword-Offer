package com.searchandsort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

//把数组排成最小的数（包含大数问题）
//解法：
//观察规律，自行定义一种排序规则。
//对于数字m和n，可以拼接成mn和nm，如果mn<nm，我们定义m小于n。反之则相反。利用这个排序规则，从小排到大即可实现题目要求。
public class SortArrayForMinNumber {
	public static String PrintMinNumber(int[] numbers) {
		if (numbers == null || numbers.length <= 0) {
			return "";
		}
		ArrayList<String> arrayList = new ArrayList<>();
		for (int number : numbers) {
			arrayList.add(String.valueOf(number));
		}
		// 考虑到大数问题，因此将m和n拼接起来的数字转换成字符串处理。
		// 因为mn和nm的字符串位数相同，因此它们的大小只需要按照字符串大小的比较规则就可以了。
		// 利用Collections.sort(List<T> list, Comparator<? super T> c)方法进行排序。
		Collections.sort(arrayList, new Comparator<String>() {

			// 重写compare()方法来规定比较规则。
			@Override
			public int compare(String s1, String s2) {
				String a = s1 + s2;
				String b = s2 + s1;
				return a.compareTo(b);
			}

		});
		StringBuilder sb = new StringBuilder();
		for (String str : arrayList) {
			sb.append(str);
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		int[] numbers = { 27, 4, 1, 6, 5, 8 };
		System.out.println(PrintMinNumber(numbers));
	}
}
