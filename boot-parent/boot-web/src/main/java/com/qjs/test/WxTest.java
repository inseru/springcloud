package com.qjs.test;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import com.alibaba.fastjson.JSON;
import com.qjs.boot.dto.QrActionInfo;
import com.qjs.boot.dto.QrCode;
import com.qjs.boot.dto.ShortQrCode;
import com.qjs.common.util.HttpClient;

public class WxTest {
	// wx3b91e1c6c508000b
	// b683ff1c8717db66a08504af04275c03
	@Test
	public void test1() {
		String url = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET";
		String u = url.replaceAll("APPID", "wx05d047dd429a4be3").replaceAll("APPSECRET",
				"f7fe240bd572a19d673d279b69b5db47");
		String result = HttpClient.sendGet(u, "");
		System.out.println(result);
		// 56cNu730XfuPXf3aKa_ZeMgQSP5bsdMEk-l5VdMOE5jpVz88hEEecseCY8f6laDq83HfOO13EQlNlqenQG79nXRs2aTGQrYnOpisBFhwO4P_2vSPblQd1iT49zvcn1c1BZBeAAAOMO
	}

	@Test
	public void test2() {
		// 创建一个临时二维码
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("scene_id", 123);
		ShortQrCode code = new ShortQrCode();
		code.setExpire_seconds(2592000);
		code.setAction_name("QR_SCENE");
		code.setAction_info(new QrActionInfo<String, Integer>(map));
		String param = JSON.toJSONString(code);
		String url = "https://api.weixin.qq.com/cgi-bin/qrcode/create?access_token=TOKENPOST";
		String u = url.replaceAll("TOKENPOST",
				"XUVTyT8osm0LNsplNxbZlvMThlFMC6y_zuTFR-aGT8JevNnSVexWbt_696lsanZRzxFsmotF4ne-CgoPWc15BUyUNp0-NmMA1XPSWcCxhnkce1xSOJfosA6d9ANL6Z08RTSjABAFHG");
		String result = HttpClient.post(u, param);
		System.out.println(result);
		// {"ticket":"gQGM8TwAAAAAAAAAAS5odHRwOi8vd2VpeGluLnFxLmNvbS9xLzAyeTFxdTVzSVhjbjMxTTJHTTFvMTgAAgQCnchYAwQAjScA","expire_seconds":2592000,"url":"http://weixin.qq.com/q/02y1qu5sIXcn31M2GM1o18"}
	}

	@Test
	public void test3() {
		// 创建一个永久二维码
		Map<String, String> map = new HashMap<String, String>();
		map.put("scene_str", "测试");
		QrCode code = new QrCode();
		// code.setExpire_seconds(2592000);
		code.setAction_name("QR_LIMIT_STR_SCENE");
		code.setAction_info(new QrActionInfo<String, String>(map));
		String param = JSON.toJSONString(code);
		System.out.println(param);
		String url = "https://api.weixin.qq.com/cgi-bin/qrcode/create?access_token=TOKENPOST";
		String u = url.replaceAll("TOKENPOST",
				"P6ord2qXWszboCa7-Zrisz4w3eBEIctiHcgUR5GHbt5lAusPHDQzmKGx3crwbjt5UWetDluRE3mE1xaoJXwV3c2Td2jEYWgpU_I58ryyQPTXvAxxiJ18udmDN7oztfgbXYFcACABCJ");
		String result = HttpClient.post(u, param);
		System.out.println(result);
		// {"ticket":"gQFO8TwAAAAAAAAAAS5odHRwOi8vd2VpeGluLnFxLmNvbS9xLzAyYU9oWTU1SVhjbjMxMDAwMDAwN3QAAgTvTspYAwQAAAAA","url":"http://weixin.qq.com/q/02aOhY55IXcn310000007t"}
	}

	// 小程序回复消息接口
	@Test
	public void test4() {
		// openid oIDgJ0T2x9XqskkuF4qq2dOc_LQw
		// oIDgJ0YFd7E_TcAcnmj_9w5LPgRs
		String url = "https://api.weixin.qq.com/cgi-bin/message/custom/send?access_token=ACCESS_TOKEN";
		String u = url.replaceAll("ACCESS_TOKEN",
				"ZJT9rSl_Kqc7_KBGUWhjgjwyNPLEaU_ZKiV3TMXmo-M3tdFB7_xWH54hgBuNXI9tmZcbZbVUBT-ABMrVFKJQNl1R9cz3UkM-obTL0RSU0xqddbUaCJ8t6olbEX939SRqXNBgAHAQGU");
		AppletChatMessage mess = new AppletChatMessage("oIDgJ0YFd7E_TcAcnmj_9w5LPgRs", "text");
		Map<String, String> map = new HashMap<>();
		map.put("content", "二货");
		mess.setText(map);
		String resp = HttpClient.post(u, JSON.toJSON(mess).toString());
		System.err.println(resp);
	}
}
