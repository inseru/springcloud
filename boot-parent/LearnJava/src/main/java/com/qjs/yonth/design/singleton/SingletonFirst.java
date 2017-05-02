package com.qjs.yonth.design.singleton;

/**
 * 饿汉式
 * 
 * @author qianjs163@163.com
 *
 */
public class SingletonFirst {
	
	/**
	 * 类初始化时，立即加载 （可能资源永远不会访问，浪费）
	 */
	private static SingletonFirst s=new SingletonFirst();

	private SingletonFirst() {
		super();
	}
	
	/**
	 * 不需要加同步锁  ，因为对象的初始化，在类的初始化时完成，天然线程安全（基于加载机制）
	 * 方法不加锁，效率更高
	 * @return
	 */
	public static SingletonFirst getInstance(){
		return s;
	};
	
	
}
