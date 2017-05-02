package com.qjs.yonth.design.factory.abstractFy;

public class client {
	public static void main(String[] args) {
		CarFactory low = new LuxuryCarFactory();
		LuxuryEngine engine = (LuxuryEngine) low.createEngine();
		engine.start();
	}
}
