package com.qjs.boot.Controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloController {

	@RequestMapping(value = "/h2/{id}", method = RequestMethod.GET)
	public String hello2(@PathVariable(value = "id") String id) throws Exception {
		System.out.println("id" + id);
		// s sender.run(id);
		return id;
	}

}
