package com.qjs.yonth.java.annotation;

@MyFirstAnnotation(id = 1, name = "1")
public class TestAnnotation {
	@Deprecated
	public void test1() {

	}

	@MyFirstAnnotation(id = 2, name = "2")
	private String age;

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

}
