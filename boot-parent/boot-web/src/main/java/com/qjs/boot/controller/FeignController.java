package com.qjs.boot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.qjs.boot.service.ServiceA;

@RestController
@RequestMapping("/service")
public class FeignController {

	@Autowired
	public ServiceA serviceA;

	@RequestMapping(value = "/demo1/{id}", method = RequestMethod.GET)
	public String helloConsumer(@PathVariable(value = "id") String id) {
		System.out.println(serviceA);
		long a = System.currentTimeMillis();
		System.out.println(serviceA.hello(id));
		System.out.println(System.currentTimeMillis() - a);
		return "a";
	}
}
