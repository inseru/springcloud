package com.qjs.boot.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.qjs.boot.stream.OutputMessage;

@RestController
@RequestMapping("/hello")
public class HelloController {

	@Autowired
	private OutputMessage sender;

	@RequestMapping(value = "/h2/{id}", method = RequestMethod.GET)
	public String hello2(@PathVariable(value = "id") String id) throws Exception {
		System.out.println("id" + id);
		sender.run(id, "1", "2");
		return id;
	}

}
