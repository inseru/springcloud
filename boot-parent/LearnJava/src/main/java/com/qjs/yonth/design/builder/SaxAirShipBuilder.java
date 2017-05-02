package com.qjs.yonth.design.builder;

public class SaxAirShipBuilder implements AirShipBuilder {

	public Engine engineBuilder() {
		System.out.println("构建发送机");
		return new Engine("a");
	}

	public Seat seatBuilder() {
		System.out.println("构建座椅");
		return new Seat("b");
	}

}
