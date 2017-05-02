package com.qjs.boot.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.qjs.common.util.HttpClient;
import com.qjs.properties.CommonProperties;
import com.qjs.properties.Commons;

import io.swagger.annotations.ApiOperation;

/**
 * 
 * @author qianjs163@163.com
 *
 * @date 2016年12月11日
 */
@RestController
@RequestMapping("/wx")
public class weixinController {
	private Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private CommonProperties commonProperties;

	@RequestMapping(value = "/login", method = RequestMethod.GET, consumes = "application/json", produces = "application/json")
	@ApiOperation(value = "测试用户登陆", notes = "测试微信用户登录")
	public String loginWx(@RequestParam String code) {
		log.info("login");
		System.out.println(code);
		String url = Commons.WX_SESSION.replaceAll("APPID", commonProperties.getAppID())
				.replaceAll("SECRET", commonProperties.getAppSecret()).replaceAll("JSCODE", code);
		String result = HttpClient.sendGet(url, "");
		return result;
	}

	@RequestMapping(value = "/getImage", method = RequestMethod.GET, consumes = "application/json", produces = "application/json")
	@ApiOperation(value = "获取美女图片", notes = "获取美女图片")
	public JSONArray getImage() {
		log.info("getImage");
		int i = (int) (1 + Math.random() * (30 - 1 + 1));
		String url = "https://image.baidu.com/channel/listjson?pn=" + i + "&rn=12&tag1=美女&tag2=全部&ftags=小清新女生&ie=utf8";
		String result = HttpClient.sendGet(url, "");
		JSONArray image = new JSONArray();
		JSONObject b = null;
		try {
			JSONObject obj = (JSONObject) JSON.parse(result);
			JSONArray data = (JSONArray) obj.get("data");
			for (Object a : data) {
				if (a instanceof JSONObject) {
					String desc = (String) ((JSONObject) a).get("desc");
					String imageUrl = (String) ((JSONObject) a).get("image_url");
					if ("".equals(desc) || desc == null) {
						if ("".equals(imageUrl) || imageUrl == null) {
							break;
						}
						desc = "清凉美女";
					}
					if (desc.length() > 5) {
						desc = desc.substring(0, 5);
					}
					b = new JSONObject();
					b.put("desc", desc);
					b.put("imageUrl", imageUrl);
					image.add(b);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			log.error("getImage");
		}
		log.info("数量" + image.size());
		log.info(image.toJSONString());
		return image;
	}

}
