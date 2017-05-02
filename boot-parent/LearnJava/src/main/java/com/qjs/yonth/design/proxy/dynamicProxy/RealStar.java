package com.qjs.yonth.design.proxy.dynamicProxy;

/**
 * 真实角色
 * 
 * @author qianjs163@163.com
 *
 * @since 2017年3月12日
 */
public class RealStar implements Star {

	@Override
	public void sing() {
		System.out.println("RealStar.sing");

	}

	@Override
	public void bookTicket() {
		System.out.println("RealStar.bookTicket");

	}

	@Override
	public void signContract() {
		System.out.println("RealStar.signContract");

	}

}
