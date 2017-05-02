package com.qjs.yonth.design.factory.simple;

public class CarFactory2 {
	public static Car createBmw() {
		return new Bmw();
	}

	public static Car createByd() {
		return new Byd();
	}
}
