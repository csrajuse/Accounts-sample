package com.osaic.sample.util;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateUtils {

	private static DateTimeFormatter formatOnlyDate = DateTimeFormatter.ofPattern("MM/dd/yyyy");
	private static DateTimeFormatter formatDateAndTime = DateTimeFormatter.ofPattern("MM/dd/yyy HH:mm:ss");

	public static LocalDate convertToLocalDate(String localDateString) {
		if (localDateString != null) {
			return LocalDate.parse(localDateString, formatOnlyDate);
		} else {
			return null;
		}
	}

	public static String convertToString(LocalDate localDate) {
		return localDate.format(formatOnlyDate);
	}

	public static LocalDateTime convertToLocalDateWithTime(String localDateString) {
		return LocalDateTime.parse(localDateString, formatDateAndTime);
	}

	public static String convertToStringWithTime(LocalDateTime localDatetime) {
		return localDatetime.format(formatDateAndTime);
	}

}
