package com.qjs.boot.wx.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.qjs.boot.dto.Response;
import com.qjs.boot.wx.service.WxService;
import com.qjs.wx.web.dto.WxJsApiAuth;

@RestController
@RequestMapping(value = "/wxAuth")
public class WxAuthController {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private WxService wxService;

	/**
	 * 获取jsSDk
	 * 
	 * @author qianjs163@163.com 2017年2月9日 下午2:59:14
	 * @return
	 */
	@RequestMapping(value = "/wx_js_sdk", method = RequestMethod.GET)
	public Response<WxJsApiAuth> getJsSdk(@RequestParam(value = "url", required = true) String url) {
		logger.info("---进入getJsSdk----");
		return new Response<WxJsApiAuth>(1, wxService.getWxJsApiAuth(url), null);
	}
}
