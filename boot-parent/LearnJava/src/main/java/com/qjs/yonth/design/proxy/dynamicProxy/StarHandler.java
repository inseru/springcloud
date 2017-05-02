package com.qjs.yonth.design.proxy.dynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

import com.qjs.yonth.design.proxy.staticProxy.Star;

/**
 * 实现处理器接口， ● 可以通过invoke方法实现对真实角色的代理访问。 ● 每次通过proxy生成代理类对象时都要指定对应的处理器对象
 * 
 * @author qianjs163@163.com
 *
 * @since 2017年3月12日
 */
public class StarHandler implements InvocationHandler {
	private Star star;

	public StarHandler(Star star) {
		super();
		this.star = star;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println(star.getClass());
		System.out.println(this.getClass());
		System.out.println(proxy.getClass());
		System.out.println("=====");
		System.out.println(method.getName());
		method.invoke(star, args);
		return null;
	}

}
