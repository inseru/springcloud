package com.qjs.yonth.java.javassist;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import javassist.CannotCompileException;
import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;
import javassist.NotFoundException;

public class Demo2 {
	/**
	 * 测试类的基本用法
	 * 
	 * @author qianjs163@163.com 2017年3月19日下午5:29:33
	 * @throws CannotCompileException
	 * @throws IOException
	 * @throws NotFoundException
	 */
	public static void test1() throws IOException, CannotCompileException, NotFoundException {
		ClassPool pool = ClassPool.getDefault();
		CtClass c = pool.makeClass("com.qjs.yonth.java.javassist.User");
		byte[] bs = c.toBytecode();
		System.out.println(c.getName());// 类名
		System.out.println(c.getSuperclass());// 父类
		System.out.println(c.getInterfaces());// 接口
	}

	public static void main(String[] args) throws IOException, CannotCompileException, NotFoundException,
			InstantiationException, IllegalAccessException, NoSuchMethodException, SecurityException,
			IllegalArgumentException, InvocationTargetException {
		test2();
	}

	/**
	 * 测试方法
	 * 
	 * @author qianjs163@163.com 2017年3月19日下午9:56:32
	 * @throws CannotCompileException
	 * @throws IllegalAccessException
	 * @throws InstantiationException
	 * @throws SecurityException
	 * @throws NoSuchMethodException
	 * @throws InvocationTargetException
	 * @throws IllegalArgumentException
	 */
	public static void test2() throws CannotCompileException, InstantiationException, IllegalAccessException,
			NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
		ClassPool pool = ClassPool.getDefault();
		CtClass c = pool.makeClass("com.qjs.yonth.java.javassist.User");
		CtMethod cm = new CtMethod(CtClass.intType, "add", new CtClass[] { CtClass.intType, CtClass.intType }, c);
		cm.setModifiers(Modifier.PUBLIC);
		cm.setBody("{System.out.println(\"qqq\");return  $1+$2;}");
		c.addMethod(cm);

		// 通过反射调用新生成的方法
		Class c1 = c.toClass();
		Object obj = c1.newInstance();
		Method m = c1.getDeclaredMethod("add", int.class, int.class);
		m.invoke(obj, 1, 2);
	}
}
