package com.designPattern;

// 单例模式
// 懒汉式单例
public class Singleton {
	// 静态变量
	private static Singleton instance = null;

	// 私有构造方法
	private Singleton() {

	}

	// 静态方法
	public static Singleton getInstance() {
		if (instance == null) {
			instance = new Singleton();
		}
		return instance;
	}

}
