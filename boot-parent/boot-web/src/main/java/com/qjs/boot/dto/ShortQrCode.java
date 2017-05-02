package com.qjs.boot.dto;

public class ShortQrCode extends QrCode {
	private Integer expire_seconds;

	public Integer getExpire_seconds() {
		return expire_seconds;
	}

	public void setExpire_seconds(Integer expire_seconds) {
		this.expire_seconds = expire_seconds;
	}

}
