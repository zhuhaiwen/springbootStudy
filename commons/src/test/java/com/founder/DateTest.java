package com.founder;

import com.founder.utils.DateUtil;

import java.util.Date;

/**
 * @author zhuhw
 * @date 2018/7/19 14:18
 */
public class DateTest {
    public static void main(String[] args) {
//        Date currentDate = DateUtil.getDateForYMD(new Date());
//        System.out.println(currentDate.toLocaleString());
//        Date beginTime = DateUtil.getDateBefore(currentDate, 0);//任务结束后把这个改为0即可
//        System.out.println(beginTime.toLocaleString());
//        Date endTime = DateUtil.getDateAfter(currentDate, 1);
//        System.out.println(endTime.toLocaleString());

//        Date tt = new Date();
//        StringBuffer buf = new StringBuffer();
//        Calendar cal =Calendar.getInstance();
//        cal.setTime(tt);
//        int i1 = cal.get(Calendar.YEAR);
//        int i2 = cal.get(Calendar.MONTH) + 1;
//        int i3 = cal.get(Calendar.DAY_OF_MONTH);
//        System.out.println(i1 + "," + i2 + "," + i3);

        Date currentDate = new Date();
        Date beginTime = DateUtil.getNextWeekDays(currentDate, -1, 1);
        Date endTime = DateUtil.getNextWeekDays(currentDate, 0, 1);

        System.out.println(beginTime.toLocaleString() + ":" + endTime.toLocaleString());
    }
}
