package com.qjs.yonth.design.strategy;

/**
 * 英雄
 * 
 * @author Administrator
 *
 */
public abstract class character {

	private WeaPon wp;

	public void fight() {
		System.out.println("都是战斗种族");
	}

	public WeaPon getWp() {
		return wp;
	}

	public void setWp(WeaPon wp) {
		this.wp = wp;
	};

	public void useWeaPon() {
		wp.useWeaPon();
	}

}
