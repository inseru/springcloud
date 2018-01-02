package com.qjs.yonth.java.nettty.helloworld;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;

public class ServerHandler extends ChannelHandlerAdapter {

	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
		ByteBuf buf = (ByteBuf) msg;
		byte[] req = new byte[buf.readableBytes()];
		buf.readBytes(req);
		String body = new String(req, "utf-8");
		System.err.println("server:" + body);
		// 服务端响应
		String resp = "hello world";
		ctx.writeAndFlush(Unpooled.copiedBuffer(resp.getBytes()));
		// super.channelRead(ctx, msg);
	}

	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
		// TODO Auto-generated method stub
		// super.exceptionCaught(ctx, cause);
		ctx.close();
	}

}
