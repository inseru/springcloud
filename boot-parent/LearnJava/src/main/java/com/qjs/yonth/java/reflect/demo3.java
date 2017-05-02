package com.qjs.yonth.java.reflect;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

public class demo3 {
	public void test01(Map<String,Object> map,List<String> list){
		System.out.println("test01");
	}
	
	public Map<String,Object> test02(){
		System.out.println("test2");
		return null;
	}
	
	public static void main(String[] args) throws NoSuchMethodException, SecurityException {
		//操作参数注解
		Method test01=demo3.class.getMethod("test01", Map.class,List.class);
		Type[] type=test01.getGenericParameterTypes();
		for(Type p:type){
			System.out.println(p);
			if(p instanceof ParameterizedType){
				Type[] g= ((ParameterizedType) p).getActualTypeArguments();
				for(Type a:g){
					System.out.println("注解信息："+a);
				}
				
			}
		}
		
		//操作返回值注解
		Method m=demo3.class.getMethod("test02");
		Type y=m.getGenericReturnType();
		if(y instanceof ParameterizedType){
			Type[] v= ((ParameterizedType) y).getActualTypeArguments();
			for(Type v2:v){
				System.out.println(v2);
			}
		}
	}
}
