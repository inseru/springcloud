package com.qjs.boot.config;

import javax.jms.Queue;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.jms.core.JmsMessagingTemplate;

@Configuration
public class ActiveConfig {
	@Autowired
	private Environment env;

	@Bean
	public Queue logQueue() {
		return new ActiveMQQueue("test1");
	}

	@Bean
	public ActiveMQConnectionFactory connectionFactory() {
		// 此链接信息可放入配置文件中
		return new ActiveMQConnectionFactory(env.getProperty("spring.activemq.user").trim(),
				env.getProperty("spring.activemq.password").trim(),
				env.getProperty("spring.activemq.broker-url").trim());
	}

	@Bean
	public JmsMessagingTemplate jmsMessagingTemplate(ActiveMQConnectionFactory connectionFactory) {
		return new JmsMessagingTemplate(connectionFactory);
	}
}
