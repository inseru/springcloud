package com.qjs.yonth.design.factory.method;

import com.qjs.yonth.design.factory.simple.Byd;
import com.qjs.yonth.design.factory.simple.Car;

/**
 * 工厂方法模式 ，
 * 
 * @author qianjs163@163.com
 *
 */
public class BydFactory implements CarFactory {

	@Override
	public Car createCar() {
		// TODO Auto-generated method stub
		return new Byd();
	}

}
