package com.qjs.yonth.design.singleton;

/**
 * 懒汉式 （懒加载）
 * 
 * @author qianjs163@163.com
 *
 */
public class SingletonSecond {
	/**
	 * 类初始化时，不创建对象，使用时加载
	 */
	private static SingletonSecond s;

	
	private SingletonSecond() {
		super();
	}
	
	/**
	 * 方法同步，并发效率低
	 * @return
	 */
	public static synchronized SingletonSecond getInstance(){
		if(s==null){
			s= new SingletonSecond();
		}
		return s;
	}
	
	
}
