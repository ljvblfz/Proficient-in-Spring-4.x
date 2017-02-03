package com.smart.oxm.xstream.objectstreams;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.Date;

import com.smart.domain.LoginLog;
import com.smart.domain.User;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import com.thoughtworks.xstream.io.xml.*;

public class ObjectStreamSample {
	private static  XStream xstream;
	static{
		xstream = new XStream();
	}
	//XML转化为JAVA对象
	public User xmlToObject()throws Exception{
		//1.我们需要通过对象流进行输入操作，需要FileReader和BufferedReader
		FileReader fr=new FileReader("D:\\masterSpring\\chapter14\\out\\ ObjectStreamSample.xml");
		BufferedReader br=new BufferedReader(fr);
		//2.创建对象输入流
		ObjectInputStream input = xstream.createObjectInputStream(br);
		//3.创建对象，通过ObjectInputStream中的readObject()方法将对象从XML文件中读取出来。
		User user=(User)input.readObject();
		return user;
 
	}
	// 初始化转换对象
	public static User getUser() {
		LoginLog log1 = new LoginLog();
		LoginLog log2 = new LoginLog();
		log1.setIp("192.168.1.91");
		log1.setLoginDate(new Date());
		log2.setIp("192.168.1.92");
		log2.setLoginDate(new Date());
        User user = new User();
        user.setUserId(1);
        user.setUserName("xstream");
        user.addLoginLog(log1);
        user.addLoginLog(log2);
        return user;
	}
	//JAVA对象转化为XML
	public void objectToXml()throws Exception{
		User user = getUser();
		PrintWriter pw=new PrintWriter("D:\\masterSpring\\chapter14\\out\\ObjectStreamSample.xml");
		
		//创建一个PrintWriter对象，用于输出。
		PrettyPrintWriter ppw=new PrettyPrintWriter(pw);
		ObjectOutputStream out = xstream.createObjectOutputStream(ppw);
		out.writeObject(user);
		out.close();
	}
	
	public static void main(String[] args)throws Exception {
		ObjectStreamSample converter = new ObjectStreamSample();
	    converter.objectToXml();
		User u = converter.xmlToObject();
		for (LoginLog log : u.getLogs()) {
			if (log != null) {
				System.out.println("访问IP: " + log.getIp());
				System.out.println("访问时间: " + log.getLoginDate());
			}
		}

	}
}
