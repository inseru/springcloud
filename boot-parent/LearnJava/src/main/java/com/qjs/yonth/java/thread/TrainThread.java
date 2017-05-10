package com.qjs.yonth.java.thread;

public class TrainThread {
	public static void main(String[] args) {
		App a = new App();

		Thread t = new Thread(a, "a");
		t.start();

		Thread t1 = new Thread(a, "b");
		t1.start();

		Thread t2 = new Thread(a, "c");
		t2.start();
	}
}

class App implements Runnable {
	public static int num = 50;

	@Override
	public void run() {
		test();
	}

	// 同步锁 对同一资源对象的操作，才存在互斥锁
	public synchronized void test() {
		for (int i = 1; i <= 50; i++) {
			if (num > 0) {
				System.out.println("thread:" + Thread.currentThread().getName() + i + "," + +num);
				try {
					Thread.sleep(50);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				num--;
			}
		}
	}

}