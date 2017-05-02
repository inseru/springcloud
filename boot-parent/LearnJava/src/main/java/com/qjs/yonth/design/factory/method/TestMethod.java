package com.qjs.yonth.design.factory.method;

import com.qjs.yonth.design.factory.simple.Car;

public class TestMethod {
	public static void main(String[] args) {
		CarFactory f = new BydFactory();
		Car car = f.createCar();
		System.out.println(car.toString());
	}
}
