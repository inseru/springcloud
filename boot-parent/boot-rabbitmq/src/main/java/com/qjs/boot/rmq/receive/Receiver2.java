package com.qjs.boot.rmq.receive;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/*
	@RabbitListener(
        containerFactory = "simpleRabbitListenerContainerFactory",
        bindings = @QueueBinding(
                value = @Queue(value = "testDirectQueue1",durable = "true"),
                exchange = @Exchange(value = "testDirectExchange",type = ExchangeTypes.DIRECT),
                key = "key1")
 */
@Component
@RabbitListener(queues = { "spring.web" })
public class Receiver2 {

	@RabbitHandler
	public void process(String hello) {
		System.out.println("Receiver2: " + hello);
	}
}
