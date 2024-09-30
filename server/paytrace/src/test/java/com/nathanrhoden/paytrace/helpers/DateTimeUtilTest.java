package com.nathanrhoden.paytrace.helpers;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.*;

class DateTimeUtilTest {

    LocalDateTime localDateTime = LocalDateTime.now();
    DateTimeFormatter HOUR_MIN = DateTimeFormatter.ofPattern("HHmm");
    DateTimeFormatter YEAR_MONTH_DATE = DateTimeFormatter.ofPattern("yyyymmdd");

    @Test
    void hourMin() {

    }
    @Test
    public void testAssertsThatCurrentTimeIsShownAsHourMin(){
        assertEquals(localDateTime.format(HOUR_MIN) , DateTimeUtil.hourMin());
    }

    @Test
    public void testAssertsThatCurrentTimeIsShownAsYearMonthDate(){
        assertEquals(localDateTime.format(YEAR_MONTH_DATE) , DateTimeUtil.yearMonthDate());
    }
}