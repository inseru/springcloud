package com.qjs.yonth.design.singleton;

/**
 * 双重检测锁(有问题)
 * 
 * @author qianjs163@163.com
 *
 */
public class SingletonThird {
	
	private static SingletonThird s=null;

	public SingletonThird() {
		super();
	}
	
	public static SingletonThird getInstance(){
		if(s==null){
			SingletonThird instance;
			synchronized (SingletonThird.class) {
				instance=s;
				if(instance==null){
					synchronized (SingletonThird.class) {
						if(instance ==null){
							instance =new SingletonThird();
							
						}
					}
					s= instance;
				}
			}
			
		}
		return s;
	}
	
}
