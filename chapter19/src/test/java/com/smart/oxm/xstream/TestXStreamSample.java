package com.smart.oxm.xstream;

import com.smart.domain.LoginLog;
import com.smart.domain.User;
import org.testng.annotations.Test;
import java.io.BufferedReader;
import java.io.FileReader;
import static org.custommonkey.xmlunit.XMLAssert.*;


public class TestXStreamSample {

	@Test
	public void objectToXml()throws Exception {
		XStreamSample.objectToXml();
		FileReader reader = new FileReader("out/XStreamSample.xml");
		BufferedReader br = new BufferedReader(reader);
		StringBuffer sb = new StringBuffer("");
		String s;
		while ((s = br.readLine()) != null) {
			sb.append(s);
		}
		System.out.println(sb.toString());
		reader.close();
		br.close();
		assertXpathExists("//com.smart.domain.User",sb.toString());
		assertXpathExists("//credits",sb.toString());
		assertXpathExists("//userName",sb.toString());
		assertXpathExists("//com.smart.domain.LoginLog",sb.toString());
	}

	@Test
	public void xmlToObject()throws Exception  {
		XStreamSample.objectToXml();
		User u = XStreamSample.xmlToObject();
		assertNotNull(u);
		assertEquals("xstream", u.getUserName());
		for (LoginLog log : u.getLogs()) {
			assertNotNull(log);
			assertNotNull(log.getIp());
			assertNotNull(log.getLoginDate());
		}

	}
}
