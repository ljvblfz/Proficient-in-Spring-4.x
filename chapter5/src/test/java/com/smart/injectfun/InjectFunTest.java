package com.smart.injectfun;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.*;
import  static  org.testng.Assert.*;

public class InjectFunTest {
	public ApplicationContext factory = null;

	private static String[] CONFIG_FILES = { "com/smart/injectfun/beans.xml" };

	@BeforeMethod
	public void setUp() throws Exception {
		factory = new ClassPathXmlApplicationContext(CONFIG_FILES);
		
	}

	@Test
	public void testLookup(){
		MagicBoss mboss = (MagicBoss) factory.getBean("magicBoss");
		assertNotSame(mboss.getCar(),mboss.getCar());
	}

	@Test
	public void testReplace(){
		MagicBoss mboss = (MagicBoss) factory.getBean("boss1");
		assertEquals(mboss.getCar().getBrand(),"美人豹");
	}
	
}
