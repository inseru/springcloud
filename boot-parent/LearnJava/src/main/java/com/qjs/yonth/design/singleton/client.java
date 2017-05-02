package com.qjs.yonth.design.singleton;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * 测试反序列和反射破解单例模式
 * 
 * @author qianjs163@163.com
 *
 */
public class client {

	public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, SecurityException,
			InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {

		clientTest s = clientTest.getInstance();

		Class<clientTest> test = (Class<clientTest>) Class.forName("com.qjs.yonth.design.singleton.clientTest");
		Constructor<clientTest> c = test.getDeclaredConstructor(null);
		// 忽略私有成员变量，访问权限
		c.setAccessible(true);
		clientTest t = c.newInstance();
		clientTest t1 = c.newInstance();
		System.out.println(t);
		System.out.println(t1);
		
	}

}