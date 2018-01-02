package com.qjs.yonth.java.nettty.helloworld;

import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

public class Client {

	public static void main(String[] args) throws InterruptedException {
		EventLoopGroup pGroup = new NioEventLoopGroup(); // 客户端连接
		Bootstrap b = new Bootstrap();
		b.group(pGroup).channel(NioSocketChannel.class)// 绑定线程组
				.handler(new ChannelInitializer<SocketChannel>() {

					@Override
					protected void initChannel(SocketChannel arg0) throws Exception {
						arg0.pipeline().addLast(new ClientHandler());

					}

				});
		ChannelFuture cf = b.connect("127.0.0.1", 8765).sync();
		cf.channel().writeAndFlush(Unpooled.copiedBuffer("hello".getBytes()));
		Thread.sleep(5000);
		cf.channel().closeFuture().sync();
	}

}
