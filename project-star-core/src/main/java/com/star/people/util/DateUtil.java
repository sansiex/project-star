package com.star.people.util;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by zuhai.jiang on 2016/1/2.
 */
public class DateUtil {
    public static SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");
    public static SimpleDateFormat DATETIME_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static String formatDate(Date date){
        return DATE_FORMAT.format(date);
    }

    public static String formatDatetime(Date date){
        return DATETIME_FORMAT.format(date);
    }

    public static Date toDate(String str){
        return DATE_FORMAT.parse(str, new ParsePosition(0));
    }

    public static Date toDate(String str, SimpleDateFormat format){
        return format.parse(str, new ParsePosition(0));
    }
}
