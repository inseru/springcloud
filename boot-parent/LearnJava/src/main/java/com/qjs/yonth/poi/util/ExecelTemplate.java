package com.qjs.yonth.poi.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExecelTemplate {
	public final static String DATAS_LINE = "datas";

	public final static String STYLE = "style";

	public final static String DEFAULTS_STYLE = "style";

	private static ExecelTemplate et = new ExecelTemplate();

	private Workbook wb;
	private Sheet sheet;
	// 初始化行数，
	private int initRowIndex;
	// 初始化列数
	private int initColIndex;
	// 当前行
	private int curRowIndex;
	// 当前列
	private int curColIndex;
	private Row curRow;

	// 最后一行
	private int lastRowIndex;

	// 行高
	public float rowHeight;

	// 默认样式
	public CellStyle defaultStyle;
	// 存储各列样式
	private static Map<Integer, CellStyle> map = new HashMap<Integer, CellStyle>();

	private ExecelTemplate() {

	}

	public static ExecelTemplate getInstance() {
		return et;
	}

	// 1.读取相应的模板文档
	public ExecelTemplate readTemplateByClassPath(String path) {
		try {
			wb = WorkbookFactory.create(ExecelTemplate.class.getResourceAsStream(path));
			initTemplate();
		} catch (InvalidFormatException e) {
			e.printStackTrace();
			throw new RuntimeException("读取的模板格式有问题！");
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException("读取的模板文件不存在！");
		}
		return this;
	}

	public ExecelTemplate readTemplateByPath(String path) {
		try {
			wb = WorkbookFactory.create(new File(path));
			initTemplate();
		} catch (InvalidFormatException e) {
			e.printStackTrace();
			throw new RuntimeException("读取的模板格式有问题！");
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException("读取的模板文件不存在！");
		}
		return this;
	}

	/**
	 * 根据map替换相应常量
	 */
	public void replaceFinalData(Map<String, String> datas) {
		for (Row row : sheet) {
			for (Cell c : row) {
				if (c == null)
					continue;
				if (c.getCellType() != Cell.CELL_TYPE_STRING)
					continue;
				String str = c.getStringCellValue().trim();
				if (str.startsWith("#")) {
					if (datas.containsKey(str.substring(1))) {
						c.setCellValue(datas.get(str.substring(1)));
					}
				}
			}
		}
	}

	public void writeToFile(String filePath) {
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream(filePath);
			wb.write(fos);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("写入文件没找到");
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException("写入文件失败");
		} finally {
			if (fos != null)
				try {
					fos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
	}

	public void writeToStream(OutputStream os) {
		try {
			wb.write(os);
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException("写入流失败" + e.getMessage());
		}
	}

	public void createNewRow() {
		if (lastRowIndex >= curRowIndex && curRowIndex != initRowIndex) {
			sheet.shiftRows(curRowIndex, lastRowIndex, 1, true, true);
			lastRowIndex++;
		}
		curRow = sheet.createRow(curRowIndex);
		curRow.setHeightInPoints(rowHeight);
		curRowIndex++;
		curColIndex = initColIndex;
	}

	public void createNewCell(String value) {
		Cell c = curRow.createCell(curColIndex);
		if (map.containsKey(c.getColumnIndex())) {
			c.setCellStyle(map.get(c.getColumnIndex()));
		}
		c.setCellValue(value);
		curColIndex++;
	}

	// 初始化模板
	public void initTemplate() {
		sheet = wb.getSheetAt(0);
		initConfigData();
		lastRowIndex = sheet.getLastRowNum();
		curRow = sheet.createRow(curRowIndex);
	}

	public void initConfigData() {
		boolean findData = false;
		Row r = null;
		Cell c = null;
		for (int i = 0; i < sheet.getLastRowNum(); i++) {
			if (findData)
				break;
			r = sheet.getRow(i);
			for (int j = 0; j < r.getLastCellNum(); j++) {
				c = r.getCell(j);
				if (c == null)
					continue;
				if (c.getCellType() != Cell.CELL_TYPE_STRING)
					continue;
				String str = c.getStringCellValue().trim();
				if (DATAS_LINE.equals(str)) {
					initColIndex = c.getColumnIndex();
					initRowIndex = r.getRowNum();
					curColIndex = initColIndex;
					curRowIndex = initRowIndex;
					findData = true;
					rowHeight = r.getHeightInPoints();
					initStyle();
					break;
				}
			}
		}
	}

	private void initStyle() {
		boolean findData = false;
		Row r = null;
		Cell c = null;
		for (int i = 0; i < sheet.getLastRowNum(); i++) {
			if (findData)
				break;
			r = sheet.getRow(i);
			for (int j = 0; j < r.getLastCellNum(); j++) {
				c = r.getCell(j);
				if (c == null)
					continue;
				if (c.getCellType() != Cell.CELL_TYPE_STRING)
					continue;
				String str = c.getStringCellValue().trim();
				if (STYLE.equals(str)) {
					map.put(j, c.getCellStyle());
				}
				if (DEFAULTS_STYLE.equals(str)) {
					defaultStyle = c.getCellStyle();
					findData = true;
				}
			}
		}
	}

}
