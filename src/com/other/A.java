package com.other;

//设计一个类，我们只能生成该类的一个实例。
public class A {
	// 饿汉式 线程安全
	public final static A a = new A();

	private A() {

	}

	public static A getIntance() {
		return a;
	}

}
