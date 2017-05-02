package com.qjs.yonth.poi.util;

public class ExecelHeader implements Comparable<ExecelHeader> {
	private String title;

	private int order;

	private String methodName;

	public ExecelHeader(String title, int order, String methodName) {
		super();
		this.title = title;
		this.order = order;
		this.methodName = methodName;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getOrder() {
		return order;
	}

	public void setOrder(int order) {
		this.order = order;
	}

	public String getMethodName() {
		return methodName;
	}

	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}

	@Override
	public int compareTo(ExecelHeader o) {

		return order > o.order ? 1 : (order < o.order ? -1 : 0);
	}

	@Override
	public String toString() {
		return "ExecelHeader [title=" + title + ", order=" + order + ", methodName=" + methodName + "]";
	}

}
