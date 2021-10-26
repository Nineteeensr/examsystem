package cn.kgc.kjde1035.group1.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import cn.kgc.kjde1035.group1.entity.Subject;

public class ExcelUtils {
	public static List<Subject> parseSubject(String fileType, InputStream is) {
		Workbook wb = null;
		Sheet sheet = null;
		Row row = null;
		String cellData = null;
		//储存试题的list
		List<Subject> subList = new ArrayList<Subject>();
		
		String [] columns = {"scontent", "sa", "sb","sc","sd","skey","sstate","speciaId"};
		wb = readExcel(fileType,is);
		
		if (wb != null) {
			// 获取第一个sheet
			sheet = wb.getSheetAt(0);
			// 获取最大行数
			int rownum = sheet.getPhysicalNumberOfRows();
			System.out.println("最大行数："+rownum);
			// 获取第一行
			row = sheet.getRow(0);
			// 获取最大列数
			int colnum = row.getPhysicalNumberOfCells();
			for (int i = 1; i < rownum; i++) {
				Map<String, String> map = new LinkedHashMap<String, String>();
				row = sheet.getRow(i);
				if (row != null) {
					Subject subject = new Subject();
					for (int j = 0; j < colnum; j++) {
						cellData = (String) getCellFormatValue(row.getCell(j));
						map.put(columns[j], cellData);
					}
					subject.setScontent(map.get("scontent"));
					subject.setSa(map.get("sa"));
					subject.setSc(map.get("sb"));
					subject.setSc(map.get("sc"));
					subject.setSd(map.get("sd"));
					subject.setSkey(map.get("skey"));
					subject.setSstate((int)Double.parseDouble(map.get("sstate")));
					subject.setSpeciaid((int)Double.parseDouble(map.get("speciaId")));
					subList.add(subject);
				} else {
					break;
				}
			}
		}
		return subList;
		
		
		
		
		
		
		
		// 遍历解析出来的list
//		for (Map<String, String> map : list) {
//			for (Entry<String, String> entry : map.entrySet()) {
//				System.out.print(entry.getKey() + ":" + entry.getValue() + ",");
//				
//			}
//			
//			System.out.println();
//		}

	}

	// 读取excel
	public static Workbook readExcel(String filetype,InputStream is) {
		Workbook wb = null;
		try {
			
			if (".xls".equals(filetype)) {
				return wb = new HSSFWorkbook(is);
			} else if (".xlsx".equals(filetype)) {
				return wb = new XSSFWorkbook(is);
			} else {
				return wb = null;
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return wb;
	}

	public static Object getCellFormatValue(Cell cell) {
		Object cellValue = null;
		if (cell != null) {
			// 判断cell类型
			switch (cell.getCellType()) {
			case Cell.CELL_TYPE_NUMERIC: {
				cellValue = String.valueOf(cell.getNumericCellValue());
				break;
			}
			case Cell.CELL_TYPE_FORMULA: {
				// 判断cell是否为日期格式
				if (DateUtil.isCellDateFormatted(cell)) {
					// 转换为日期格式YYYY-mm-dd
					cellValue = cell.getDateCellValue();
				} else {
					// 数字
					cellValue = String.valueOf(cell.getNumericCellValue());
				}
				break;
			}
			case Cell.CELL_TYPE_STRING: {
				cellValue = cell.getRichStringCellValue().getString();
				break;
			}
			default:
				cellValue = "";
			}
		} else {
			cellValue = "";
		}
		return cellValue;
	}
}
