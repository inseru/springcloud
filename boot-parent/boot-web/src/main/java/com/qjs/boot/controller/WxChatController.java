package com.qjs.boot.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.qjs.boot.wx.service.CoreService;
import com.qjs.wx.course.util.MessageUtil;
import com.qjs.wx.course.util.SignUtil;

import io.swagger.annotations.ApiOperation;

/**
 * 
 * @author qianjs163@163.com
 *
 * @date 2017年2月4日
 */
@RestController
@RequestMapping("/applet/chat")
public class WxChatController {
	private Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private CoreService CoreService;

	@RequestMapping(value = "/msg", method = RequestMethod.GET, produces = "application/json")
	@ApiOperation(value = "客服验证", notes = "测试微信小程序客服验证")
	public String loginWx(@RequestParam(value = "signature", required = true) String signature,
			@RequestParam(value = "timestamp", required = true) String timestamp,
			@RequestParam(value = "nonce", required = true) String nonce,
			@RequestParam(value = "echostr", required = true) String echostr) {
		log.info("login");
		if (SignUtil.checkSignature(signature, timestamp, nonce)) {
			return echostr;
		}
		return null;
	}

	/**
	 * 处理微信服务器发来的消息
	 * 
	 * @throws Exception
	 */
	@RequestMapping(value = "/msg", method = RequestMethod.POST)
	public String doPost(HttpServletRequest request, HttpServletResponse response) throws Exception {
		log.error("---doPost-Start---");
		// 将请求、响应的编码均设置为UTF-8（防止中文乱码）
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		// 微信加密签名
		String signature = request.getParameter("signature");
		String msg_signature = request.getParameter("msg_signature");
		// 时间戳
		String timestamp = request.getParameter("timestamp");
		// 随机数
		String nonce = request.getParameter("nonce");

		String encrypt_type = request.getParameter("encrypt_type");

		// 返回值
		String respMessage = "";

		if (encrypt_type == null || encrypt_type.equals("raw")) { // 不用加密
			if (SignUtil.checkSignature(signature, timestamp, nonce)) {
				// 调用核心业务类接收消息、处理消息
				respMessage = CoreService.processRequest(request);

			} else {
				respMessage = "check Error";
			}
		} else {// 需要加密
			Map<String, String> requestMap = MessageUtil.parseXmlCrypt(msg_signature, timestamp, nonce, request);
			log.info("requestMap" + requestMap);
			String Message = CoreService.processRequestMi(requestMap);
			// 小程序客服 直接回复
			// respMessage = MessageUtil.ecryptMsg(Message, timestamp, nonce);
			return "success";
		}
		log.info("respMessage:" + respMessage);
		return "success";
	}
}
