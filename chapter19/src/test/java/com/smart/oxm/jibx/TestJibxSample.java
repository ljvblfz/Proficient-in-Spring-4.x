package com.smart.oxm.jibx;

import com.smart.domain.LoginLog;
import com.smart.domain.User;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestJibxSample {

	@Test
	public void objectToXml()throws Exception {
		JibxSample.objectToXml();
	}

	@Test
	public void xmlToObject() throws Exception {
		JibxSample.xmlToObject();
		User u = JibxSample.xmlToObject();
		/*Assert.assertNotNull(u);
		Assert.assertEquals("jibx", u.getUserName());
		for (LoginLog log : u.getLogs()) {
			Assert.assertNotNull(log);
			Assert.assertNotNull(log.getIp());
			Assert.assertNotNull(log.getLoginDate());
		}*/

	}
}
