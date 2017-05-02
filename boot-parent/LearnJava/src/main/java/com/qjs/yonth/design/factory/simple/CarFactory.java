package com.qjs.yonth.design.factory.simple;

/**
 * 简单工厂模式 （静态工厂模式）
 * 
 * @author qianjs163@163.com
 *
 */
public class CarFactory {

	public static Car createCar(String car) {
		if ("Byd".equals(car)) {
			return new Bmw();
		} else if ("Bmw".equals(car)) {
			return new Byd();
		} else {
			return null;
		}
	}
}
