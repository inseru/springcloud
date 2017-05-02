package com.qjs.boot.dto;

public class ResultInfo<T> {

	// 错误代码
	private int errorCode;
	// 错误提示
	private String errorText;

	// 返回对象
	private T data;

	public ResultInfo(int errorCode, String errorText, T data) {
		super();
		this.errorCode = errorCode;
		this.errorText = errorText;
		this.data = data;
	}

	public ResultInfo(int errorCode, String errorText) {
		super();
		this.errorCode = errorCode;
		this.errorText = errorText;
	}

	public ResultInfo() {
		super();
	}

	public int getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorText() {
		return errorText;
	}

	public void setErrorText(String errorText) {
		this.errorText = errorText;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
}
