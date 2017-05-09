package com.qjs.boot.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/test")
public class HelloController {
	private Logger log = LoggerFactory.getLogger(this.getClass());

	@RequestMapping(value = "/id2", method = RequestMethod.GET)
	public String hello(@RequestParam(value = "id") String id, @RequestParam(value = "name") String name) {
		// model.addAttribute("hello", "helloWorld");
		System.out.println(id);
		System.out.println(name);
		return "/demo1/fenxiang";
	}

	@RequestMapping(value = "/id", method = RequestMethod.GET)
	public String hello() {
		try {
			Thread.currentThread().sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "/demo1/a";
	}
}
