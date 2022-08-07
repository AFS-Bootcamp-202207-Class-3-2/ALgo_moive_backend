package com.algo.c3g2.utils;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.Date;

/**
 * 考虑到场次的日期转换，添加工具类基于使用
 * 并且给出java8的日期装换api参考
 */
public class DateUtil {
    /**
     * 下面三个
     * LocalDate、LocalDateTime 和 Date互转
     * @param date
     * @return
     */
    public static LocalDate dateToLocalDate(Date date) {
        Instant instant = date.toInstant();
        ZoneId zoneId = ZoneId.systemDefault();
        return instant.atZone(zoneId).toLocalDate();
    }
    public static LocalDateTime dateToLocalDateTime(final Date date){
        return date.toInstant().atZone( ZoneId.systemDefault() ).toLocalDateTime();
    }
    public static Date localDateToDate(final LocalDate localDate){
        return Date.from( localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
    }
    public static Date localDateTimeToDate(final LocalDateTime localDateTime){
        return Date.from( localDateTime.atZone( ZoneId.systemDefault()).toInstant());
    }

    /**
     * localDateToString
     * @param localDate
     * @param dateTimeFormatter
     * @return
     */
    public static String localDateToString(LocalDate localDate , DateTimeFormatter dateTimeFormatter){
        return localDate.format(dateTimeFormatter);
    }

    public static String localDateTimeToString(LocalDateTime localDateTime , DateTimeFormatter dateTimeFormatter){
        return localDateTime.format(dateTimeFormatter);
    }
    public static String localDateTimeToString(LocalDateTime localDateTime){
        return localDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }

    /**
     * stringToLocalDate
     * @param str
     * @return
     */
    public static LocalDate stringToLocalDate(String str){
        return LocalDate.parse(str);
    }

    public static LocalDate stringToLocalDate(String str , DateTimeFormatter dateTimeFormatter ){
        return LocalDate.parse(str , dateTimeFormatter );
    }



    /**
     * example
     * @param args
     */
    public static void main(String[] args) {
        final LocalDate now = LocalDate.now();

        System.out.println("今天是 "+now);

        System.out.println("1970年到现在一共 "+now.toEpochDay() +" 天");

        final int lengthOfYear = now.lengthOfYear();
        System.out.println("今年一共 "+lengthOfYear+" 天");

        final int lengthOfMonth = now.lengthOfMonth();
        System.out.println("本月一共 "+ lengthOfMonth +" 天");

        final boolean leapYear = now.isLeapYear();
        System.out.println("今年是否是闰年："+leapYear);

        final LocalDate firstDayOfMonth = now.with(TemporalAdjusters.firstDayOfMonth());
        System.out.println("本月的第一天是 : "+firstDayOfMonth);

        //下一个周一
        final LocalDate withMONDAY = now.with(TemporalAdjusters.next(DayOfWeek.MONDAY));
        System.out.println("下周一日期是 :"+withMONDAY);

        System.out.println(" 日期在当前时间之后： "+ withMONDAY.isAfter(now));
        System.out.println(" 日期在当前时间之前： "+ withMONDAY.isBefore(now));

        //最后一个周一
        final LocalDate lastMONDAY = now.with(TemporalAdjusters.lastInMonth(DayOfWeek.TUESDAY));
        System.out.println("本月最后一个周二是 :"+lastMONDAY);

        final LocalDate lastDay = now.with(TemporalAdjusters.lastDayOfMonth());
        System.out.println("本月最后一天是 : "+lastDay);

        // 加一年
        final LocalDate plusYears = now.plusYears(1);
        System.out.println("当前日期加一年 : "+plusYears);

        //两个日期相差天数
        System.out.println("两个日期相差天数:"+(plusYears.toEpochDay() - now.toEpochDay()));

        final LocalDate plusMonths1 = now.plusMonths(12);
        System.out.println("当前日期加12 个月 :"+plusMonths1);

        final LocalDate minusDays = now.minusDays(1);
        System.out.println("当前日期减 1 天 : "+minusDays);

        final LocalDate plusDays = now.plusDays(1);
        System.out.println("当前日期加 1 天 : "+plusDays);

        final int dayOfMonth = now.getDayOfMonth();
        System.out.println("今天是这个月的第 "+dayOfMonth +" 天");
        final int monthValue = now.getMonthValue();
        System.out.println("本月是今年的第  "+monthValue + "月");
        final Month month = now.getMonth();
        System.out.println("本月的英文 : "+month);

        // 本周的周几
        final DayOfWeek dayOfWeek = now.getDayOfWeek();
        System.out.println("今天是周几英文： " + dayOfWeek);
        System.out.println("今天是本周周几: " + dayOfWeek.getValue());

        // string 转 localDate
        final LocalDate parse = LocalDate.parse("2021-07-12");
        final LocalDate parse1 = LocalDate.parse("2021-07-12", DateTimeFormatter.ofPattern("yyyy-MM-dd"));

        System.out.println(parse1);
        System.out.println(" 转日期 "+parse);
        System.out.println("DateTimeFormatter 转日期 "+parse1);

        //获取指定日期
        final LocalDate startDate = LocalDate.of(2021 , 6, 30);
        System.out.println(startDate);

        final LocalDateTime nowDateTime = LocalDateTime.now();
        System.out.println("当前日期时间："+nowDateTime);

        final LocalTime localTime = LocalTime.now();
        System.out.println("当前时间： "+localTime);
        final String format = nowDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss a"));
        System.out.println("当前日期时间 格式化"+format);

    }
}
