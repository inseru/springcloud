package com.qjs.yonth.design.proxy.staticProxy;

public class RealStar implements Star {

	@Override
	public void sing() {
		System.out.println("RealStar.sing");

	}

	@Override
	public void bookTicket() {
		System.out.println("RealStar.bookTicket");

	}

	@Override
	public void signContract() {
		System.out.println("RealStar.signContract");

	}

}
