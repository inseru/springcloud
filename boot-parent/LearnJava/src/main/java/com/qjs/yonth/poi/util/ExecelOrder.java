package com.qjs.yonth.poi.util;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface ExecelOrder {
	String title();

	int order() default 999;
}
