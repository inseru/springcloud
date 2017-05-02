package com.qjs.wx.course.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.qjs.wx.course.model.AccessToken;
import com.qjs.wx.course.model.Button;
import com.qjs.wx.course.model.Menu;
import com.qjs.wx.course.model.ViewButton;

/**
 * 菜单管理器类
 * 
 * @author liufeng
 * @date 2013-08-08
 */
public class MenuManager {
	private static Logger log = LoggerFactory.getLogger(MenuManager.class);

	public static void main(String[] args) {
		// 第三方用户唯一凭证
		String appId = "wx3b91e1c6c508000b";
		// 第三方用户唯一凭证密钥
		String appSecret = "b683ff1c8717db66a08504af04275c03";
		// 调用接口获取access_token
		AccessToken at = WeixinUtil.getAccessToken(appId, appSecret);

		// String at =
		// "DX0aeB5TKmdNkngpU8Ka6MUYKLo0fJZm_fUeTN88HdeGjWFEOQ32Oowlv7RJYLTujZhJpFtb4RrSUeAAVcEFNaex8W1VeSjoB1YK5v4V5WvCyKm17s6c4_5NovO1gcldQJHfAFAZSQ";
		if (null != at) {
			// 调用接口创建菜单
			int result = WeixinUtil.createMenu(getMenu(), at.getToken());

			// 判断菜单创建结果
			if (0 == result)
				System.out.println("菜单创建成功！");
			else
				System.out.println("菜单创建失败，错误码：" + result);
		}
	}

	/**
	 * 组装菜单数据
	 * 
	 * @return
	 */
	private static Menu getMenu() {
		/*
		 * CommonButton btn11 = new CommonButton(); btn11.setName("天气预报");
		 * btn11.setType("click"); btn11.setKey("11");
		 * 
		 * CommonButton btn12 = new CommonButton(); btn12.setName("公交查询");
		 * btn12.setType("click"); btn12.setKey("12");
		 * 
		 * CommonButton btn13 = new CommonButton(); btn13.setName("周边搜索");
		 * btn13.setType("click"); btn13.setKey("13");
		 * 
		 * CommonButton btn14 = new CommonButton(); btn14.setName("历史上的今天");
		 * btn14.setType("click"); btn14.setKey("14");
		 * 
		 * CommonButton btn21 = new CommonButton(); btn21.setName("歌曲点播");
		 * btn21.setType("click"); btn21.setKey("21");
		 * 
		 * CommonButton btn22 = new CommonButton(); btn22.setName("经典游戏");
		 * btn22.setType("click"); btn22.setKey("22");
		 * 
		 * CommonButton btn23 = new CommonButton(); btn23.setName("美女电台");
		 * btn23.setType("click"); btn23.setKey("23");
		 * 
		 * CommonButton btn24 = new CommonButton(); btn24.setName("人脸识别");
		 * btn24.setType("click"); btn24.setKey("24");
		 * 
		 * CommonButton btn25 = new CommonButton(); btn25.setName("聊天唠嗑");
		 * btn25.setType("click"); btn25.setKey("25");
		 * 
		 * CommonButton btn31 = new CommonButton(); btn31.setName("Q友圈");
		 * btn31.setType("click"); btn31.setKey("31");
		 * 
		 * CommonButton btn32 = new CommonButton(); btn32.setName("电影排行榜");
		 * btn32.setType("click"); btn32.setKey("32");
		 * 
		 * CommonButton btn33 = new CommonButton(); btn33.setName("幽默笑话");
		 * btn33.setType("click"); btn33.setKey("33");
		 * 
		 * ComplexButton mainBtn1 = new ComplexButton();
		 * mainBtn1.setName("生活助手"); mainBtn1.setSub_button(new CommonButton[] {
		 * btn11, btn12, btn13, btn14 });
		 * 
		 * ComplexButton mainBtn2 = new ComplexButton();
		 * mainBtn2.setName("休闲驿站"); mainBtn2.setSub_button(new CommonButton[] {
		 * btn21, btn22, btn23, btn24, btn25 });
		 * 
		 * ComplexButton mainBtn3 = new ComplexButton();
		 * mainBtn3.setName("更多体验"); mainBtn3.setSub_button(new CommonButton[] {
		 * btn31, btn32, btn33 });
		 * 
		 * CommonButton mainBtn1=new CommonButton();
		 * mainBtn1.setKey("V1001_TODAY_MUSIC");mainBtn1.setName("button1");
		 * mainBtn1.setType("click"); CommonButton mainBtn2=new CommonButton();
		 * mainBtn2.setKey("V1001_TODAY_SINGER");mainBtn2.setName("button2");
		 * mainBtn2.setType("click");
		 */

		ViewButton mainBtn1 = new ViewButton();
		mainBtn1.setName("百度");
		mainBtn1.setType("view");
		mainBtn1.setUrl("http://qjs.s1.natapp.cc/test/id");
		ViewButton mainBtn2 = new ViewButton();
		mainBtn2.setName("myCode");
		mainBtn2.setType("view");
		mainBtn2.setUrl(
				"https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx3b91e1c6c508000b&redirect_uri=http%3a%2f%2fqjs.ngrok.cc%2fweixinTest%2fredire%2fone&response_type=code&scope=snsapi_base&state=123#wechat_redirect");

		/**
		 * https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx3b91e1c6c508000b&redirect_uri=http%3a%2f%2fwww.chedao360.com%2fweixinTest%2fredire%2fone&response_type=code&scope=snsapi_base&state=123#wechat_redirect
		 * 这是公众号xiaoqrobot目前的菜单结构，每个一级菜单都有二级菜单项<br>
		 * 
		 * 在某个一级菜单下没有二级菜单的情况，menu该如何定义呢？<br>
		 * 比如，第三个一级菜单项不是“更多体验”，而直接是“幽默笑话”，那么menu应该这样定义：<br>
		 * menu.setButton(new Button[] { mainBtn1, mainBtn2, btn33 });
		 */
		Menu menu = new Menu();
		Button[] button = new Button[] { mainBtn1, mainBtn2 };
		menu.setButton(button);

		return menu;
	}

	/**
	 * { "button":[ { "type":"click", "name":"今日歌曲", "key":"V1001_TODAY_MUSIC"
	 * }, { "type":"click", "name":"歌手简介", "key":"V1001_TODAY_SINGER" }, {
	 * "type":"view", "name":"歌手简介", "url":"http://www.qq.com/" } , {
	 * "name":"菜单", "sub_button":[ { "type":"click", "name":"hello word",
	 * "key":"V1001_HELLO_WORLD" }, { "type":"click", "name":"赞一下我们",
	 * "key":"V1001_GOOD" }] }] }
	 */

}
