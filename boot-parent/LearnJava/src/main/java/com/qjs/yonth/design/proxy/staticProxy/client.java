package com.qjs.yonth.design.proxy.staticProxy;

public class client {
	public static void main(String[] args) {
		Star star = new RealStar();
		Star proxy = new ProxyStar(star);
		proxy.bookTicket();
		proxy.sing();
	}
}
