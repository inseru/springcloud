package com.qjs.yonth.design.singleton;

/**
 * 懒汉式 测试反序列和反射破解单例模式
 * 
 * @author qianjs163@163.com
 *
 */
public class clientTest {
	private static clientTest s;

	private clientTest() {
		// 防止基于反射的破解单例
		if (s != null) {
			throw new RuntimeException();
		}
	}

	public static synchronized clientTest getInstance() {
		if (s == null) {
			s = new clientTest();
		}
		return s;
	}

}
