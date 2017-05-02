package com.qjs.boot.service;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

@Component
public class HelloServiceFallback implements ServiceA {

	@Override
	public String hello() {
		return "-1";
	}

	@Override
	public String hello(@RequestParam("name") String name) {
		return "error";
	}

}
