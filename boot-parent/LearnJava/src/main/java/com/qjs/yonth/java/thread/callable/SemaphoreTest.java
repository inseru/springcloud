package com.qjs.yonth.java.thread.callable;

import java.util.concurrent.Semaphore;

/**
 * 信号量-控制资源访问 Semaphore 是只允许一定数量的线程同时执行一段任务
 * 
 * @author Administrator
 *
 */
public class SemaphoreTest {
	public static void main(String[] args) {
		// 控制线程的数目,也就是单线程
		Semaphore semaphore = new Semaphore(10);
		Work2 w = new Work2(semaphore);
		for (int i = 0; i < 5; i++) {
			new Thread(w, String.valueOf(i)).start();
		}
	}
}

class Work2 implements Runnable {
	private Semaphore semaphore;

	public Work2(Semaphore semaphore) {
		super();
		this.semaphore = semaphore;
	}

	@Override
	public void run() {
		try {
			// 从信号量中获取一个允许机会
			semaphore.acquire();
			// acquire动态地添加permits的数量，它表示的是一次性获取许可的数量(总的信号量除以每次获取的许可数即10/3=3，就是说可以允许3个线程一起运行。),信号量也要一起释放
			// semaphore.acquire(4);
			System.out.println(Thread.currentThread().getName() + " start at " + System.currentTimeMillis());
			// availablePermits()查看现在可用的信号量：
			// System.out.println("Semaphore available permits: " +
			// semaphore.availablePermits());
			Thread.sleep(1000);
			System.out.println(Thread.currentThread().getName() + " stop at " + System.currentTimeMillis());
			// 释放允许，将占有的信号量归还
			semaphore.release();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
