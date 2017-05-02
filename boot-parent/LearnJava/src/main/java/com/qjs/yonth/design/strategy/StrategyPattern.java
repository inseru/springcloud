package com.qjs.yonth.design.strategy;

import org.junit.Test;

/**
 * 策略模式 这是验证类
 * 
 * @author Administrator
 *
 */
public class StrategyPattern extends character {

	@Test
	public void test1() {
		StrategyPattern sp = new StrategyPattern();
		sp.fight();
		sp.setWp(new SwordBehavior());
		sp.useWeaPon();
	}
}
