package com.math;
//***

//数字序列0123456789101112131415…中某一位的数字
//解法一：枚举
//解法二：根据规律跳过一些数字

//以第1001位数字7为例
//步骤1：首先确定该数字是属于几位数的;
//如果是一位数，n<9;如果是两位数，n<9+90*2=189;如果是三位数，n<189+900*3=2889;说明是三位数。
//步骤2：确定该数字属于哪个数。100+(1001-190)/3= 370。
//步骤3：确定是该数中哪一位。1001-190-(370-100)*3 = 1,所以位于“370”的下标为1的位置，即数字1。

public class DigitsInSequence {
	public static int digitAtIndex(int index) {
		if(index<0) {
			return -1;
		}
		if(index<10) {
			return index;
		}
		//当前索引
		int curIndex = 10;//第10位是9
		//length位数
		int length = 2;
		//length位数的起始数字
		int boundNum = 10;
		//确定length位数
		while(curIndex+lengthSum(length)<index) {
			curIndex+=lengthSum(length);
			boundNum*=10;
			length++;
		}
		//确定是哪一个数字
		int curNum = boundNum+(index-curIndex)/length;
		//确定是哪一位
		return Integer.toString(curNum).charAt(index-curIndex-(curNum-boundNum)*length)-'0';
	}

	// 计算length位数字总长度
	public static int lengthSum(int length) {
		int count = 9;
		for(int i=1;i<length;i++) {
			count*=10;
		}
		return count*length;
	}

	public static void main(String[] args) {
		//输出某个数字的某位数
		System.out.println(Integer.toString(123).charAt(1)-'0');
		System.out.println("haaaa".charAt(1));
		System.out.println(digitAtIndex(1001));
	}

}
