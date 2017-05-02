package com.qjs.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

//@RefreshScope Spring Cloud中添加该配置，可以刷新config中的变量值
@ConfigurationProperties(prefix = "com.qjs")
// @Component
public class CommonProperties {
	private String appID;

	private String appSecret;

	public String getAppID() {
		return appID;
	}

	public void setAppID(String appID) {
		this.appID = appID;
	}

	public String getAppSecret() {
		return appSecret;
	}

	public void setAppSecret(String appSecret) {
		this.appSecret = appSecret;
	}

}
