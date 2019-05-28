package com.other;

//求1+2+…+n，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
//解法：
//使用递归来代替循环，用逻辑运算符&&或者||来代替判断语句。
//代码实现功能为：当n大于1时，和为f(n)=f(n-1)+n，n=1时，f(n)=1
//tips：逻辑运算符有短路特性，可以当作if使用
public class Accumulate {
	public int getSum(int n) {
		int sum = n;
		boolean flag = (n > 1) && ((sum += getSum(n - 1)) > 0);
		// 上面这句话相当于：
//		if (n > 1)
//			sum += getSum(n - 1);

		// 也可以使用||来实现
		// boolean flag = (n == 1) || ((sum += getSum(n - 1)) > 0);
		return sum;
	}

}
