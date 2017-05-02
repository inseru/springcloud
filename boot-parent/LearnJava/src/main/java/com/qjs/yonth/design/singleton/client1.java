package com.qjs.yonth.design.singleton;

import java.util.concurrent.CountDownLatch;

public class client1 {

	public static void main(String[] args) throws InterruptedException {
		long t1 = System.currentTimeMillis();
		int size = 10;
		final CountDownLatch count = new CountDownLatch(size);
		for (int j = 0; j < size; j++) {
			new Thread(new Runnable() {
				@Override
				public void run() {
					for (int i = 0; i < 100000; i++) {
						SingletonSecond f = SingletonSecond.getInstance();
						count.countDown();
					}
				}
			}).start();
		}
		count.await();
		System.out.println(System.currentTimeMillis() - t1);

	}

}
