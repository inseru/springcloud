package com.qjs.yonth.java.annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

public class client {
	public static void main(String[] args) {
		try {
			Class c = Class.forName("com.qjs.yonth.java.annotation.TestAnnotation");
			Annotation[] a = (Annotation[]) c.getAnnotations();
			for (Annotation s : a) {
				MyFirstAnnotation m = (MyFirstAnnotation) s;
				System.out.println(m.id());
				System.out.println(m.name());
			}
			MyFirstAnnotation m1 = (MyFirstAnnotation) c.getAnnotation(MyFirstAnnotation.class);
			System.out.println(m1.id());

			Field f = c.getDeclaredField("age");
			MyFirstAnnotation m2 = (MyFirstAnnotation) f.getAnnotation(MyFirstAnnotation.class);
			System.out.println(m2.name());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
