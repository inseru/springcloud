package com.qjs.boot.wx.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.qjs.boot.wx.service.CoreService;
import com.qjs.wx.course.util.SignUtil;

@RestController
@RequestMapping("wx")
public class WxMessageController {
	private Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private CoreService CoreService;

	/**
	 * 确认请求来自微信服务器
	 */
	@RequestMapping(value = "login", method = RequestMethod.GET)
	public String doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		log.error("---doGet-Start---");
		// 微信加密签名
		String signature = request.getParameter("signature");
		// 时间戳
		String timestamp = request.getParameter("timestamp");
		// 随机数
		String nonce = request.getParameter("nonce");
		// 随机字符串
		String echostr = request.getParameter("echostr");

		// PrintWriter out = response.getWriter();
		// 通过检验signature对请求进行校验，若校验成功则原样返回echostr，表示接入成功，否则接入失败
		if (SignUtil.checkSignature(signature, timestamp, nonce)) {
			return echostr;
		}
		return null;
	}

	/**
	 * 处理微信服务器发来的消息
	 */
	@RequestMapping(value = "login", method = RequestMethod.POST)
	public String doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		log.error("---doPost-Start---");
		// 将请求、响应的编码均设置为UTF-8（防止中文乱码）
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");

		// 调用核心业务类接收消息、处理消息
		String respMessage = CoreService.processRequest(request);

		// 响应消息
		// PrintWriter out = response.getWriter();
		return respMessage;
	}
}
