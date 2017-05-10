package com.qjs.yonth.java.thread.pc;

public class Test {
	public static void main(String[] args) {
		Store store = new Store();

		Producer p = new Producer(store);
		new Thread(p, "t1").start();
		new Thread(p, "t2").start();
		new Thread(p, "t4").start();
		new Thread(p, "t3").start();
		new Thread(p, "t5").start();
		new Thread(p, "t6").start();
		Consumer c = new Consumer(store);
		new Thread(c, "c1").start();
		new Thread(c, "c2").start();
		new Thread(c, "c3").start();
	}
}
