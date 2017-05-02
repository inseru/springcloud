package com.qjs.boot.dto;

import java.util.Map;

public class QrActionInfo<V, K> {
	/**
	 * 数字型："scene_id": 123 字符串型： scene_str": "123"
	 */
	private Map<V, K> scene;

	public QrActionInfo(Map<V, K> scene) {
		super();
		this.scene = scene;
	}

	public Map<V, K> getScene() {
		return scene;
	}

	public void setScene(Map<V, K> scene) {
		this.scene = scene;
	}

}
