package com.qjs.yonth.java.thread;

/**
 * 线程死锁实例
 * 
 * @author Administrator
 *
 */
public class DeadThread {
	public static void main(String[] args) {
		A a = new A();
		B b = new B(a);
		a.setB(b);
		Thread t1 = new Thread(a);
		Thread t2 = new Thread(b);
		t1.start();
		t2.start();
	}
}

class A implements Runnable {
	private B b;

	public B getB() {
		return b;
	}

	public void setB(B b) {
		this.b = b;
	}

	@Override
	public void run() {
		synchronized (this) {
			System.out.println("调用a的run方法");
			try {
				Thread.currentThread().sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			b.write();
		}
	}

	public void write() {
		synchronized (this) {
			System.out.println("调用a的write方法");
		}
	}

}

class B implements Runnable {

	private A a;

	public B(A a) {
		super();
		this.a = a;
	}

	@Override
	public void run() {
		synchronized (this) {
			System.out.println("调用b的run方法");
			a.write();
		}
	}

	public void write() {
		synchronized (this) {
			System.out.println("调用b的wirtr方法");
		}
	}

}