package com.qjs.boot.wx.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.qjs.common.util.MD5Util;
import com.qjs.common.util.RandomNum;
import com.qjs.wx.course.util.WeiXinWebUtil;
import com.qjs.wx.web.dto.JsApiTicket;
import com.qjs.wx.web.dto.WxJsApiAuth;

@Service
public class WxService {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	/**
	 * 获取微信jsticket
	 * 
	 * @author qianjs163@163.com
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	public WxJsApiAuth getWxJsApiAuth(String jsUrl) {
		logger.info(":getWxJsApiAuth");
	//
		String token="56cNu730XfuPXf3aKa_ZeMgQSP5bsdMEk-l5VdMOE5jpVz88hEEecseCY8f6laDq83HfOO13EQlNlqenQG79nXRs2aTGQrYnOpisBFhwO4P_2vSPblQd1iT49zvcn1c1BZBeAAAOMO";
				JsApiTicket ticket = WeiXinWebUtil.getJsApiTicket(token);
		String jsApi = ticket.getTicket();
		String radom = RandomNum.createRandomString(20);
		long timestamp = System.currentTimeMillis();
		String m = "jsapi_ticket=" + jsApi + "&noncestr=" + radom + "&timestamp=" + timestamp + "&url=" + jsUrl;
		String signature = MD5Util.getSha1(m);
		WxJsApiAuth auth = new WxJsApiAuth();
		auth.setAppId("wx3b91e1c6c508000b");
		auth.setNonceStr(radom);
		auth.setSignature(signature);
		auth.setTimestamp(timestamp);
		return auth;
	}
	
}
