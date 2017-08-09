package com.qjs.yonth.poi;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;

import com.alibaba.fastjson.JSON;
import com.qjs.yonth.poi.util.ExecelTemplate;
import com.qjs.yonth.poi.util.ExecelUtils;

public class poiTest {

	/**
	 * 设置样式，效果很失败
	 */
	// @Test
	public void test1() {
		// Workbook wb=new HSSFWorkbook(); //execel:2003
		Workbook wb = new XSSFWorkbook(); // execel:2007
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream(new File("goods.xlsx"));
			Sheet st = wb.createSheet("test1");
			Row r = st.createRow(0);
			r.setHeightInPoints(20); // 行高
			CellStyle cs = wb.createCellStyle(); // 设置样式
			CellStyle cs2 = wb.createCellStyle(); // 设置样式
			cs.setAlignment(CellStyle.ALIGN_CENTER); // 对齐方式
			cs.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
			cs.setFillBackgroundColor((short) 9888); // rgb
			cs.setBorderBottom(CellStyle.BORDER_DOTTED);
			cs2.setBorderBottom(CellStyle.BORDER_THIN);
			Cell c = r.createCell(0);
			c.setCellStyle(cs);
			c.setCellValue("姓名");
			c = r.createCell(1);
			c.setCellStyle(cs2);
			c.setCellValue("年龄");
			wb.write(fos);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (fos != null) {
				try {
					fos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	/**
	 * 通过模板设置样式
	 */
	// @Test
	public void test2() {
		ExecelTemplate w = ExecelTemplate.getInstance().readTemplateByPath("students.xlsx");
		w.createNewRow();
		w.createNewCell("1");
		w.createNewCell("11");
		w.createNewCell("111");
		w.createNewRow();
		w.createNewCell("2");
		w.createNewCell("22");
		w.createNewCell("222");
		Map<String, String> map = new HashMap<String, String>();
		map.put("title", "学生信息");
		String date = "2012-12-12";
		map.put("date", date);
		w.replaceFinalData(map);
		w.writeToFile("test.xlsx");
	}

	/**
	 * 基于注解
	 */
	// @Test
	public void test3() {
		Map<String, String> map = new HashMap<String, String>();
		map.put("title", "学生信息");
		String date = "2012-12-12";
		map.put("date", date);
		ExecelUtils util = ExecelUtils.getInstance();
		System.out.println(poiTest.class.getResourceAsStream("/"));
		util.exportObj2ExecleByTemplate(map, "user.xlsx", "test1.xlsx", null, User.class, false);
	}

	/**
	 * 通过对象读出数据
	 */
	// @Test
	public void test4() {

	}

	/**
	 * 视频
	 * 
	 * @throws IOException
	 * @throws JsonMappingException
	 * @throws JsonParseException
	 */
	// @Test
	public void test6() throws JsonParseException, JsonMappingException, IOException {
		String fullFileName = "Videos.json";

		File file = new File(fullFileName);

		Scanner scanner = null;
		StringBuilder buffer = new StringBuilder();
		try {
			scanner = new Scanner(file, "utf-8");
			while (scanner.hasNextLine()) {
				buffer.append(scanner.nextLine());
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			if (scanner != null) {
				scanner.close();
			}
		}
		// ObjectMapper mapper = new ObjectMapper();
		// List<video> list = mapper.readValue(buffer.toString(), new
		// TypeReference<List<video>>() {
		// });
		List<video> list = JSON.parseArray(buffer.toString(), video.class);
		System.out.println(list.size());
		// System.out.println(list.get(0).getCityZh());
		Workbook wb = new XSSFWorkbook(); // execel:2007
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream(new File("a1.xlsx"));
			Sheet st = wb.createSheet("test1");
			video video = null;
			String id = null;
			for (int i = 0; i < list.size(); i++) {
				Row r = st.createRow(i);
				video = list.get(i);
				for (int j = 0; j < 5; j++) {
					if (j == 0) {
						Cell c = r.createCell(j);
						c.setCellValue(video.getModels());
					}
					if (j == 1) {
						Cell c = r.createCell(j);
						c.setCellValue(video.getSFX());
					}
					if (j == 2) {
						Cell c = r.createCell(j);
						c.setCellValue(video.getOPcolor());
					}
					if (j == 3) {
						Cell c = r.createCell(j);
						c.setCellValue(video.getVideoId());
					}
					if (j == 4) {
						Cell c = r.createCell(j);
						c.setCellValue(video.getPath());
					}
				}
			}
			wb.write(fos);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (fos != null) {
				try {
					fos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	/**
	 * io
	 * 
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	// @Test
	public void test7() throws JsonParseException, JsonMappingException, IOException {
		String fullFileName = "Videos.json";
		File file = new File(fullFileName);
		File o = new File("b.json");
		FileInputStream in = new FileInputStream(file);
		InputStreamReader inr = new InputStreamReader(in, "utf-8");
		OutputStream os = new FileOutputStream(o);
		OutputStreamWriter out = new OutputStreamWriter(os, "utf-8");
		int n = 10;
		int a = 0;
		char[] c = new char[n];
		while ((a = inr.read(c)) != -1) {
			out.write(c, 0, a);
			out.flush();
		}
		out.close();
	}

}
