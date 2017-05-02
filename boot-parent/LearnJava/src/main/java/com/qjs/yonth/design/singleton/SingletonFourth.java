package com.qjs.yonth.design.singleton;

/**
 *  静态内部类式
 *  兼备并发高效 ，延时加载的优势 并且线程安全
 * @author qianjs163@163.com
 *
 */
public class SingletonFourth {
	
	private static class SingletonInstance{
		private static final SingletonFourth s=new SingletonFourth();
	}

	private SingletonFourth() {
		super();
	}
	
	public static SingletonFourth getInstance(){
		return SingletonInstance.s;
	}
	
}
