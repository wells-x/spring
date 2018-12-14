package com.wells.common.kit.support;


import com.wells.common.exception.ToolBoxException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Arrays;
import java.util.Date;
import java.util.Optional;

public enum DateFormat {
    /**
     * 标准日期格式
     */
    NORM_DATE_PATTERN("yyyy-MM-dd"),
    /**
     * 年月
     */
    YEAR_MONTH("yyyy-MM"),
    /**
     * 标准时间格式
     */
    NORM_TIME_PATTERN("HH:mm:ss"),
    /**
     * 标准日期时间格式，精确到分
     */
    NORM_DATETIME_MINUTE_PATTERN("yyyy-MM-dd HH:mm"),
    /**
     * 标准日期时间格式，精确到秒
     */
    NORM_DATETIME_PATTERN("yyyy-MM-dd HH:mm:ss"),
    /**
     * 标准日期时间格式，精确到毫秒
     */
    NORM_DATETIME_MS_PATTERN("yyyy-MM-dd HH:mm:ss.SSS"),
    /**
     * HTTP头中日期时间格式
     */
    HTTP_DATETIME_PATTERN("EEE, dd MMM yyyy HH:mm:ss z");

    private String date;
    private int size;

    DateFormat(String date) {
        this.date = date;
        this.size = date.length();
    }

    public static Optional<DateFormat> format(String date) {
        return Arrays.stream(values()).filter(s -> s.size == date.length()).findFirst();
    }

    public static Date toDate(String date) {
        Optional<DateFormat> dateFormat = format(date);
        if (dateFormat.isPresent()) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(dateFormat.get().date);
            try {
                return simpleDateFormat.parse(date);
            } catch (ParseException e) {
                throw new ToolBoxException("时间格式化失败");
            }
        }
        throw new ToolBoxException("时间格式化失败");
    }

    public static LocalDateTime toLocalDateTime(String date) {
        Optional<DateFormat> dateFormat = format(date);
        if (dateFormat.isPresent()) {
            Instant instant = toDate(date).toInstant();
            ZoneId zone = ZoneId.systemDefault();
            return LocalDateTime.ofInstant(instant, zone);
        }
        throw new ToolBoxException("时间格式化失败");
    }

}
