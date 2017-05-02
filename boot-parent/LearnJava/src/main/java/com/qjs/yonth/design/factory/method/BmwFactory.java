package com.qjs.yonth.design.factory.method;

import com.qjs.yonth.design.factory.simple.Bmw;
import com.qjs.yonth.design.factory.simple.Car;

public class BmwFactory implements CarFactory {

	@Override
	public Car createCar() {
		// TODO Auto-generated method stub
		return new Bmw();
	}

}
