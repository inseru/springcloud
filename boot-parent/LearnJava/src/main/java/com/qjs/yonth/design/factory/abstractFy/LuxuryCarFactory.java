package com.qjs.yonth.design.factory.abstractFy;

public class LuxuryCarFactory implements CarFactory {

	@Override
	public engine createEngine() {
		return new LuxuryEngine();
	}

	@Override
	public seat createSeat() {
		return new LuxurySeat();
	}

}
