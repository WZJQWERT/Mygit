package com.gfxy.instance;

public class MyClass extends Object{
	private static MyClass instance = null;//=new Myclass

	private MyClass() {
	}

	public static MyClass getInstance(int m) {
		if (instance == null) {         //效率
		synchronized (MyClass.class){		//线程安全
			if (instance == null) {
				try {
					Thread.sleep(m);
				} catch (InterruptedException e) {
					e.printStackTrace();

				}
				instance =new MyClass();
			}
		}
	}
				return instance;
}
	}

