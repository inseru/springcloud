package com.qjs.yonth.java.nettty.helloworld;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

public class Server {
	public static void main(String[] args) throws InterruptedException {
		EventLoopGroup pGroup = new NioEventLoopGroup(); // 处理客户端连接
		EventLoopGroup cGroup = new NioEventLoopGroup(); // 进行网络通信（网络读写）
		// 辅助工具类，用于服务器通信的一系列配置
		ServerBootstrap b = new ServerBootstrap();
		b.group(pGroup, cGroup)// 绑定线程组
				.channel(NioServerSocketChannel.class)// 指定NIO模式
				.option(ChannelOption.SO_BACKLOG, 1024) // 设置tcp缓冲区
				.option(ChannelOption.SO_SNDBUF, 32 * 1024) // 设置发送缓冲区大小
				.option(ChannelOption.SO_RCVBUF, 32 * 1024) // 设置接收缓冲区大小
				.option(ChannelOption.SO_KEEPALIVE, true) // 保持连接
				.childHandler(new ChannelInitializer<SocketChannel>() {
					// 配置数据处理
					@Override
					protected void initChannel(SocketChannel ch) throws Exception {
						// TODO Auto-generated method stub
						ch.pipeline().addLast(new ServerHandler());
					}
				});
		ChannelFuture cf1 = b.bind(8765).sync();// 进行绑定

		cf1.channel().closeFuture().sync();// 等待关闭
		pGroup.shutdownGracefully(); // 关闭线程组
		cGroup.shutdownGracefully();
	}
}
