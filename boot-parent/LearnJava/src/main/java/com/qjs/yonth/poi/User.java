package com.qjs.yonth.poi;

import com.qjs.yonth.poi.util.ExecelOrder;

public class User {

	private int id;
	private String name;
	private String age;
	private String socre;

	@ExecelOrder(title = "id", order = 1)
	public int getId() {
		return id;
	}

	public User() {
	}

	public User(int id, String name, String age, String socre) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.socre = socre;
	}

	public void setId(int id) {
		this.id = id;
	}

	@ExecelOrder(title = "姓名", order = 2)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@ExecelOrder(title = "年龄", order = 3)
	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	@ExecelOrder(title = "爱好", order = 4)
	public String getSocre() {
		return socre;
	}

	public void setSocre(String socre) {
		this.socre = socre;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", age=" + age + ", socre=" + socre + "]";
	}

}
