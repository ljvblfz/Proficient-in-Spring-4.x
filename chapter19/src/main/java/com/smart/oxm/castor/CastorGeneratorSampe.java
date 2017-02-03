package com.smart.oxm.castor;

import java.io.FileReader;
import java.io.FileWriter;
import org.exolab.castor.types.Date;
import com.smart.domain.castor.LoginLog;
import com.smart.domain.castor.Logs;
import com.smart.domain.castor.User;

public class CastorGeneratorSampe {
	
	public static User getUser(){
		LoginLog log1 = new LoginLog();
		log1.setIp("192.168.1.91");
		log1.setLoginDate(new Date());
		LoginLog log2 = new LoginLog();
		log2.setIp("192.168.1.92");
		log2.setLoginDate(new Date());
		LoginLog log3 = new LoginLog();
		log3.setIp("192.168.1.93");
		log3.setLoginDate(new Date());
		User user = new User();
		Logs logs = new Logs();
		user.setUserName("castor");
		user.setLogs(logs);
		user.getLogs().addLoginLog(log1);
		user.getLogs().addLoginLog(log2);
		user.getLogs().addLoginLog(log3);
		return user;
	}

	/**
	 * JAVA对象转换为XML
	 */
	public static void objectToXml() {
		try {
			User user = getUser();
			FileWriter writer = new FileWriter("D:\\masterSpring\\chapter14\\out\\CastorGeneratorSampe.xml");
            user.marshal(writer);
		} catch (Exception e) {
			e.printStackTrace(System.err);
		}
	}

	/**
	 * XML转换为JAVA对象
	 */
	public static void xmlToObject() {
		try {
			FileReader reader = new FileReader("D:\\masterSpring\\chapter14\\out\\CastorGeneratorSampe.xml");
			 User u = User.unmarshal(reader);
			 System.out.println("用户名: " + u.getUserName());
			 for (LoginLog log : u.getLogs().getLoginLog()) {
				System.out.println("访问IP: " + log.getIp());
				System.out.println("访问时间: " + log.getLoginDate());
			 }

		} catch (Exception e) {
			System.err.println(e.getMessage());
			e.printStackTrace(System.err);
		}
	}

	public static void main(String[] args) {
		objectToXml();
		xmlToObject();
	}
}
