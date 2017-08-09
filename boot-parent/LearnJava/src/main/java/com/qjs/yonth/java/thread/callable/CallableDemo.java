package com.qjs.yonth.java.thread.callable;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * Callable+Future/FutureTask获取多线程运行的结果
 * 
 * @author Administrator
 *
 */
public class CallableDemo {

	public static void main(String[] args) {
		thread1 d = new thread1();
		FutureTask<Object> ft = new FutureTask<>(d);
		Thread t = new Thread(ft);
		t.start();
		try {
			System.out.println(ft.isCancelled());
			System.out.println(ft.isDone());
			// ft.cancel(true);
			Object a = ft.get(); // 计算完成前会阻塞
			if (a instanceof Integer) {
				System.out.println(a);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("======");
	}
}

class thread1 implements Callable<Object> {

	@Override
	public Object call() throws Exception {
		int sum = 0;

		for (int i = 0; i <= 100000; i++) {
			sum += i;
		}
		System.out.println("111");
		Thread.currentThread().sleep(1000);
		System.out.println("2222");
		return sum;
	}

}