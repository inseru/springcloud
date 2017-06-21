package com.qjs.boot;

import com.alibaba.fastjson.JSON;
import com.corundumstudio.socketio.AckRequest;
import com.corundumstudio.socketio.Configuration;
import com.corundumstudio.socketio.SocketIOClient;
import com.corundumstudio.socketio.SocketIOServer;
import com.corundumstudio.socketio.listener.DataListener;

public class ChatLauncher {

	public static void main(String[] args) throws InterruptedException {

		Configuration config = new Configuration();
		config.setHostname("localhost");
		config.setPort(9092);

		final SocketIOServer server = new SocketIOServer(config);
		server.addEventListener("chatevent", ChatObject.class, new DataListener<ChatObject>() {
			@Override
			public void onData(SocketIOClient client, ChatObject data, AckRequest ackRequest) {
				// broadcast messages to all clients
				System.err.println(JSON.toJSONString(data));
				server.getBroadcastOperations().sendEvent("chatevent", data);
				ackRequest.sendAckData("server!", "yeah!");
			}
		});

		server.start();

		Thread.sleep(Integer.MAX_VALUE);

		server.stop();
	}

}
