package com.founder.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {
	
	public static final String YMD = "yyyyMMdd";
	
	public static final String Y_M_D = "yyyy-MM-dd";
	
	public static final String Y_M_D_H_M_S = "yyyy-MM-dd HH:mm:ss";
	
	public static final String Y_M_D_H_M = "yyyy-MM-dd HH:mm:00";

	public static final String YMDHMS = "yyyyMMddHHmmss";
	
	public static SimpleDateFormat ymdsdf = new SimpleDateFormat("yyyy-MM-dd");
	
	public static SimpleDateFormat ymdhmsdf = new SimpleDateFormat(Y_M_D_H_M_S);
	
	public static String date2Str(Date date,String pattern) {
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		return sdf.format(date);
	}
	
	public static Date str2Date(String dateStr ,String pattern) {
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		Date currentDate = null;
		
		try {
			currentDate = sdf.parse(dateStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return currentDate;
	}
	
	/**
	 * @param date  日期
	 * @param day 天数
	 * 
	 * 获取几天前的日期
	 * @return
	 */
	public static Date getDateBefore(Date date , int day) {
		Calendar cal = Calendar.getInstance();
		if(date != null) 
			cal.setTime(date);
		
		cal.set(Calendar.DATE, cal.get(Calendar.DATE) - day);
		
		return cal.getTime();
		
	}
	
	/**
	 * @param date  日期
	 * @param day  天数
	 * 
	 * 获取几天后的日期
	 * @return
	 */
	public static Date getDateAfter(Date date , int day) {
		Calendar cal = Calendar.getInstance();
		
		if(date != null)
			cal.setTime(date);
		
		cal.set(Calendar.DATE, cal.get(Calendar.DATE) + day);
		
		return cal.getTime();
	}
	
	/**
	 * @param date 时间
	 * @param minutes 分钟数
	 * 获取分钟数之前的日期
	 * @return
	 */
	public static Date getDateBeforeOfMinutes(Date date , int minutes) {
		Calendar cal = Calendar.getInstance();
		if(date != null) 
			cal.setTime(date);
		
		cal.set(Calendar.MINUTE, cal.get(Calendar.MINUTE) - minutes);
		
		return cal.getTime();
	}
	
	/**
	 * @param date 时间
	 * @param minutes 分钟数
	 * 获取分钟数之前的日期
	 * @return
	 */
	public static Date getDateAfterOfMinutes(Date date , int minutes) {
		Calendar cal = Calendar.getInstance();
		if(date != null) 
			cal.setTime(date);
		
		cal.set(Calendar.MINUTE, cal.get(Calendar.MINUTE) + minutes);
		
		return cal.getTime();
	}
	
	
	/**
	 * @param date  日期
	 * @param pattern  格式
	 * 日期转字符串
	 * @return
	 */
	public static String getDateStr(Date date , String pattern) {
		
		if(date == null || pattern == null || "".equals(pattern.trim()))
			throw new IllegalArgumentException("入参错误 date [ " + date + " ] & pattern [ " + pattern + " ]");
		
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		return sdf.format(date);
	}
	
	/**
	 * 获取小时(24小时制)
	 * @param c
	 * @return
	 */
	public static int getHour(Date date){
		
		Calendar cal = Calendar.getInstance();
		if(date != null) 
			cal.setTime(date);
		return cal.get(Calendar.HOUR_OF_DAY );
	}
	
	/**
	 * 获取上月第一天
	 * @throws ParseException 
	 */
	public static Date getPreMFirstDay(){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar cal = Calendar.getInstance(); 
	    cal.setTime(new Date()); 
	    cal.add(Calendar.MONTH, -1);
	    cal.set(Calendar.DAY_OF_MONTH, 1); 
	    try {
			return sdf.parse(sdf.format(cal.getTime()));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    return null;
	}
	
	/**
	 * 获取上月最后一天
	 * @throws ParseException 
	 */
	public static Date getPreMLastDay(){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar cal = Calendar.getInstance(); 
	    cal.setTime(new Date()); 
	    cal.add(Calendar.MONTH, -1);
		cal.set(Calendar.DAY_OF_MONTH, 1); 
		cal.roll(Calendar.DAY_OF_MONTH, -1);  
	    try {
			return sdf.parse(sdf.format(cal.getTime()));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    return null;
	}
	
	
	/**
	 * 获取上上月第一天
	 * @throws ParseException 
	 */
	public static Date getPrePreMFirstDay(){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar cal = Calendar.getInstance(); 
	    cal.setTime(new Date()); 
	    cal.add(Calendar.MONTH, -2);
	    cal.set(Calendar.DAY_OF_MONTH, 1); 
	    try {
			return sdf.parse(sdf.format(cal.getTime()));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    return null;
	}
	
	/**
	 * 获取上上月最后一天
	 * @throws ParseException 
	 */
	public static Date getPrePreMLastDay(){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar cal = Calendar.getInstance(); 
	    cal.setTime(new Date()); 
	    cal.add(Calendar.MONTH, -2);
		cal.set(Calendar.DAY_OF_MONTH, 1); 
		cal.roll(Calendar.DAY_OF_MONTH, -1);  
	    try {
			return sdf.parse(sdf.format(cal.getTime()));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    return null;
	}
	
	
	/**
	 * 获取当月第一天
	 * @throws ParseException 
	 */
	public static Date getMFirstDay(){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar cal = Calendar.getInstance(); 
	    cal.setTime(new Date()); 
	    cal.set(Calendar.DAY_OF_MONTH, 1); 
	    try {
			return sdf.parse(sdf.format(cal.getTime()));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    return null;
	}
	
	/**
	 * 获取给定时间的下月第一天(eg:2016-05-16---->2016-06-01)
	 * @throws ParseException 
	 */
	public static Date getMFirstDay(Date date){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar cal = Calendar.getInstance(); 
	    cal.setTime(date); 
	    cal.add(Calendar.MONTH, 1);
	    cal.set(Calendar.DAY_OF_MONTH, 1); 
	    try {
			return sdf.parse(sdf.format(cal.getTime()));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    return null;
	}
	
	/**
	 * 获取当月最后一天
	 * @throws ParseException 
	 */
	public static Date getMLastDay(){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar cal = Calendar.getInstance(); 
	    cal.setTime(new Date()); 
		cal.set(Calendar.DAY_OF_MONTH, 1); 
		cal.roll(Calendar.DAY_OF_MONTH, -1);  
	    try {
			return sdf.parse(sdf.format(cal.getTime()));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    return null;
	}
	
	/**
	 * 获取下月第一天
	 * @throws ParseException 
	 */
	public static Date getNextMFirstDay(){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar cal = Calendar.getInstance(); 
	    cal.setTime(new Date()); 
	    cal.add(Calendar.MONTH, 1);
	    cal.set(Calendar.DAY_OF_MONTH, 1); 
	    try {
			return sdf.parse(sdf.format(cal.getTime()));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    return null;
	}
	
	/**
	 * 获取给定时间的下两个月第一天(eg:2016-05-16---->2016-07-01)
	 * @throws ParseException 
	 */
	public static Date getNextMFirstDay(Date date){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar cal = Calendar.getInstance(); 
	    cal.setTime(date); 
	    cal.add(Calendar.MONTH, 2);
	    cal.set(Calendar.DAY_OF_MONTH, 1); 
	    try {
			return sdf.parse(sdf.format(cal.getTime()));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    return null;
	}
	
	
	/**
	 * 格式化日期yyyy-MM-dd,返回String
	 * @param args
	 * @throws ParseException
	 */
	public static  String getDate(Date time){
		return new SimpleDateFormat(Y_M_D).format(time);
	}
	
	/**
	 * 格式化日期yyyy-MM-dd,返回Date
	 * @param args
	 * @throws ParseException
	 */
	public static  Date getDateForYMD(Date time){
		SimpleDateFormat sdf = new SimpleDateFormat(Y_M_D);
		try {
			return sdf.parse(sdf.format(time));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    return null;
	}
	
	/** 
     * 根据日期获得星期 几
     * @param date 
     * @return 
     */ 
	public static Integer getDayOfWeekChina(Date date) { 
	  Calendar calendar = Calendar.getInstance(); 
	  calendar.setTime(date); 
	  return calendar.get(Calendar.DAY_OF_WEEK) - 1 ==0? 7:calendar.get(Calendar.DAY_OF_WEEK) - 1; 
	 
	} 
	
	/** 
     * 根据日期获得一月的第几天
     * @param date 
     * @return 
     */ 
	public static Integer getDayOfMonthChina(Date date) { 
	  Calendar calendar = Calendar.getInstance(); 
	  calendar.setTime(date); 
	  return calendar.get(Calendar.DAY_OF_MONTH); 
	 
	} 
	
	
	/**
	 * 根据日期获取下几周的周几
	 * 例如：date = now, type =2 , dayOfWeek= 4
	 * 当前日期加两周的那周四
	 */
	public static Date getNextWeekDays(Date date , int type , int dayOfWeek){
		Calendar cal = Calendar.getInstance(); 
	    cal.setTime(date); 
	    cal.setFirstDayOfWeek(Calendar.MONDAY);
	    cal.add(Calendar.WEEK_OF_YEAR, type);
	    cal.set(Calendar.DAY_OF_WEEK, dayOfWeek+1); 
	    return cal.getTime();
	}
	
	/**
	 * 根据日期获取下几周的周日（中国的周）
	 * 
	 */
	public static Date getNextWeekSunday(Date date , int weekChange){
		Calendar cal = Calendar.getInstance(); 
	    cal.setTime(date); 
	    cal.add(Calendar.WEEK_OF_YEAR, weekChange+1);
	    cal.set(Calendar.DAY_OF_WEEK, 1); 
	    return cal.getTime();
	}
	
	/**
	 * 获取某个月的最后一天
	 * + 月加
	 * - 月减
	 * @throws ParseException 
	 */
	public static Date getMonthLastDay(Date date, int monthChange){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar cal = Calendar.getInstance(); 
	    cal.setTime(date); 
	    cal.add(Calendar.MONTH, monthChange);
		cal.set(Calendar.DAY_OF_MONTH, 1); 
		cal.roll(Calendar.DAY_OF_MONTH, -1);  
	    try {
			return sdf.parse(sdf.format(cal.getTime()));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    return null;
	}
	
	/**
	 * 获取某个月的第几天
	 * + 月加
	 * - 月减
	 * @throws ParseException 
	 */
	public static Date getSomeMonthSomeDay(Date date, int monthChange, int day){
		SimpleDateFormat sdf = new SimpleDateFormat(Y_M_D_H_M_S);
		Calendar cal = Calendar.getInstance(); 
	    cal.setTime(date); 
	    cal.add(Calendar.MONTH, monthChange);
		cal.set(Calendar.DAY_OF_MONTH, day); 
		//cal.roll(Calendar.DAY_OF_MONTH, -1);  
	    try {
			return sdf.parse(sdf.format(cal.getTime()));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    return null;
	}
	
	/**
	 * @param date  日期
	 * @param hour 小时数
	 * 
	 * 获取当前时间前hour个小时的开始时间
	 * @return
	 */
	public static Date getHourBegin(Date date , int hour) {
		Calendar cal = Calendar.getInstance();
		if(date != null) 
			cal.setTime(date);
		
		cal.set(Calendar.HOUR_OF_DAY, cal.get(Calendar.HOUR_OF_DAY) - hour);
		cal.set(Calendar.MINUTE,0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		return cal.getTime();
		
	}
	
	/**
	 * @param date  日期
	 * @param hour 小时数
	 * 
	 * 获取当前日期的的23:59:59
	 * @return
	 */
	public static Date getLastSecond(Date date) {
		Calendar cal = Calendar.getInstance();
		if(date != null) 
			cal.setTime(date);
		
		cal.set(Calendar.HOUR_OF_DAY, 23);
		cal.set(Calendar.MINUTE,59);
		cal.set(Calendar.SECOND, 59);
		cal.set(Calendar.MILLISECOND, 59);
		return cal.getTime();
		
	}
	
	/**
	 * 根据日期获取一年中的第几周
	 */
	public static int getWeeksNum(Date date){
		Calendar cal = Calendar.getInstance(); 
	    cal.setTime(date); 
	    cal.setFirstDayOfWeek(Calendar.MONDAY);
	    return cal.get(Calendar.WEEK_OF_YEAR);
	}
	
	/**
	 * 根据日期获取年份
	 */
	public static int getYear(Date date){
		Calendar cal = Calendar.getInstance(); 
	    cal.setTime(date); 
	    return cal.get(Calendar.YEAR);
	}
	
	/**
	 * 根据日期获取年份
	 */
	public static int getMonth(Date date){
		Calendar cal = Calendar.getInstance(); 
	    cal.setTime(date); 
	    return cal.get(Calendar.MONTH)+1;
	}
	
	public static Date getDateFormat(Date date,String format){
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		Calendar cal = Calendar.getInstance(); 
	    cal.setTime(date==null?new Date():date); 
	    try {
			return sdf.parse(sdf.format(cal.getTime()));
		} catch (ParseException e) {
			e.printStackTrace();
		}
	    return null;
	}
	
	
	public static void main(String[] args) throws ParseException {
/*		System.out.println(getPreMFirstDay());
		System.out.println(getPreMLastDay());
		System.out.println(getDateAfter(getPreMFirstDay(),1));
		System.out.println(getMFirstDay());
		System.out.println(getMLastDay());
		System.out.println(getPrePreMFirstDay());
		System.out.println(getPrePreMLastDay());*/
/*		System.out.println(getNextMFirstDay());
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String strDate = "2016-05-01";
		Date date=sdf.parse(strDate);
		System.out.println(getMFirstDay(date));
		System.out.println(getNextMFirstDay(date));*/
/*		Date yesterday  = DateUtil.getDateBefore(new Date(), -4);
		Date today = DateUtil.getDateAfter(new Date(), 0);
		System.out.println(getDateForYMD(yesterday));
		System.out.println(DateUtil.getDateAfter(today, 4));
		System.out.println(Integer.valueOf(String.valueOf(30315).substring(3)));*/
/*		System.out.println(getHourBegin(new Date(),0));
		System.out.println(getNextWeekDays(new Date(),-1,1));
		System.out.println(getNextWeekDays(new Date(),-1,7));
		System.out.println(getSomeMonthSomeDay(new Date(),0,15));*/
//		System.out.println(getLastSecond(new Date()));
//		System.out.println(DateUtil.str2Date("2017-04-24 00:00:00", DateUtil.Y_M_D_H_M_S));
//		System.out.println(DateUtil.getNextWeekDays(new Date(), 0, 1));
//		System.out.println(Integer.parseInt(String.valueOf("300615").substring(4)));
//		System.out.println(DateUtil.getDateAfter(new Date(), 0));
		
		System.out.println(getWeeksNum(DateUtil.str2Date("2017-10-30 00:00:00", DateUtil.Y_M_D_H_M_S)));
		System.out.println(getMonth(DateUtil.str2Date("2017-02-01 00:00:00", DateUtil.Y_M_D_H_M_S)));
		System.out.println(getYear(new Date()));
		Date currentTime = new Date();
		System.out.println(getDateAfter(currentTime, 1));
		System.out.println(getDateFormat(currentTime, DateUtil.Y_M_D_H_M));
		
		System.out.println(getDateForYMD(new Date()));
	}
}
