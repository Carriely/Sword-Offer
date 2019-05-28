package com.other;

import java.util.LinkedList;

//约瑟夫环问题
public class Josephuse {
	// 解法一：链表
	// 假设当前删除的结点下标为removeIndex，则下一个要删除的结点的下标为：(removeIndex+m-1)%list.size()，通过取余符号可以实现类型循环的操作。
	public int LastRemaining_Solution(int n, int m) {
		if (n < 1 || m < 1) {
			return -1;
		}
		LinkedList<Integer> list = new LinkedList<>();
		int removeIndex = 0;
		for (int i = 0; i < n; i++) {
			list.add(i);
		}
		while (list.size() > 1) {
			removeIndex = (removeIndex + m - 1) % list.size();
			list.remove(removeIndex);
		}
		return list.getFirst();
	}

	// 解法二：分析数学规律直接计算
	// 递推公式：
	// f(n,m) =（f(n-1,m)+m)%n
    // f(1,m) = 0
	// 时间复杂度为O(n)，空间复杂度为O(1)。
	public int LastRemaining_Solution2(int n, int m) {
		if (n < 1 || m < 1) {
			return -1;
		}
		int last = 0;
		for(int i=2;i<=n;i++) {
			last = (last+m)%i;
		}
		return last;
	}

}
