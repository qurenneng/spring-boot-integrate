package com.example.springboottaskintegrat;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

@SpringBootTest
class SpringBootTaskIntegratApplicationTests {


    public static void main(String[] args) {
//
////        System.out.println(getTime());
////        System.out.println(getYesterday());
//        String start = " 00:00:00";
//        String end = " 23:59:59";
////        Map<String, String> timeInterval = getTimeInterval(new Date());
        System.out.println(getFirstDayOfMonth());
        System.out.println(getLastDayOfMonth());

    }



    /**
     * 获取当前月第一天
     * @return
     */
    public static String getFirstDayOfMonth() {
        Calendar cal = Calendar.getInstance();
        //当前日期月份
        cal.add(Calendar.MONTH,0);
        //设置时间格式为yyyy-MM-dd HH:mm:ss
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        //设置当前时间,
        cal.setTime(new Date());
        int actualMinimum = cal.getActualMinimum(Calendar.DAY_OF_MONTH);
        cal.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONDAY),actualMinimum);
        return  sdf.format(cal.getTime());
    }


    /**
     * 获取当前月最后一天
     * @return
     */
    public static String getLastDayOfMonth() {
        Calendar cal = Calendar.getInstance();
        //当前日期月份
        cal.add(Calendar.MONTH,0);
        //设置时间格式为yyyy-MM-dd HH:mm:ss
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        //设置当前时间,
        cal.setTime(new Date());
        //获取到本月结束日
        int actualMaximum = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
        //设置本月结束日的年月日时分秒格式
        cal.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONDAY),actualMaximum);
        return  sdf.format(cal.getTime());
    }


    // 获得本月第一天0点时间
    public static Date getTimesMonthmorning() {
        Calendar cal = Calendar.getInstance();
        cal.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONDAY), cal.get(Calendar.DAY_OF_MONTH), 0, 0, 0);
        cal.set(Calendar.DAY_OF_MONTH, cal.getActualMinimum(Calendar.DAY_OF_MONTH));
        return cal.getTime();
    }

    // 获得本月最后一天24点时间
    public static Date getTimesMonthnight() {
        Calendar cal = Calendar.getInstance();
        cal.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONDAY), cal.get(Calendar.DAY_OF_MONTH), 0, 0, 0);
        cal.set(Calendar.DAY_OF_MONTH, cal.getActualMaximum(Calendar.DAY_OF_MONTH));
        cal.set(Calendar.HOUR_OF_DAY, 24);
        return cal.getTime();
    }

    public static String getTime() {
        Calendar calendar = Calendar.getInstance();
        Date date = calendar.getTime();
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String format = df.format(date);
        return format;
    }


    /**
     * 昨天
     * @return
     */
    public static String getYesterday() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, -1); //得到前一天
        Date date = calendar.getTime();
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String format = df.format(date);
        return format;
    }

    public static Map<String,String> getTimeInterval(Date date) {
       Map<String,String> map =new HashMap<>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int dayWeek = cal.get(Calendar.DAY_OF_WEEK);
        if (1 == dayWeek) {
            cal.add(Calendar.DAY_OF_MONTH, 0);
        }
        cal.setFirstDayOfWeek(Calendar.MONDAY);
        int day = cal.get(Calendar.DAY_OF_WEEK);
        cal.add(Calendar.DATE, cal.getFirstDayOfWeek() - day);
        String imptimeBegin = sdf.format(cal.getTime());
        cal.add(Calendar.DATE, 6);
        String imptimeEnd = sdf.format(cal.getTime());
        map.put("startTime",imptimeBegin);
        map.put("endTime",imptimeEnd);
        return map;
    }


}
