package com.qjs.boot.stream;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;

@EnableBinding(Sink.class)
public class InputMessage {
	// 监听 binding 为 Sink.INPUT 的消息
	@StreamListener(Sink.INPUT)
	public void input(Message<String> message) {
		System.out.println("一般监听收到：" + message);
		try {
			Thread.currentThread().sleep(10);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
