package com.designPattern;

// 单例模式
// 处理多线程，使用synchronized同步锁
// 加synchronized同步锁运行效率低下，下一个线程想要获取对象，就必须等待上一个线程释放锁之后，才可以继续运行。
// 使用双重检查进一步做了优化，可以避免整个方法被锁，只对需要锁的代码部分加锁，可以提高执行效率。
public class Singleton3 {
	// 静态变量
	// volatile（java5）：可以保证多线程下的可见性
	private static volatile Singleton3 instance = null;

	// 私有构造方法
	private Singleton3() {

	}

	// 静态方法(共有的)
	public static Singleton3 getInstance() {
		// 双重检查
		if (instance == null) {
			synchronized (Singleton3.class) {
				if (instance == null) {
					instance = new Singleton3();
				}
			}
		}
		return instance;
	}

}