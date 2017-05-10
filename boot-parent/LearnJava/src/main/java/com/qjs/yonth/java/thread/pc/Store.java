package com.qjs.yonth.java.thread.pc;

import java.util.ArrayList;
import java.util.List;

//当线程执行wait()时，会把当前的锁释放，然后让出CPU，进入等待状态。 被唤醒后，获取对象锁，继续执行后面的代码
//当执行notify/notifyAll方法时，会唤醒一个处于等待状态的线程，当前线程继续往下执行，
//直到执行完退出对象锁锁住的区域（synchronized修饰的代码块）后再释放锁。
public class Store {
	public List<App> list = new ArrayList<App>();

	public synchronized void add() {
		try {
			while (true) {
				int i = list.size();
				if (i >= 30) {
					this.wait(); // 同步锁对象进入对象等待池中
				}
				System.out.println(Thread.currentThread().getName() + "add-->" + i);
				list.add(new App("app-" + i, String.valueOf(i)));
				Thread.sleep(50);
				i = list.size();
				System.err.println(Thread.currentThread().getName() + "--" + i);
				if (i == 0) {
					this.notify();
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public synchronized void remove() {
		try {

			// while (true) {
			// int i = list.size();
			// if (i <= 0) {
			// this.wait();
			// }
			// System.out.println(Thread.currentThread().getName() + "remove-->"
			// + i);
			// list.remove(i - 1);
			// i = list.size();
			// System.err.println(Thread.currentThread().getName() + "--" + i);
			// Thread.sleep(50);
			// if (i > 0) {
			// this.notify();
			// }
			// }

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
