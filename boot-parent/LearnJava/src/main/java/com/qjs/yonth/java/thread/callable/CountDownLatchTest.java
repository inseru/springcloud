package com.qjs.yonth.java.thread.callable;

import java.util.concurrent.CountDownLatch;

/**
 * 五个人跑步的例子
 * 
 * @author :CountDownLatch强调的是一个线程（或多个）需要等待另外的n个线程干完某件事情之后才能继续执行。
 *         上述例子，main线程是裁判，5个AWorker是跑步的。运动员先准备，裁判喊跑，运动员才开始跑
 *         （这是第一次同步，对应begin）。5个人谁跑到终点了，countdown一下，直到5个人全部到达，
 *         裁判喊停（这是第二次同步，对应end），然后算时间。
 * 
 */

// CountDownLatch构造方法参数指定了计数的次数。
// awaint方法，调用此方法会一直阻塞当前线程，直到计时器的值为0。
// countDown方法，当前线程调用此方法，则计数减一
public class CountDownLatchTest {
	public static void main(String[] args) {
		final int num = 5;
		// CountDownLatch构造方法参数指定了计数的次数。
		final CountDownLatch begin = new CountDownLatch(1);
		final CountDownLatch end = new CountDownLatch(num);
		for (int i = 0; i < num; i++) {
			new Thread(new Worker(i, begin, end)).start();
		}

		try {
			Thread.sleep((long) (Math.random() * 1000));
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		System.out.println("judge say : run !");
		// countDown方法，当前线程调用此方法，则计数减一
		// 启动工作线程
		begin.countDown();

		long startTime = System.currentTimeMillis();
		try {
			// 阻塞当前线程，直到end计数器为0
			// 阻塞，直到工作线程都结束
			end.await();
			long endTime = System.currentTimeMillis();
			System.out.println("spend time: " + (endTime - startTime));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

class Worker implements Runnable {
	final CountDownLatch begin;
	final CountDownLatch end;
	final int id;

	public Worker(int id, CountDownLatch begin, CountDownLatch end) {
		super();
		this.begin = begin;
		this.end = end;
		this.id = id;
	}

	@Override
	public void run() {
		try {
			System.out.println(this.id + " ready !");
			begin.await();
			// 工作随机数
			Thread.sleep((long) (Math.random() * 1000));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(this.id + " arrived !");
		end.countDown();
		System.out.println(this.id + "hold !");
	}

}