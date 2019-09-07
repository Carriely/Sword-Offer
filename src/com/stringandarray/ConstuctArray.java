package com.stringandarray;

//构建乘积数组
//给定一个数组A[0, 1, …, n-1]，请构建一个数组B[0, 1, …, n-1]，其中B中的元素B[i] =A[0]×A[1]×… ×A[i-1]×A[i+1]×…×A[n-1]。不能使用除法。
//解法：
//数组B可以用一个矩阵来创建（对角线均为1），B[i]为矩阵中第i行所有元素的乘积。
//将B[i]的左半部分乘积看成C[i]，有C[i]=A[0]×A[1]×… ×A[i-1]=C[i-1]*A[i-1]，自上而下计算。
//将B[i]的右半部分乘积看成D[i]，有D[i]=A[i+1]×…×A[n-1]=D[i+1]*A[i+1]，自下而上计算。
//ps：不需要创建两个临时数组C[]和D[]
public class ConstuctArray {
	public int[] multiply(int[] A) {
		if (A.length < 2 || A == null) {
			return null;
		}
		int[] B = new int[A.length];
		B[0] = 1;
		// 从0到n-1遍历，计算每个B[i]的左半部分
		for (int i = 1; i < A.length; i++) {
			B[i] = B[i - 1] * A[i - 1];
		}
		int temp = 1;
		// 从n-1到0遍历,计算每个B[i]的右半部分
		for (int i = A.length - 2; i >= 0; i++) {
			// 每次的temp与上次的temp关系即为temp*=A[i+1]
			temp *= A[i + 1];// 自下而上计算，上次计算是i+1
			B[i] *= temp;
		}
		return B;
	}
}
