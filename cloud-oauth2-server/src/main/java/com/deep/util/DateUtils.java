package com.deep.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class DateUtils {
	private static final Logger log = LoggerFactory
			.getLogger(DateUtils.class);
	private static final SimpleDateFormat datetimeFormat = new SimpleDateFormat(
		"yyyy-MM-dd HH:mm:ss");
	private static final SimpleDateFormat dateFormat = new SimpleDateFormat(
		"yyyy-MM-dd");
	private static final SimpleDateFormat timeFormat = new SimpleDateFormat(
		"HH:mm:ss");
	private static final SimpleDateFormat weekFormat = new SimpleDateFormat(
		"EEEE");
	private static final SimpleDateFormat dayFormat = new SimpleDateFormat(
			"M月d日");
	private static final SimpleDateFormat dayHourFormat = new SimpleDateFormat(
			"M月d日H点");
	private static final SimpleDateFormat dayHourMixFormat = new SimpleDateFormat(
			"M月d日HH:mm");	
	private static final SimpleDateFormat monthFormat = new SimpleDateFormat(
			"yyyyMM");
	private static final SimpleDateFormat simpleDateFormat = new SimpleDateFormat(
			"yyyyMMdd");	

	/**
	 * 获得当前日期时间
	 * <p>
	 * 日期时间格式yyyy-MM-dd HH:mm:ss
	 * 
	 * @return
	 */
	public static String currentDatetime() {
		return datetimeFormat.format(now());
	}

	/** yyyyMM
	 * @return
	 */
	public static String currentMonth() {
		return monthFormat.format(now());
	}
	
	/**
	 * 格式化日期时间
	 * <p>
	 * 日期时间格式yyyy-MM-dd HH:mm:ss
	 * 
	 * @return
	 */
	public static String formatDatetime(Date date) {
		return datetimeFormat.format(date);
	}

	
	public static String formatSimpleDatetime(Date date) {
		return simpleDateFormat.format(date);
	}
	/**
	 * 格式化日期时间
	 * 
	 * @param date
	 * @param pattern
	 *            格式化模式，详见{@link SimpleDateFormat}构造器
	 *            <code>SimpleDateFormat(String pattern)</code>
	 * @return
	 */
	public static String formatDatetime(Date date, String pattern) {
		SimpleDateFormat customFormat = (SimpleDateFormat) datetimeFormat
		.clone();
		customFormat.applyPattern(pattern);
		return customFormat.format(date);
	}

	/**
	 * 获得当前日期
	 * <p>
	 * 日期格式yyyy-MM-dd
	 * 
	 * @return
	 */
	public static String currentDate() {
		return dateFormat.format(now());
	}

	/**
	 * 格式化日期
	 * <p>
	 * 日期格式yyyy-MM-dd
	 * 
	 * @return
	 */
	public static String formatDate(Date date) {
		return dateFormat.format(date);
	}
	
	/**
	 * 格式化日期
	 * <p>
	 * 日期格式M月d日
	 * 
	 * @return
	 */
	public static String formatDay(Date date) {
		return dayFormat.format(date);
	}

	/**
	 * 格式化日期
	 * <p>
	 * 日期格式M月d日H点
	 * 
	 * @return
	 */
	public static String formatDayHour(Date date) {
		return dayHourFormat.format(date);
	}
	
	public static String formatMixDayHour(Date date) {
		return dayHourMixFormat.format(date);
	}
	/**
	 * 获得当前时间
	 * <p>
	 * 时间格式HH:mm:ss
	 * 
	 * @return
	 */
	public static String currentTime() {
		return timeFormat.format(now());
	}

	/**
	 * 格式化时间
	 * <p>
	 * 时间格式HH:mm:ss
	 * 
	 * @return
	 */
	public static String formatTime(Date date) {
		return timeFormat.format(date);
	}

	/**
	 * 获得当前时间的<code>java.util.Date</code>对象
	 * 
	 * @return
	 */
	public static Date now() {
		return new Date();
	}

	public static Calendar calendar() {
		Calendar cal = GregorianCalendar.getInstance(Locale.CHINESE);
		cal.setFirstDayOfWeek(Calendar.MONDAY);
		return cal;
	}

	/**
	 * 获得当前时间的毫秒数
	 * <p>
	 * 详见{@link System#currentTimeMillis()}
	 * 
	 * @return
	 */
	public static long millis() {
		return System.currentTimeMillis();
	}

	/**
	 * 
	 * 获得当前Chinese年份
	 * 
	 * @return
	 */
	public static int year() {
		return calendar().get(Calendar.YEAR);
	}
	
	/**
	 * 
	 * 获得当前Chinese月份
	 * 
	 * @return
	 */
	public static int month() {
		return calendar().get(Calendar.MONTH) + 1;
	}

	/**
	 * 获得月份中的第几天
	 * 
	 * @return
	 */
	public static int dayOfMonth() {
		return calendar().get(Calendar.DAY_OF_MONTH);
	}

	/**
	 * 今天是星期的第几天
	 * 
	 * @return
	 */
	public static int dayOfWeek() {
		return calendar().get(Calendar.DAY_OF_WEEK);
	}

	/**
	 * 今天是年中的第几天
	 * 
	 * @return
	 */
	public static int dayOfYear() {
		return calendar().get(Calendar.DAY_OF_YEAR);
	}

	/**
	 * 判断原日期是否在目标日期之前
	 * 
	 * @param src
	 * @param dst
	 * @return
	 */
	public static boolean isBefore(Date src, Date dst) {
		return src.before(dst);
	}

	/**
	 * 判断原日期是否在目标日期之后
	 * 
	 * @param src
	 * @param dst
	 * @return
	 */
	public static boolean isAfter(Date src, Date dst) {
		return src.after(dst);
	}

	/**
	 * 判断两日期是否相同
	 * 
	 * @param date1
	 * @param date2
	 * @return
	 */
	public static boolean isEqual(Date date1, Date date2) {
		return date1.compareTo(date2) == 0;
	}

	/**
	 * 判断某个日期是否在某个日期范围
	 * 
	 * @param beginDate
	 *            日期范围开始
	 * @param endDate
	 *            日期范围结束
	 * @param src
	 *            需要判断的日期
	 * @return
	 */
	public static boolean between(Date beginDate, Date endDate, Date src) {
		return beginDate.before(src) && endDate.after(src);
	}

	/**
	 * 获得当前月的最后一天
	 * <p>
	 * HH:mm:ss为0，毫秒为999
	 * 
	 * @return
	 */
	public static Date lastDayOfMonth() {
		Calendar cal = calendar();
		cal.set(Calendar.DAY_OF_MONTH, 1); // M月置零
		cal.set(Calendar.HOUR_OF_DAY, 0);// H置零
		cal.set(Calendar.MINUTE, 0);// m置零
		cal.set(Calendar.SECOND, 0);// s置零
		cal.set(Calendar.MILLISECOND, 0);// S置零
		int n = cal.get(Calendar.MONTH);
		cal.set(Calendar.MONTH, cal.get(Calendar.MONTH) + 1);// 月份+1
		cal.set(Calendar.MILLISECOND, -1);// 毫秒-1
		return cal.getTime();
	}

	/**
	 * 获得当前月的第一天
	 * <p>
	 * HH:mm:ss SS为零
	 * 
	 * @return
	 */
	public static Date firstDayOfMonth() {
		Calendar cal = calendar();
		cal.set(Calendar.DAY_OF_MONTH, 1); // M月置1
		cal.set(Calendar.HOUR_OF_DAY, 0);// H置零
		cal.set(Calendar.MINUTE, 0);// m置零
		cal.set(Calendar.SECOND, 0);// s置零
		cal.set(Calendar.MILLISECOND, 0);// S置零
		return cal.getTime();
	}
	/**
	 * 获得当前月的第一天
	 * <p>
	 * HH:mm:ss SS为零
	 * 
	 * @return
	 */
	public static Date firstDayOfCurrMonth() {
		Calendar cal=Calendar.getInstance();
		cal.set(Calendar.DAY_OF_MONTH, 1); // M月置1
		cal.set(Calendar.HOUR_OF_DAY, 0);// H置零
		cal.set(Calendar.MINUTE, 0);// m置零
		cal.set(Calendar.SECOND, 0);// s置零
		cal.set(Calendar.MILLISECOND, 0);// S置零
		return cal.getTime();
	}
	
	public static Date firstDayOfLastMonth() {
		Calendar cal=Calendar.getInstance();
		cal.set(Calendar.DAY_OF_MONTH, 1); // M月置1
		cal.set(Calendar.HOUR_OF_DAY, 0);// H置零
		cal.set(Calendar.MINUTE, 0);// m置零
		cal.set(Calendar.SECOND, 0);// s置零
		cal.set(Calendar.MILLISECOND, 0);// S置零
		cal.set(Calendar.MONTH, cal.get(Calendar.MONTH) - 1);// 月份-1
		return cal.getTime();
	}
	/**
	 * 获得当前周的第一天(按照中国习惯，周一为一周的第一天)
	 * <p>
	 * HH:mm:ss SS为零
	 * @return
	 */
	public static Date firstDayOfCurrWeek() {
		Calendar cal = new GregorianCalendar();
		cal.setFirstDayOfWeek(Calendar.MONDAY);
		cal.setTime(Calendar.getInstance().getTime());
		cal.set(Calendar.DAY_OF_WEEK, cal.getFirstDayOfWeek()); // Monday
		cal.set(Calendar.HOUR_OF_DAY, 0);// H置零
		cal.set(Calendar.MINUTE, 0);// m置零
		cal.set(Calendar.SECOND, 0);// s置零
		cal.set(Calendar.MILLISECOND, 0);// S置零
		return cal.getTime();
	}
	
	/**
	 * 获得当前周的最后一天(按照中国习惯，周一为一周的第一天)
	 * <p>
	 * HH:mm:ss SS为零
	 * @return
	 */
	public static Date lastDayOfCurrWeek() {
		Calendar cal = new GregorianCalendar();
		cal.setFirstDayOfWeek(Calendar.MONDAY);
		cal.setTime(Calendar.getInstance().getTime());
		cal.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY); // sunday
		cal.set(Calendar.HOUR_OF_DAY, 23);// H置零
		cal.set(Calendar.MINUTE, 59);// m置零
		cal.set(Calendar.SECOND, 59);// s置零
		cal.set(Calendar.MILLISECOND, 0);// S置零
		return cal.getTime();
	}
	
	private static Date weekDay(int week) {
		Calendar cal = calendar();
		cal.set(Calendar.DAY_OF_WEEK, week);
		return cal.getTime();
	}

	/**
	 * 获得周五日期
	 * <p>
	 * 注：日历工厂方法{@link #calendar()}设置类每个星期的第一天为Monday，US等每星期第一天为sunday
	 * 
	 * @return
	 */
	public static Date friday() {
		return weekDay(Calendar.FRIDAY);
	}

	/**
	 * 获得周六日期
	 * <p>
	 * 注：日历工厂方法{@link #calendar()}设置类每个星期的第一天为Monday，US等每星期第一天为sunday
	 * 
	 * @return
	 */
	public static Date saturday() {
		return weekDay(Calendar.SATURDAY);
	}

	/**
	 * 获得周日日期
	 * <p>
	 * 注：日历工厂方法{@link #calendar()}设置类每个星期的第一天为Monday，US等每星期第一天为sunday
	 * 
	 * @return
	 */
	public static Date sunday() {
		return weekDay(Calendar.SUNDAY);
	}

	/**
	 * 将字符串日期时间转换成java.util.Date类型
	 * <p>
	 * 日期时间格式yyyy-MM-dd HH:mm:ss
	 * 
	 * @param datetime
	 * @return
	 */
	public static Date parseDatetime(String datetime) throws ParseException {
		return datetimeFormat.parse(datetime);
	}

	/**
	 * 将字符串日期转换成java.util.Date类型
	 * <p>
	 * 日期时间格式yyyy-MM-dd
	 * 
	 * @param date
	 * @return
	 * @throws ParseException
	 */
	public static Date parseDate(String date) throws ParseException {
		SimpleDateFormat df = new SimpleDateFormat(
				"yyyy-MM-dd");
		return df.parse(date);
	}

	/**
	 * 将字符串日期转换成java.util.Date类型
	 * <p>
	 * 时间格式 HH:mm:ss
	 * 
	 * @param time
	 * @return
	 * @throws ParseException
	 */
	public static Date parseTime(String time) throws ParseException {
		return timeFormat.parse(time);
	}

	/**
	 * 根据自定义pattern将字符串日期转换成java.util.Date类型
	 * 
	 * @param datetime
	 * @param pattern
	 * @return
	 * @throws ParseException
	 */
	public static Date parseDatetime(String datetime, String pattern)
	throws ParseException {
		SimpleDateFormat format = (SimpleDateFormat) datetimeFormat.clone();
		format.applyPattern(pattern);
		return format.parse(datetime);
	}

	/**
	 * 获得指定日期的前一天
	 * 
	 * @param specifiedDay
	 * @return
	 * @throws Exception
	 */
	public static String getSpecifiedDayBefore(String specifiedDay) {
		Calendar c = Calendar.getInstance();
		Date date = null;
		try {
			date = new SimpleDateFormat("yy-MM-dd").parse(specifiedDay);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		c.setTime(date);
		int day = c.get(Calendar.DATE);
		c.set(Calendar.DATE, day - 1);

		String dayBefore = new SimpleDateFormat("yyyy-MM-dd").format(c
			.getTime());
		return dayBefore;
	}
	/**
	 * 获得指定日期的前n天
	 * 
	 * @param specifiedDay
	 * @return
	 * @throws Exception
	 */
	public static String getSpecifiedDayBefore(String specifiedDay,int differ) {
		Calendar c = Calendar.getInstance();
		Date date = null;
		try {
			date = new SimpleDateFormat("yy-MM-dd").parse(specifiedDay);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		c.setTime(date);
		int day = c.get(Calendar.DATE);
		c.set(Calendar.DATE, day - differ);

		String dayBefore = new SimpleDateFormat("yyyy-MM-dd").format(c
			.getTime());
		return dayBefore;
	}
	
	/**
	 * 获得指定日期的前n天
	 * 
	 * @param specifiedDay
	 * @return
	 * @throws Exception
	 */
	public static String getSpecifiedDayStrBefore(Date specifiedDay,int differ) {
		String dayBefore = new SimpleDateFormat("yyyy-MM-dd").format(getSpecifiedDayBefore(specifiedDay,differ));
		return dayBefore;
	}
	/**
	 * 获得指定日期的前n天
	 * 
	 * @param specifiedDay
	 * @return
	 * @throws Exception
	 */
	public static Date getSpecifiedDayBefore(Date specifiedDay,int differ) {
		Calendar c = Calendar.getInstance();
		Date date = specifiedDay;
		c.setTime(date);
		int day = c.get(Calendar.DATE);
		c.set(Calendar.DATE, day - differ);
		return c.getTime();
	}
	/**
	 * 获得指定日期的后一天
	 * 
	 * @param specifiedDay
	 * @return
	 */
	public static Date getSpecifiedDayAfter(Date specifiedDay) {
		Calendar c = Calendar.getInstance();

		c.setTime(specifiedDay);
		int day = c.get(Calendar.DATE);
		c.set(Calendar.DATE, day + 1);

		return c.getTime();
	}
	/**
	 * 获得指定日期的后n天
	 * 
	 * @param specifiedDay
	 * @return
	 */
	public static Date getSpecifiedDayAfter(Date specifiedDay,int differ) {
		Calendar c = Calendar.getInstance();

		c.setTime(specifiedDay);
		int day = c.get(Calendar.DATE);
		c.set(Calendar.DATE, day + differ);

		return c.getTime();
	}
	
	/** 取23点59分59秒
	 * @param specifiedDay
	 * @param differ
	 * @return
	 */
	public static Date getSpecifiedDayEndAfter(Date specifiedDay,int differ) {
		Calendar c = Calendar.getInstance();

		c.setTime(specifiedDay);
		int day = c.get(Calendar.DATE);
		c.set(Calendar.DATE, day + differ);
        c.set(Calendar.HOUR_OF_DAY, 23);  
        c.set(Calendar.MINUTE, 59);  
        c.set(Calendar.SECOND, 59);  
        c.set(Calendar.MILLISECOND, 0);

		return c.getTime();
	}
	
	public static Date getDayEnd(Date date) {
		Calendar c = Calendar.getInstance();

		c.setTime(date);
		int day = c.get(Calendar.DATE);
		c.set(Calendar.DATE, day);
        c.set(Calendar.HOUR_OF_DAY, 23);  
        c.set(Calendar.MINUTE, 59);  
        c.set(Calendar.SECOND, 59);  
        c.set(Calendar.MILLISECOND, 0);

		return c.getTime();
	}
	
	public static Date getSpecifiedDayAfterYear(Date specifiedDay,int differYear) {
		Calendar c = Calendar.getInstance();

		c.setTime(specifiedDay);
		int year = c.get(Calendar.YEAR);
		c.set(Calendar.YEAR, year + differYear);

		return c.getTime();
	}
	
	
	

	
	/** 返回从今天开始的一周
	 * @return
	 */
	public static List<String> getWeekBeginWithToday()
	{
		List<String> list = new ArrayList<String>();
		Date today = new Date();
		for(int i=0;i<7;i+=1)
		{
			list.add(weekFormat.format(today));
			today = getSpecifiedDayAfter(today);
		}
		return list;
	}

	/**	oDate-fDate 算出相差天數
	 * @param fDate
	 * @param oDate
	 * @return
	 */
	public static int dayDiffer(Date fDate, Date oDate) {
		if (null == fDate || null == oDate) {
			return -1;
		}
		long intervalMilli = oDate.getTime() - fDate.getTime();
		return (int) (intervalMilli / (24 * 60 * 60 * 1000));
	}
	
	/**
	 * 得到当前周的开始日期和结束日期，以周一为起始，0是起始日期，1结束日期
	 * @return
	 * @author <p>Innate Solitary 于 2012-3-8 下午12:16:09</p>
	 */
	public static Date[] getStartAndEndDateForWeek() {
		Date[] dates = new Date[2];
		Calendar startCalendar = calendar();
		setCalendar(startCalendar, null, null, null, 0, 0, 0, 0);
		startCalendar.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
		Calendar endCalendar = calendar();
		endCalendar.add(endCalendar.get(Calendar.WEEK_OF_MONTH), 1);
		setCalendar(endCalendar, null, endCalendar.get(Calendar.MONDAY), null, 0, 0, 0, -1);
		dates[0] = startCalendar.getTime();
		dates[1] = endCalendar.getTime();
		return dates;
	}
	
	/**
	 * 得到当前季度的第一天和最后一天
	 * @return
	 */
	public static Date[] getStartAndEndDateForQuarter() {
		Date[] dates = new Date[2];
		Calendar cal = calendar();
		int curMonth = cal.get(Calendar.MONTH);
		int curQuarter = (curMonth + 1) / 3 + 1;
		int endMonth = curQuarter * 3 - 1;
		int startMonth = endMonth - 2;
		Calendar startCal = calendar();
		setCalendar(startCal, null, startMonth, 1, 0, 0, 0, 0);
		Calendar endCal = calendar();
		setCalendar(endCal, null, endMonth + 1, 1, 0, 0, 0, -1);
		dates[0] = startCal.getTime();
		dates[1] = endCal.getTime();
		return dates;
	}
	
	/**
	 * 得到今天的起始和结束实现
	 * @return
	 */
	public static Date[] getStartAndEndDateForToday() {
		Date[] dates = new Date[2];
		Calendar startCal = calendar();
		setCalendar(startCal, null, null, null, 0, 0, 0, 0);
		Calendar endCal = calendar();
		setCalendar(endCal, null, null, endCal.get(Calendar.DAY_OF_MONTH) + 1, 0 , 0, 0, -1);
		dates[0] = startCal.getTime();
		dates[1] = endCal.getTime();
		return dates;
	}
	
	public static Date getTodayEnd() {
		Calendar endCal = calendar();
		setCalendar(endCal, null, null, endCal.get(Calendar.DAY_OF_MONTH) + 1, 0 , 0, 0, -1);
		return endCal.getTime();
	}	
	
	/**
	 * 得到明天的起始和结束实现
	 * @return
	 */
	public static Date[] getStartAndEndDateForTomorrow() {
		Date[] dates = new Date[2];
		Calendar startCal = calendar();
		setCalendar(startCal, null, null, startCal.get(Calendar.DAY_OF_MONTH) + 1, 0, 0, 0, 0);
		Calendar endCal = calendar();
		setCalendar(endCal, null, null, endCal.get(Calendar.DAY_OF_MONTH) + 2, 0 , 0, 0, -1);
		dates[0] = startCal.getTime();
		dates[1] = endCal.getTime();
		return dates;
	}
	
	/**
	 * cal不能为空，其他的值如果为空则不设置
	 * @param cal
	 * @param year
	 * @param month
	 * @param dayOfMonth
	 * @param hourOfMonth
	 * @param minute
	 * @param second
	 * @param millisecond
	 * @author <p>Innate Solitary 于 2012-3-29 上午9:44:21</p>
	 * @formatter:off
	 */
	public static void setCalendar(Calendar cal, Integer year, Integer month, Integer dayOfMonth, Integer hourOfDay, Integer minute, Integer second, Integer millisecond) {
		if(cal == null) {
			throw new IllegalArgumentException("参数 cal[Calendar] 不能为空");
		}
		
		if (year != null) {
	        cal.set(Calendar.YEAR, year);
        }
		if (month != null) {
	        cal.set(Calendar.MONTH, month);
        }
		if (dayOfMonth != null) {
	        cal.set(Calendar.DAY_OF_MONTH, dayOfMonth);
        }
		if (hourOfDay != null) {
	        cal.set(Calendar.HOUR_OF_DAY, hourOfDay);
        }
		if (minute != null) {
	        cal.set(Calendar.MINUTE, minute);
        }
		if (second != null) {
	        cal.set(Calendar.SECOND, second);
        }
		if (millisecond != null) {
	        cal.set(Calendar.MILLISECOND, millisecond);
        }
	}
	
	/**两者返回较早的日期
	 * @param date1
	 * @param date2
	 * @return
	 */
	public static Date getEarlierDate(Date date1,Date date2)
	{
		if(date1.before(date2))
		{
			return date1;
		}
		return date2;
	}
	
	/**两者返回较晚的日期
	 * @param date1
	 * @param date2
	 * @return
	 */
	public static Date getLaterDate(Date date1,Date date2)
	{
		if(date1.after(date2))
		{
			return date1;
		}
		return date2;
	}
	
	public static Date getNowDate(){
		Date nowDate = null;
		String curDate = DateUtils.currentDate();
		try {
			nowDate = DateUtils.parseDate(curDate);
		} catch (ParseException e) {
			log.info(curDate);
			e.printStackTrace();
		}
		return nowDate;
	}
	
	public static Date getLastDate()
	{
		Date lastDate = null;
		try {
			lastDate =DateUtils.getSpecifiedDayBefore(DateUtils.parseDate( DateUtils.currentDate()), 1);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return lastDate;
	}
	
	public static int getYear(Date date)
	{
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		return cal.get(Calendar.YEAR);
	}
	
	public static int getMonth(Date date)
	{
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		return cal.get(Calendar.MONTH)+1;
	}
	
	public static int getHourOfDay(Date date)
	{
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		return cal.get(Calendar.HOUR_OF_DAY);
	}
	
	public static int getDayOfMonth(Date date)
	{
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		return cal.get(Calendar.DAY_OF_MONTH);
	}
	
	public static int getMinute(Date date)
	{
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		return cal.get(Calendar.MINUTE);
	}
	
	public static Date[] getStartAndEndDateForYearAndMonth(int year,int month) {
		Date[] dates = new Date[2];
		Calendar startCal = calendar();
		setCalendar(startCal, year, month-1, 1, 0, 0, 0, 0);
		if(month>11)
		{
			year+=1;
			month=0;
		}
		Calendar endCal = calendar();
		setCalendar(endCal, year, month, 1, 0 , 0, 0, 0);
		dates[0] = startCal.getTime();
		dates[1] = endCal.getTime();
		return dates;
	}
	
	public static Boolean startOfDay(Date inputTime)
	{
		try
		{
			String d = DateUtils.formatDatetime(inputTime);
			Date startOfDay = DateUtils.parseDate(d);
			if(inputTime.compareTo(startOfDay)==0)
			{
				return true;
			}
		}
		catch(Exception e)
		{
			log.info(e.toString());
		}
		return false;
	}
	
	public static Boolean startOfDay(String inputTime)
	{
		try
		{
			Date date = DateUtils.parseDatetime(inputTime);
			Date startOfDay = DateUtils.parseDate(inputTime);
			if(date.equals(startOfDay))
			{
				return true;
			}
		}
		catch(Exception e)
		{
			log.info(e.toString());
		}
		return false;
	}
	
	
	public static String formatSeconds(Integer seconds){
		String t="";
		int hh = seconds/3600;
		int mm = (seconds-hh*3600)/60;
		int ss = seconds%60;
		if (hh <10) {
			t += "0";
		}
		t += hh+":";
		if (mm <10) {
			t+="0";
		}
		t += mm+":";
		if (ss<10) {
			t+="0";
		}
		t += ss;
		return t;
	}
	
	/**
	 * 获得指定日期前N分钟
	 * 
	 * @param specifiedDay
	 * @return
	 */
	public static Date getTimeBeforeMinute(Date specifiedDay,int minute) {
		Calendar c = Calendar.getInstance();

		c.setTime(specifiedDay);
		c.add(Calendar.MINUTE, -1*minute);
		return c.getTime();
	}
	public static void main(String args[]) throws Exception{
		/*
		 * Date curDate = parseDate(currentDate());
		 * 
		 * System.out.println(DateUtils.getSpecifiedDayAfter(curDate,4));
		 * //System.out.println(DateUtils.formatDatetime(dates[1]));
		 * System.out.println(getNowDate().toString());
		 */
/*		Date date = firstDayOfCurrMonth();
		
		//Date date2 = firstDayOfCurrWeek();
		Date date2 = firstDayOfLastMonth();
		System.out.println(date);
		System.out.println(date2);
		System.out.println(getYear(date2));
		System.out.println(getMonth(date2));*/
/*		
		Date[] dates = getStartAndEndDateForYearAndMonth(2013,5);
		System.out.println(DateUtils.formatDatetime(dates[0]));
		System.out.println(DateUtils.formatDatetime(dates[1]));*/
		
/*		Date nowDate = DateUtils.getNowDate();
		System.out.println(getSpecifiedDayAfterYear(nowDate,2));*/
		Date[] dates2 = DateUtils.getStartAndEndDateForTomorrow();
		System.out.println(DateUtils.formatDatetime(dates2[0]));
		System.out.println(DateUtils.formatDatetime(dates2[1]));
		
		Date date = DateUtils.getTimeBeforeMinute(new Date(), 120);
		System.out.println(DateUtils.formatDatetime(date));
		//System.out.println(DateUtils.startOfDay(DateUtils.formatDatetime(DateUtils.now())));
		
	}
}