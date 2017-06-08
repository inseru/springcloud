package com.qjs.boot.producer;

import java.util.HashMap;
import java.util.Map;

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
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("as", 12);
		map.put("33s", "sfs");
		this.jmsMessagingTemplate.convertAndSend(this.logQueue, map);
	}
}
