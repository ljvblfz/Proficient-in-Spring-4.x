package com.smart.oxm.xmlbeans;

import java.io.File;
import java.util.Calendar;
import com.smart.oxm.xmlbeans.UserType.Logs;

public class XmlbeansSample {
	/**
	 * JAVA对象转化为XML
	 */
	public static void objectToXml()throws Exception{
		try {
			//通过UsersDocument工厂类创建实例
			UsersDocument doc = UsersDocument.Factory.newInstance();
			//创建一个新用户
			UserType user = doc.addNewUsers().addNewUser();
			user.setUserName("xmlbeans");
			Logs logs =user.addNewLogs();
			LogType log1 = logs.addNewLoginLog();
			log1.setIp("192.168.1.91");
			log1.setLoginDate(Calendar.getInstance());
			LogType log2 = logs.addNewLoginLog();
			log2.setIp("192.168.1.92");
			log2.setLoginDate(Calendar.getInstance());
			LogType log3 = logs.addNewLoginLog();
			log3.setIp("192.168.1.93");
			log3.setLoginDate(Calendar.getInstance());
			File file = new File("XmlbeansSample.xml");
			doc.save(file);
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}
	/**
	 * XML转化为JAVA对象
	 */
	public static UserType[] xmlToObject()throws Exception{
		try {
			File xmlFile = new File("XmlbeansSample.xml");
			UsersDocument doc = UsersDocument.Factory.parse(xmlFile);
			UserType[] users = doc.getUsers().getUserArray();
			for (int i = 0; i < users.length; i++) {
				UserType user = users[i];
				Logs userlog = user.getLogs();
				LogType[] logs = userlog.getLoginLogArray();
				for(LogType log : logs){
					System.out.println("访问IP:" + log.getIp());
					System.out.println("访问时间:" + log.getLoginDate());
				}
			}
			return users;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}

	public static void main(String[] args)throws Exception {
		objectToXml();
		xmlToObject();
	}
}
