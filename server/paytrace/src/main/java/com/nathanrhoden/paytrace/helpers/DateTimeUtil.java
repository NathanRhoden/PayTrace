package com.nathanrhoden.paytrace.helpers;

import lombok.experimental.UtilityClass;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@UtilityClass
public class DateTimeUtil {

    LocalDateTime localDateTime = LocalDateTime.now();

    /**
     * Hour:Minute format
     */
    DateTimeFormatter HOUR_MIN = DateTimeFormatter.ofPattern("HHmm");
    /**
     * Year-Month_day format
     */
    DateTimeFormatter YEAR_MONTH_DATE = DateTimeFormatter.ofPattern("yyyyMMdd");

    public static String hourMin() {

        return localDateTime.format(HOUR_MIN);
    }

    public static String yearMonthDate() {
        return localDateTime.format(YEAR_MONTH_DATE);
    }

}
