package com.qjs.test;

import org.junit.Test;

import com.qjs.common.util.HttpClient;

public class NetworkTest {

	@Test
	public void test1() throws InterruptedException {
		Thread a = new Thread(new Runnable() {
			@Override
			public void run() {
				while (true) {
					try {
						System.out.println(HttpClient.sendGet("http://127.0.0.1:3325/hello/h2/aa", ""));
						Thread.currentThread().sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

			}
		});
		a.start();
		a.join();
	}
}
