package com.qjs.wx.course.util;

import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;
import com.qjs.common.util.HttpClient;
import com.qjs.wx.web.dto.JsApiTicket;
import com.qjs.wx.web.dto.UserInfo;
import com.qjs.wx.web.dto.WebMessage;

import net.sf.json.JSONObject;

/**
 * 微信网页测试工具
 * 
 * @author Administrator
 *
 */
public class WeiXinWebUtil {
	private static Logger log = LoggerFactory.getLogger(WeiXinWebUtil.class);

	// 获取code后，请求以下链接获取access_token以及openiD
	private static String url = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=APPID&secret=SECRET&code=CODE&grant_type=authorization_code";
	// 拉取用户信息(需scope为 snsapi_userinfo)
	private static String userInfo_url = "https://api.weixin.qq.com/sns/userinfo?access_token=ACCESS_TOKEN&openid=OPENID&lang=zh_CN";

	/**
	 * 通过code获取openId
	 */
	public static WebMessage getUserMessage(String code, String appid, String appsecret) {
		WebMessage mess = null;
		String requestUrl = url.replace("APPID", appid).replace("SECRET", appsecret).replace("CODE", code);
		JSONObject jsonObject = WeixinUtil.httpRequest(requestUrl, "GET", null);
		String s = jsonObject.toString();
		log.error("jsonObject:" + s);
		if (jsonObject != null) {
			try {
				ObjectMapper mapper = new ObjectMapper();
				mess = mapper.readValue(jsonObject.toString(), WebMessage.class);
				// mess=(WebMessage)
				// JSONObject.toBean(jsonObject,WebMessage.class);
			} catch (Exception e) {
				log.error("获取openid失败: code:" + jsonObject.getString("errcode") + ", mess:"
						+ jsonObject.getString("errmsg"));
			}
		}
		return mess;
	}

	/**
	 * 拉取用户信息(需scope为 snsapi_userinfo)
	 */
	public static UserInfo getUserInfo(String ACCESS_TOKEN, String openid) {
		UserInfo user = null;
		String requestUrl = userInfo_url.replace("OPENID", openid).replace("ACCESS_TOKEN", ACCESS_TOKEN);
		JSONObject jsonObject = WeixinUtil.httpRequest(requestUrl, "GET", null);
		String s = jsonObject.toString();
		log.error("jsonObject:" + s);
		if (jsonObject != null) {
			try {
				user = new UserInfo();
				user.setCity(jsonObject.getString("city"));
				user.setCountry(jsonObject.getString("country"));
				user.setHeadimgurl(jsonObject.getString("headimgurl"));
				user.setNickname(jsonObject.getString("nickname"));
				user.setOpenid(jsonObject.getString("openid"));
				user.setSex(jsonObject.getString("sex"));
			} catch (Exception e) {
				log.error("获取userInfo失败！ code:" + jsonObject.getString("errcode") + ", mess:"
						+ jsonObject.getString("errmsg"));
			}
		}
		return user;
	}

	/**
	 * 获取jsSdk的相关验证信息
	 * @author qianjs163@163.com  2017年3月16日下午6:18:14
	 * @param token
	 * @return
	 */
	public static JsApiTicket getJsApiTicket(String token) {
		log.info("获取js调用凭证:getJsApiTicket");
		String url = WxApiUrl.WX_JS_TICKET.replaceAll("ACCESS_TOKEN", token);
		String result = HttpClient.sendGet(url, "");
		JsApiTicket ticket = null;
		if (!"".equals(result)) {
			try {
				ticket = JSON.parseObject(result, JsApiTicket.class);
			} catch (Exception e) {
				log.error("JsApiTicket:" + "解析json报错" + e.getMessage());
			}
		}
		return ticket;
	}
	
}
