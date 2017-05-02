package com.qjs.yonth.poi.util;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class ExecelUtils {
	private static ExecelUtils ev = new ExecelUtils();

	public ExecelUtils() {

	}

	public static ExecelUtils getInstance() {
		return ev;
	}

	public void exportObj2ExecleByTemplate(Map datas, String template, String outpath, List objs, Class clz,
			boolean isClasspath) {
		ExecelTemplate w = ExecelTemplate.getInstance();
		if (isClasspath) {
			w.readTemplateByClassPath(template);
		} else {
			w.readTemplateByPath(template);
		}
		List<ExecelHeader> list = getHeaderList(clz);
		Collections.sort(list);
		w.createNewRow();
		for (ExecelHeader header : list) {
			w.createNewCell(header.getTitle());
		}
		w.replaceFinalData(datas);
		w.writeToFile(outpath);
	}

	private List<ExecelHeader> getHeaderList(Class clz) {
		List<ExecelHeader> list = new ArrayList<ExecelHeader>();
		Method[] method = clz.getDeclaredMethods();
		for (Method m : method) {
			String mn = m.getName();
			if (mn.startsWith("get")) {
				if (m.isAnnotationPresent(ExecelOrder.class)) {
					ExecelOrder er = m.getAnnotation(ExecelOrder.class);
					list.add(new ExecelHeader(er.title(), er.order(), mn));
				}
			}
		}
		return list;
	}

}
