package com.smart.oxm.jibx;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.Date;

import org.jibx.runtime.BindingDirectory;
import org.jibx.runtime.IBindingFactory;
import org.jibx.runtime.IMarshallingContext;
import org.jibx.runtime.IUnmarshallingContext;

import com.smart.domain.LoginLog;
import com.smart.domain.User;

public class JibxSample {

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
		user.setUserName("jibx");
		user.setPassword("jibx");
		user.addLoginLog(log1);
		user.addLoginLog(log2);
		user.addLoginLog(log3);
		return user;
	}

	/**
	 * JAVA对象转化为XML
	 */
	public static void objectToXml()  {
		try {
			User user  = getUser();
			IBindingFactory bfact = BindingDirectory.getFactory(User.class);
			IMarshallingContext ctx = bfact.createMarshallingContext();
			FileOutputStream outputStream = new FileOutputStream("out/JibxSample.xml");
			ctx.marshalDocument(user, "UTF-8", null, outputStream);
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	/**
	 * XML转化为JAVA对象
	 */
	public static User xmlToObject(){
		try {
			IBindingFactory bfact = BindingDirectory.getFactory(User.class);
			IUnmarshallingContext uctx = bfact.createUnmarshallingContext();
			File dataFile = new File("JibxSample.xml");
			InputStream in = new FileInputStream(dataFile);
			User user = (User) uctx.unmarshalDocument(in, null);
			System.out.println("userName:" + user.getUserName());
			for (LoginLog log : user.getLogs()) {
				if (log != null) {
					System.out.println("访问IP: " + log.getIp());
					System.out.println("访问时间: " + log.getLoginDate());
				}
			}
			return user;
		}catch (Exception e){
			//e.printStackTrace();
			return null;
		}
	}

	public static void main(String[] args) throws Exception {
		AntBuildUtils.doBuild(".\\src\\main\\resources\\com\\smart\\oxm\\jibx\\build.xml");
		//objectToXml();
		//xmlToObject();
	}
}
