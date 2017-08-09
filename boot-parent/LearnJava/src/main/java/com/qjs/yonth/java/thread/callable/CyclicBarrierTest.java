package com.qjs.yonth.java.thread.callable;

import java.util.concurrent.CyclicBarrier;

/*
 * 总结： CountDownLatch 适用于一组线程和另一个主线程之间的工作协作。一个主线程等待一组工作线程的任务完毕才继续它的执行是使用
 * CountDownLatch 的主要场景。
 * CyclicBarrier 用于一组或几组线程，比如一组线程需要在一个时间点上达成一致，例如同时开始一个工作。
 * 另外，CyclicBarrier 的循环特性和构造函数所接受的 Runnable 参数也是 CountDownLatch 所不具备的。
 */
/**
 * 
 * @author CyclicBarrier强调的是n个线程，大家相互等待，只要有一个没完成，所有人都得等着。正如上例，只有5个人全部跑到终点，
 *         大家才能开喝，否则只能全等着。
 * @author CyclicBarrier可以在构造函数中设定总计数值。与 CountDownLatch 不同的是，CyclicBarrier
 *         的构造函数还可以接受一个 Runnable，会在 CyclicBarrier 被释放时执行。
 */

public class CyclicBarrierTest {
	public static void main(String[] args) {
		final int count = 5;
		final CyclicBarrier barrier = new CyclicBarrier(count, new Runnable() {
			@Override
			public void run() {
				System.out.println("drink beer!");
			}
		});

		for (int i = 0; i < count; i++) {
			new Thread(new Worker1(i, barrier)).start();
		}
		System.out.println("===========");
	}
}

class Worker1 implements Runnable {
	final int id;
	final CyclicBarrier barrier;

	public Worker1(int id, CyclicBarrier barrier) {
		super();
		this.id = id;
		this.barrier = barrier;
	}

	@Override
	public void run() {
		System.out.println(this.id + "starts to run !");
		try {
			Thread.sleep((long) (Math.random() * 10000));
			System.out.println(this.id + "arrived !");
			System.out.println("num:" + this.barrier.getNumberWaiting());

			// 在所有参与者都已经在此 barrier 上调用 await 方法之前，将一直等待。
			this.barrier.await();
			System.out.println("等待");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}