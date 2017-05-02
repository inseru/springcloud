package com.qjs.yonth.java.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import com.qjs.yonth.poi.User;

/**
 * 通过反射API,动态操作 属性，方法，构造器
 * 
 * @author qianjs163@163.com
 *
 * @since 2017年3月12日
 */
public class Demo2 {
	public static void main(String[] args) throws Exception {
		Class c = Class.forName("com.qjs.yonth.poi.User");
		User u1 = (User) c.newInstance();// 通过无参创建
		// 动态操作构造器
		Constructor<User> constr = c.getDeclaredConstructor(int.class, String.class, String.class, String.class);
		User u2 = constr.newInstance(1, "1", "2", "4");
		System.out.println(u2);

		// 通过反射API调用普通方法
		User u3 = (User) c.newInstance();
		Method m = c.getDeclaredMethod("setId", int.class);
		m.invoke(u3, 1);

		// 通过反射操作属性
		User u4 = (User) c.newInstance();
		Field f = c.getDeclaredField("id");
		f.setAccessible(true);// 可以访问私有属性，回避安全检查
		f.set(u4, 5); // 通过反射直接写属性
		System.out.println(u4);
		System.out.println(f.get(u4)); // 通过反射直接读属性
	}
}
