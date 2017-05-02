package com.qjs.yonth.design.factory.abstractFy;

public interface seat {
	void run();
}

class lowSeat implements seat {

	@Override
	public void run() {
		System.out.println("不舒服");
	}

}

class LuxurySeat implements seat {

	@Override
	public void run() {
		System.out.println("舒服");
	}

}