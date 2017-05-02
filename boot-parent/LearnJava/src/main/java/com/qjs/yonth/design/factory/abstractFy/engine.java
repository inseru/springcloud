package com.qjs.yonth.design.factory.abstractFy;

public interface engine {
	void start();
}

class lowEngine implements engine {

	@Override
	public void start() {
		System.out.println("慢");
	}

}

class LuxuryEngine implements engine {

	@Override
	public void start() {
		System.out.println("快");
	}

}