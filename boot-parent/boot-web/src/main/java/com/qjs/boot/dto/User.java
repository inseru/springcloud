package com.qjs.boot.dto;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

public class User {
	@Override
	public String toString() {
		return "User [name=" + name + ", age=" + age + ", birthDay=" + birthDay + "]";
	}

	@NotBlank(message = "姓名不能为空")
	@Length(max = 5, message = "姓名长度范围为5位字符")
	private String name;

	private Integer age;

	private String birthDay;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getBirthDay() {
		return birthDay;
	}

	public void setBirthDay(String birthDay) {
		this.birthDay = birthDay;
	}

}
