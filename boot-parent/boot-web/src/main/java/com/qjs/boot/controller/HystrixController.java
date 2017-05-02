package com.qjs.boot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.qjs.boot.service.HystrixService;
import com.qjs.boot.service.ServiceA;

@RestController
@RequestMapping("/hy")
public class HystrixController {
	@Autowired
	public ServiceA serviceA;

	@Autowired
	public HystrixService hystrixService;

	@RequestMapping(value = "/demo1/{id}", method = RequestMethod.GET)
	public String helloConsumer(@PathVariable(value = "id") String id) throws InterruptedException {
		long a = System.currentTimeMillis();
		String c = hystrixService.test1(id);
		System.out.println(System.currentTimeMillis() - a);
		return c;
	}

}
