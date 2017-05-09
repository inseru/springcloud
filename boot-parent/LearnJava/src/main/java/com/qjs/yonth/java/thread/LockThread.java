package com.qjs.yonth.java.thread;

import java.util.concurrent.locks.ReentrantLock;

public class LockThread {
	public static void main(String[] args) {
		App2 a = new App2();

		Thread t = new Thread(a, "a");
		t.start();

		Thread t1 = new Thread(a, "b");
		t1.start();

		Thread t2 = new Thread(a, "c");
		t2.start();
	}
}

class App2 implements Runnable {
	public static int num = 50;

	// 对象锁
	private final ReentrantLock lock = new ReentrantLock();

	@Override
	public void run() {
		test();
	}

	public void test() {
		for (int i = 1; i <= 50; i++) {
			try {
				lock.lock();
				if (num > 0) {
					System.out.println("thread:" + Thread.currentThread().getName() + i + "," + num);
					try {
						Thread.sleep(50);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					num--;
				}
			} catch (Exception e2) {

			} finally {
				lock.unlock();
			}

		}
	}

}