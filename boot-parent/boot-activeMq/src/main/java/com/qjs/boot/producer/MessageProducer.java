package com.qjs.boot.producer;

import javax.jms.Queue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Component;

@Component
public class MessageProducer {
	private Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private JmsMessagingTemplate jmsMessagingTemplate;

	@Autowired
	private Queue logQueue;

	public void send(String msg) {
		log.info("send-->" + msg);
		this.jmsMessagingTemplate.convertAndSend(this.logQueue, msg);
	}
}
