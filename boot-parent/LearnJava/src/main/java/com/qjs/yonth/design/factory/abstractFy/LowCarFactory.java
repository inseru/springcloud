package com.qjs.yonth.design.factory.abstractFy;

public class LowCarFactory implements CarFactory {

	@Override
	public engine createEngine() {
		return new lowEngine();
	}

	@Override
	public seat createSeat() {
		return new lowSeat();
	}

}
