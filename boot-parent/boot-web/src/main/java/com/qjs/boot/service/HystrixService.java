package com.qjs.boot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

@Service
public class HystrixService {

	@Autowired
	private ServiceA serviceA;

	@HystrixCommand(groupKey = "service", commandKey = "service", threadPoolKey = "service", fallbackMethod = "back", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "5000") })
	public String test1(String id) throws InterruptedException {
		System.out.println("1");
		// Thread.currentThread().sleep(3000);
		System.out.println(serviceA.hello(id));
		System.out.println("2");
		return "ok";
	}

	public String back(String id) {
		return "error";
	}
}
