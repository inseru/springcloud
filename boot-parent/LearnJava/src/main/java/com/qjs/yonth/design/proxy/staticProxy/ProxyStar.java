package com.qjs.yonth.design.proxy.staticProxy;

/**
 * 代理角色
 * 
 * @author qianjs163@163.com
 *
 * @since 2017年3月12日
 */
public class ProxyStar implements Star {

	private Star star;

	public ProxyStar(Star star) {
		super();
		this.star = star;
	}

	@Override
	public void sing() {
		star.sing();
	}

	@Override
	public void bookTicket() {
		System.out.println("proxy.bookTicket");

	}

	@Override
	public void signContract() {
		System.out.println("proxy.signContract");

	}

}
