package com.qjs.yonth.java.thread.pc;

/**
 * 生产者
 * 
 * @author Administrator
 *
 */
public class Producer implements Runnable {

	private Store store;

	public Producer(Store store) {
		super();
		this.store = store;
	}

	@Override
	public void run() {
		store.add();
	}

}
