package util;


import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;


public class ExcelReadJxlUtil {

	/**
	 * 使用jxl 读excel
	 * @param file
	 * @return
	 */
	public static List<Map<Integer,String>> readExcel(InputStream inputStream){
		List<Map<Integer,String>> list = new ArrayList<Map<Integer,String>>();
		Workbook wb = null;
		int count = 0;
		try {
			// 获得工作簿对象
			wb = Workbook.getWorkbook(inputStream);
				// 获取工作表对象
				Sheet[] sheets = wb.getSheets();
				if (null != sheets && sheets.length != 0) {
					// 遍历所有的工作表
					for (int i = 0; i < sheets.length; i++) {
						// 获得工作表行数
						int rows = sheets[i].getRows();
						//获得列数
						int cols = sheets[i].getColumns();
						for (int j = 1; j < rows; j++) {
							// 遍历行
							Map<Integer,String> map = new HashMap<>();
							for (int k = 0; k < cols; k++) {
								// 获取当前行的所有单元格
								//Cell cells = sheets[i].getCell(k,j);
								Cell[] cells = sheets[i].getRow(j);
								count++;
								map.put(k, cells[k].getContents());
							}
							list.add(map);
						}
					}
				}
			System.out.println(count);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			wb.close();
		}
		return list;
	}
}
