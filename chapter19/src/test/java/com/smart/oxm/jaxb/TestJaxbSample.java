package com.smart.oxm.jaxb;

import com.smart.domain.jaxb.LoginLog;
import com.smart.domain.jaxb.User;
import org.testng.annotations.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class TestJaxbSample {
	
	@Test
	public void objectToXml()throws Exception  {
		JaxbSample.objectToXml();
	}

	@Test
	public void xmlToObject()throws Exception {
		JaxbSample.objectToXml();
		User u = JaxbSample.xmlToObject();
		assertNotNull(u);
		assertEquals("jaxb", u.getUserName());
		for (LoginLog log :  u.getLogs().getLoginLog()) {
			assertNotNull(log);
			assertNotNull(log.getIp());
			assertNotNull(log.getLoginDate());
		}

	}

}
