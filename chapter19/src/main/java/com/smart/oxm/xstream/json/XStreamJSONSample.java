package com.smart.oxm.xstream.json;

import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.util.Date;

import com.smart.domain.LoginLog;
import com.smart.domain.User;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.json.JettisonMappedXmlDriver;
import com.thoughtworks.xstream.io.json.JsonHierarchicalStreamDriver;

public class XStreamJSONSample {
	private static XStream xstream;
	
	public static void toJsonByJettisonMappedXmlDriver()throws Exception {
		User user = getUser();
		FileOutputStream outputSteam = new FileOutputStream("out/JettisonMappedSample.json");
        OutputStreamWriter writer = new OutputStreamWriter(outputSteam, Charset.forName("UTF-8"));    
		xstream = new XStream(new JettisonMappedXmlDriver());
		xstream.setMode(XStream.NO_REFERENCES);
		xstream.alias("user", User.class);
		xstream.toXML(user,writer);
	}

	public static void toJsonByJsonHierarchicalStreamDriver()throws Exception {
		User user = getUser();
		FileOutputStream outputSteam = new FileOutputStream("out/JsonByJsonHierarchicalSample.json");
        OutputStreamWriter writer = new OutputStreamWriter(outputSteam, Charset.forName("UTF-8"));    
		xstream = new XStream(new JsonHierarchicalStreamDriver());
		xstream.alias("user", User.class);
		xstream.toXML(user,writer);
	}

	public static User jsonToObject()throws Exception{
		String json = "{\"user\":{\"userId\":1,\"userName\":\"xstream\",\"credits\":0,\"logs\":[{\"com.smart.domain.LoginLog\":[{\"loginLogId\":0,\"userId\":0,\"ip\":\"192.168.1.91\",\"loginDate\":\"2011-08-08 00:16:41.196 CST\"},{\"loginLogId\":0,\"userId\":0,\"ip\":\"192.168.1.92\",\"loginDate\":\"2011-08-08 00:16:41.196 CST\"}]}]}}";
		xstream = new XStream(new JettisonMappedXmlDriver());
	    xstream.alias("user", User.class);
	    User user=(User)xstream.fromXML(json);
        return user;
	}
	
	public static void main(String[] args) throws Exception{
		toJsonByJettisonMappedXmlDriver();
		toJsonByJsonHierarchicalStreamDriver();
		User u = jsonToObject();
		for (LoginLog log : u.getLogs()) {
			if (log != null) {
				System.out.println("����IP: " + log.getIp());
				System.out.println("����ʱ��: " + log.getLoginDate());
			}
		}
	}
	
	public static User getUser() {
		LoginLog log1 = new LoginLog();
		log1.setIp("192.168.1.91");
		log1.setLoginDate(new Date());
		LoginLog log2 = new LoginLog();
		log2.setIp("192.168.1.92");
		log2.setLoginDate(new Date());
		User user = new User();
		user.setUserId(1);
		user.setUserName("xstream");
		user.addLoginLog(log1);
		user.addLoginLog(log2);
		return user;
	}

}
