package com.qjs.boot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.qjs.boot.producer.MessageProducer;

@RestController
@RequestMapping("/message")
public class MessageController {
	@Autowired
	private MessageProducer messageProducer;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public String hello(@PathVariable(value = "id") String id) throws InterruptedException {
		System.out.println("id" + id);
		messageProducer.send(id);
		return id;
	}
}
