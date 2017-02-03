package com.smart.i18n;

import java.text.DateFormat;
import java.text.MessageFormat;
import java.text.NumberFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.ResourceBundle;

public class LocaleSample {
	public static void numberFormat() {
		Locale locale = new Locale("zh", "CN");
		NumberFormat currFmt = NumberFormat.getCurrencyInstance(locale);
		double amt = 123456.78;
		System.out.println(currFmt.format(amt));
	}
	public static void dateFormat() {
		Locale locale = new Locale("en", "US");
		Date date = new Date();
		DateFormat df = DateFormat.getDateInstance(DateFormat.MEDIUM, locale);
		System.out.println(df.format(date));
	}

	public static void messageFormat1() {
		Object[] params = {"John", new GregorianCalendar().getTime(),1.0E3};
		String pattern1 = "{0}，你好！你于{1}在工商银行存入{2} 元。";
		String pattern2 = "At {1,time,short} On{1,date,long}，{0} paid {2,number,currency}.";
		
		String msg1 = MessageFormat.format(pattern1,params);
		MessageFormat mf = new MessageFormat(pattern2,Locale.US);
		String msg2 = mf.format(params);
		System.out.println(msg1);
		System.out.println(msg2);
	}
	
	public static void resourceBoundle(){
		ResourceBundle rb1 = ResourceBundle.getBundle("com/smart/i18n/resource",Locale.US);
		ResourceBundle rb2 = ResourceBundle.getBundle("com/smart/i18n/resource",Locale.CANADA);
		System.out.println("us:"+rb1.getString("greeting.common"));
		System.out.println("cn:"+rb2.getString("greeting.common"));
	}
	
	public static void resourceBoundleFmt(){
		ResourceBundle rb1 = ResourceBundle.getBundle("com/smart/i18n/fmt_resource",Locale.US);
		ResourceBundle rb2 = ResourceBundle.getBundle("com/smart/i18n/fmt_resource",Locale.CHINA);
		Object[] params = {"John", new GregorianCalendar().getTime()};
		
		String str1 = new MessageFormat(rb1.getString("greeting.common"),Locale.US).format(params);
		String str2 =new MessageFormat(rb2.getString("greeting.morning"),Locale.CHINA).format(params);
		String str3 =new MessageFormat(rb2.getString("greeting.afternoon"),Locale.CHINA).format(params);
		System.out.println(str1);
		System.out.println(str2);
		System.out.println(str3);
	}	
	public static void main(String[] args) {
		numberFormat();
		dateFormat();
		messageFormat1();
		resourceBoundle();
		resourceBoundleFmt();
	}
}
