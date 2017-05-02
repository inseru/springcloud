package com.qjs.boot.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import io.swagger.annotations.ApiOperation;

@Controller
@RequestMapping("/test")
public class HelloController {
	private Logger log = LoggerFactory.getLogger(this.getClass());

	@RequestMapping(value = "/id2", method = RequestMethod.GET)
	public String hello(@RequestParam(value="id") String id,@RequestParam(value="name") String name) {
	//	model.addAttribute("hello", "helloWorld");
		System.out.println(id);
		System.out.println(name);
		return "/demo1/fenxiang";
	}
	
	
	@RequestMapping(value = "/id", method = RequestMethod.GET)
	public String hello() {

		return "/demo1/a";
	}
}
