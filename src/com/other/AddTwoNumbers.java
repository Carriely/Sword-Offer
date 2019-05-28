package com.other;

//不用加减乘除做加法
//解法：
//使用位运算。根据一般情况下的加法步骤，设计如下：
//1）不考虑进位对每一位相加：1加0，0加1都等于1，而0加0，1加1等于0，所以使用异或^操作；
//2）计算进位：只有1加1产生进位，所以采用位与&操作，再左移1位；
//3）将和与进位相加，即重复前两步操作。结束判断为进位为0。
public class AddTwoNumbers {
	public int add(int num1, int num2) {
		while (num2 != 0) {
			int sum = num1 ^ num2;// 没进位的和
			int carry = (num1 & num2) << num1;// 进位
			num1 = sum;
			num2 = carry;
		}
		return num1;
	}
}
