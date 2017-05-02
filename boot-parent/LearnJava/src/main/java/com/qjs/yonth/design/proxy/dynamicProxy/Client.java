package com.qjs.yonth.design.proxy.dynamicProxy;

import java.lang.reflect.Proxy;

import com.qjs.yonth.design.proxy.staticProxy.RealStar;
import com.qjs.yonth.design.proxy.staticProxy.Star;

public class Client {
	public static void main(String[] args) {
		Star star = new RealStar();
		StarHandler handler = new StarHandler(star);
		Star proxy = (Star) Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(), new Class[] { Star.class },
				handler);
		proxy.bookTicket();
		proxy.sing();
	}
}
