package com.qjs.yonth.java.thread.pc;

/**
 * 消费者
 * 
 * @author Administrator
 *
 */
public class Consumer implements Runnable {

	private Store store;

	public Consumer(Store store) {
		super();
		this.store = store;
	}

	@Override
	public void run() {
		store.remove();
	}

}
