package com.qjs.boot.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.qjs.wx.course.util.SignUtil;

import io.swagger.annotations.ApiOperation;

/**
 * 
 * @author qianjs163@163.com
 *
 * @date 2017年2月4日
 */
@RestController
@RequestMapping("/chat")
public class WxChatController {
	private Logger log = LoggerFactory.getLogger(this.getClass());

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
}
