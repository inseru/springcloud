package com.qjs.yonth.java.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import com.alibaba.fastjson.JSON;

/**
 * 应用反射API,获取类的信息（类的名字，方法，属性，构造器等）
 * 
 * @author qianjs163@163.com
 *
 * @since 2017年3月12日
 */
public class Demo1 {
	public static void main(String[] args)
			throws ClassNotFoundException, NoSuchFieldException, SecurityException, NoSuchMethodException {

		Class c = Class.forName("com.qjs.yonth.poi.User");
		// 获取类的名字
		System.out.println(c.getName());
		System.out.println(c.getSimpleName());// 类名，不包括包

		// 获取属性信息
		Field[] fs = c.getFields(); // 只支持public
		System.out.println(JSON.toJSONString(fs));
		Field[] fs2 = c.getDeclaredFields(); // 获取所有声明的属性
		// System.out.println(JSON.toJSONString(fs2));
		Field f = c.getDeclaredField("id");
		System.out.println(f);

		// 获取方法信息
		Method[] ms = c.getDeclaredMethods();
		Method m = c.getDeclaredMethod("getName", null);// 第二个参数传递参数类型对应的class
		// System.out.println(JSON.toJSONString(ms));

		// 获取构造
		Constructor[] con = c.getDeclaredConstructors();
		Constructor con1 = c.getDeclaredConstructor(int.class, String.class, String.class, String.class);

	}
}
