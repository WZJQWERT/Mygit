package com.gfxy.Thread;

public class MyRunnable implements Runnable {

	private static int i = 20; // ��Ʊ��
	boolean flag = true;

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (flag) {
			task();
		}

	}
	//synchronized(�������� ���� this ���� Class) 
	//   c 
	public void task() {
		synchronized(this) {
			if (i <= 0) {
				flag = false;
				return;
			}
			try {
				Thread.sleep(1000); //
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
			System.out.println(Thread.currentThread().getName() + "--" + "售出票" + i--);


	}

}
