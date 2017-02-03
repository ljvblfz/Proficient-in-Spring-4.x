package com.smart.oxm.castor;

import com.smart.domain.LoginLog;
import com.smart.domain.User;
import org.testng.annotations.Test;
import java.io.BufferedReader;
import java.io.FileReader;
import static org.custommonkey.xmlunit.XMLAssert.assertXpathExists;
import static org.testng.Assert.*;

public class TestCastorSample {

	@Test
	public void objectToXml()throws Exception {
		CastorSample.objectToXml();
		FileReader reader = new FileReader("out/CastorSampe.xml");
		BufferedReader br = new BufferedReader(reader);
		StringBuffer sb = new StringBuffer("");
		String s;
		while ((s = br.readLine()) != null) {
			sb.append(s);
		}
		reader.close();
		br.close();
		assertXpathExists("//user[@id='0']",sb.toString());
		assertXpathExists("//credits",sb.toString());
		assertXpathExists("//userName",sb.toString());
		assertXpathExists("//log[@id='0']",sb.toString());
	}

	@Test
	public void xmlToObject() {
		CastorSample.objectToXml();
		User u = CastorSample.xmlToObject();
		assertNotNull(u);
		assertEquals("castor", u.getUserName());
		for (LoginLog log : u.getLogs()) {
			assertNotNull(log);
			assertNotNull(log.getIp());
			assertNotNull(log.getLoginDate());
		}

	}

}
