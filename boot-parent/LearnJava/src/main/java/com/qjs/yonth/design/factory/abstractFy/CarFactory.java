package com.qjs.yonth.design.factory.abstractFy;

/**
 * 抽象工厂模式
 * 
 * @author qianjs163@163.com
 *
 */
public interface CarFactory {
	engine createEngine();

	seat createSeat();
}
