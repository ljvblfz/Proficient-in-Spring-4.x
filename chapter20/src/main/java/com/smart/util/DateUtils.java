package com.smart.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {
	public static Date getDate(String datestr, String format) {
		try {
			SimpleDateFormat dateFormat = new SimpleDateFormat(format);
			dateFormat.setLenient(true);
			return dateFormat.parse(datestr);
		} catch (Exception e) {
			throw new IllegalArgumentException(e);
		}
	}
}
