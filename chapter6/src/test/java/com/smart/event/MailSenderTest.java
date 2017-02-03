package com.smart.event;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.*;
import static org.testng.Assert.*;

public class MailSenderTest{
	public ApplicationContext ctx = null;

	private static String[] CONFIG_FILES = {"com/smart/event/beans.xml"};

	@BeforeClass
	public void setUp() throws Exception {
		ctx = new ClassPathXmlApplicationContext(CONFIG_FILES);
	}

	@Test
	public void testMailSender() {
       MailSender mailSender = (MailSender)ctx.getBean("mailSender");
       mailSender.sendMail("aaa@bbb.com");
	}
}
