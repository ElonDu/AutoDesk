package com.huifu.core.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {

	public static final String DEFAULT_DATETIME_FORMAT = "yyyyMMddHHmmss";

	public static final String DEFAULT_DATETIME_STD_FORMAT = "yyyy-MM-dd HH:mm:ss";

	public static final String DEFAULT_DATE_FORMAT = "yyyyMMdd";

	public static final String DEFAULT_TIME_FORMAT = "HHmmss";

	public static final String DEFAULT_DATE_SLASH_FORMAT = "yyyy/MM/dd";

	public static final String DEFAULT_DATE_SHORTBAR_FORMAT = "yyyy-MM-dd";

	public static String getCurrentDatetime() {
		SimpleDateFormat fmter = new SimpleDateFormat(DEFAULT_DATETIME_FORMAT);
		return fmter.format(new Date());
	}

	public static String getCurrentDate() {
		SimpleDateFormat fmter = new SimpleDateFormat(DEFAULT_DATE_FORMAT);
		return fmter.format(new Date());
	}

	public static String getCurrentTime() {
		SimpleDateFormat fmter = new SimpleDateFormat(DEFAULT_TIME_FORMAT);
		return fmter.format(new Date());
	}

	public static String getCurrentSlashDate() {
		SimpleDateFormat fmter = new SimpleDateFormat(DEFAULT_DATE_SLASH_FORMAT);
		return fmter.format(new Date());
	}

	public static String getCurrentShortBarDate() {
		SimpleDateFormat fmter = new SimpleDateFormat(DEFAULT_DATE_SHORTBAR_FORMAT);
		return fmter.format(new Date());
	}

}
