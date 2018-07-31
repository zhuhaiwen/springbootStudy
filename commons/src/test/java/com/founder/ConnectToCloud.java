package com.founder;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author zhuhw
 * @date 2018/6/26 18:32
 */
public class ConnectToCloud {
    public static void main(String[] args) {
        Date now = new Date();
        System.out.println(getNextWeekDays(now, -1,1).toLocaleString());
        System.out.println(getNextWeekDays(now, 0,1).toLocaleString());
        System.out.println(getSomeMonthSomeDay(now, -1,1).toLocaleString());
        System.out.println(getSomeMonthSomeDay(now, 0,1).toLocaleString());

    }

    public static Date getNextWeekDays(Date date , int type , int dayOfWeek){
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.setFirstDayOfWeek(Calendar.MONDAY);
        cal.add(Calendar.WEEK_OF_YEAR, type);
        cal.set(Calendar.DAY_OF_WEEK, dayOfWeek+1);
        return cal.getTime();
    }

    public static Date getSomeMonthSomeDay(Date date, int monthChange, int day){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.MONTH, monthChange);
        cal.set(Calendar.DAY_OF_MONTH, day);
        try {
            return sdf.parse(sdf.format(cal.getTime()));
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }
}
