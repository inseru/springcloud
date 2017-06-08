package com.qjs.boot.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

@Component
public class MessageConsumer {
	private Logger log = LoggerFactory.getLogger(this.getClass());

	@JmsListener(destination = "test1")
	@SendTo("test2")
	public String receivedQueue(String msg) {
		System.err.println("Has received from test1:" + " msg: " + msg);
		return "test2";
	}

	// @JmsListener(destination = "test2")
	// public void receivedQueue2(String msg) {
	// System.err.println("Has received from test2:" + " msg: " + msg);
	// }

}
