package com.designPattern;

// 单例模式
// 处理多线程，使用synchronized同步锁
public class Singleton2 {
	// 静态变量
	private static volatile Singleton2 instance = null;

	// 私有构造方法
	private Singleton2() {

	}

	// 静态方法(共有的)
	public static Singleton2 getInstance() {
		synchronized (Singleton2.class) {
			if (instance == null) {
				instance = new Singleton2();
			}
		}
		return instance;
	}

}