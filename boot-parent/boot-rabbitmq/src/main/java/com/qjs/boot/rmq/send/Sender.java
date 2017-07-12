package com.qjs.boot.rmq.send;

import java.util.Date;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Sender {
	@Autowired
	private RabbitTemplate rabbitTemplate;

	public void send(String id) {
		String context = "hello " + new Date();
		// 第一个参数表示交换机，第二个参数表示routing key，第三个参数即消息
		// this.rabbitTemplate.convertAndSend("hello", id);
		this.rabbitTemplate.convertAndSend("spring-boot-exchange", "spring.boot1", "test1");
		this.rabbitTemplate.convertAndSend("spring-boot-exchange", "spring.web", "test2");
		this.rabbitTemplate.convertAndSend("spring-boot-exchange", "qjs.web", "test3");
	}
}
