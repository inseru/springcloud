package com.qjs.yonth.java.thread.pc;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * jdk5 使用lock替换synchronized
 * 
 * 只能在锁内调用
 * 
 * @author Administrator
 *
 */
public class Store {
	public List<App> list = new ArrayList<App>();

	private final Lock lock = new ReentrantLock();
	private Condition conditon = lock.newCondition();

	private final Lock lock2 = new ReentrantLock();
	private Condition conditon2 = lock2.newCondition();

	public void add() {
		try {

			while (true) {
				lock.lock();
				int i = list.size();
				if (i >= 30) {
					conditon.await(100, TimeUnit.MICROSECONDS);
				}
				System.out.println(Thread.currentThread().getName() + "add-->" + i);
				if (i < 30) {
					list.add(new App("app-" + i, String.valueOf(i)));
				}
				System.err.println(Thread.currentThread().getName() + "--" + i);

				Thread.sleep(50);
				// i = list.size();
				// System.err.println(Thread.currentThread().getName() + "--" +
				// i);
				// if (i == 0) {
				// conditon.signal();
				// }
				lock.unlock();
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}

	}

	public void remove() {
		try {
			while (true) {
				lock.lock();
				int i = list.size();
				if (i <= 0) {
					conditon.await(100, TimeUnit.MICROSECONDS);
				}
				System.out.println(Thread.currentThread().getName() + "remove-->" + i);
				if (i > 0) {
					list.remove(i - 1);
				}
				System.err.println(Thread.currentThread().getName() + "--" + i);

				Thread.sleep(50);
				// i = list.size();
				// if (i > 0) {
				// conditon.signal();
				// }
				lock.unlock();
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// lock.unlock();
		}
	}
}
