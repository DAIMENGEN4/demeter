package com.advantest.demeter.common.utils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.regex.Pattern;

/**
 * Create on 2025/01/01
 * Author: mengen.dai@outlook.com
 */
public class DateUtils {
    private static final Pattern DATE_PATTERN = Pattern.compile("\\d{4}-\\d{2}-\\d{2}");
    private static final Pattern DATE_TIME_PATTERN = Pattern.compile("\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2}:\\d{2}");

    private static final DateTimeFormatter YYYY_MM_DD = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    private static final DateTimeFormatter YYYY_MM_DD_HH_MM_SS = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    /**
     * Validates whether the given string matches the expected date pattern.
     *
     * @param dateStr the string to validate as a date
     * @return true if the input string matches the expected date pattern, false otherwise
     */
    public static boolean isValidDate(String dateStr) {
        return DATE_PATTERN.matcher(dateStr).matches();
    }


    /**
     * Validates whether the given string matches the expected date-time pattern.
     *
     * @param dateTimeStr the string to validate as a date-time
     * @return true if the input string matches the expected date-time pattern, false otherwise
     */
    public static boolean isValidDateTime(String dateTimeStr) {
        return DATE_TIME_PATTERN.matcher(dateTimeStr).matches();
    }

    /**
     * Returns the current date as a string in the format "yyyy-MM-dd".
     *
     * @return the current date as a string
     */
    public static String currentDate() {
        return LocalDateTime.now().format(YYYY_MM_DD);
    }

    /**
     * Returns the current date and time as a string in the format "yyyy-MM-dd HH:mm:ss".
     *
     * @return the current date and time as a string
     */
    public static String currentDateTime() {
        return LocalDateTime.now().format(YYYY_MM_DD_HH_MM_SS);
    }

    /**
     * Formats a LocalDate object to a string in the format "yyyy-MM-dd".
     *
     * @param localDate the LocalDate object to format
     * @return the formatted date string
     */
    public static String formatLocalDate(LocalDate localDate) {
        return localDate.format(YYYY_MM_DD);
    }

    /**
     * Formats a LocalDateTime object to a string in the format "yyyy-MM-dd HH:mm:ss".
     *
     * @param localDateTime the LocalDateTime object to format
     * @return the formatted date and time string
     */
    public static String formatLocalDateTime(LocalDateTime localDateTime) {
        return localDateTime.format(YYYY_MM_DD_HH_MM_SS);
    }

    /**
     * Parses a date string in the format "yyyy-MM-dd" to a LocalDate object.
     *
     * @param localDateString the date string to parse
     * @return the parsed LocalDate object
     */
    public static LocalDate parseLocalDate(String localDateString) {
        return LocalDate.parse(localDateString, YYYY_MM_DD);
    }

    /**
     * Parses a date and time string in the format "yyyy-MM-dd HH:mm:ss" to a LocalDateTime object.
     *
     * @param localDateTimeString the date and time string to parse
     * @return the parsed LocalDateTime object
     */
    public static LocalDateTime parseLocalDateTime(String localDateTimeString) {
        return LocalDateTime.parse(localDateTimeString, YYYY_MM_DD_HH_MM_SS);
    }
}
