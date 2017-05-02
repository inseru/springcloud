package com.qjs.yonth.java.javassist;

import java.io.IOException;

import javassist.CannotCompileException;
import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtConstructor;
import javassist.CtField;
import javassist.CtMethod;
import javassist.NotFoundException;

/**
 * 使用javassist生成一个新的类
 * 
 * @author qianjs163@163.com 2017年3月19日下午4:52:32
 *
 */
public class Demo1 {
	public static void main(String[] args) throws CannotCompileException, NotFoundException, IOException {
		ClassPool pool = ClassPool.getDefault();
		CtClass c = pool.makeClass("com.qjs.yonth.java.javassist.User");

		// 创建属性
		CtField cf1 = CtField.make("private int age;", c);
		CtField cf2 = CtField.make("private String name;", c);
		c.addField(cf1);
		c.addField(cf2);
		// 创造方法
		CtMethod cm1 = CtMethod.make("public String getName(){return name;}", c);
		c.addMethod(cm1);
		// 添加构造器
		CtConstructor cc = new CtConstructor(new CtClass[] { CtClass.intType, pool.get("java.lang.String") }, c);
		cc.setBody("{this.age=age;this.name=name;}");
		c.addConstructor(cc);
		c.writeFile("e:/");
	}
}
