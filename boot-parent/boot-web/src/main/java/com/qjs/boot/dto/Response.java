package com.qjs.boot.dto;

// 所有ajax请求放回类型,封装json结果
public class Response<T> {

	private Integer returnFlag;

	public Integer getReturnFlag() {
		return returnFlag;
	}

	public void setReturnFlag(Integer returnFlag) {
		this.returnFlag = returnFlag;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	private T data;

	private String errorMsg;

	public Response(Integer returnFlag, String errorMsg) {
		super();
		this.returnFlag = returnFlag;
		this.errorMsg = errorMsg;
	}

	public Response(Integer returnFlag, T data, String errorMsg) {
		super();
		this.returnFlag = returnFlag;
		this.data = data;
		this.errorMsg = errorMsg;
	}

	public Response() {
		super();
	}

}