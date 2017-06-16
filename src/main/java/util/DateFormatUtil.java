package util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormatUtil {
	
	/**
	 * 日期 按格式 输出成字符串
	 * 
	 * @param date
	 * @param fmt
	 *            yyyy-MM-dd HH:mm:ss
	 * @return
	 */
	public static String getStringFormatDate(Date date) {
		return getStringFormatDate(date, null);
	}

	/**
	 * 日期 按格式 输出成字符串
	 * 
	 * @param date
	 * @param fmt
	 * @return
	 */
	public static String getStringFormatDate(Date date, String fmt) {
		if (date == null) {
			return "";
		}
		if (fmt == null || fmt.trim().equals("")) {
			fmt = "yyyy-MM-dd";
		}
		DateFormat dateFormat = new SimpleDateFormat(fmt);
		return dateFormat.format(date);
	}
}
