package com.qjs.yonth.java.reflect;

public class TestReflect {
	public static void main(String[] args) throws ClassNotFoundException {
		String q = "121";

		// 对象是表示或封装一些信息，一个类被加载后，JVM会创建一个对应该类的class对象，
		// 类的整个结构信息会放到对应的Class对象中
		Class c = Class.forName("com.qjs.yonth.poi.User");
		System.out.println(c);
		Class c1 = String.class;
		Class c2 = q.getClass();

	}
}
