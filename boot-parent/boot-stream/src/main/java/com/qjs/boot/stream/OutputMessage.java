package com.qjs.boot.stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.MessageChannel;
import org.springframework.stereotype.Component;

@Component
@EnableBinding(Source.class)
public class OutputMessage {

	@Autowired
	@Qualifier(Source.OUTPUT)
	MessageChannel output;

	public void run(String... strings) throws Exception {
		System.out.println("send:" + strings[0] + strings[1]);
		output.send(MessageBuilder.withPayload(strings[0] + strings[1]).build());
	}

}
