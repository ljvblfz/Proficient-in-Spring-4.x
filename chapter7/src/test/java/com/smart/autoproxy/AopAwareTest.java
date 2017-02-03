package com.smart.autoproxy;

import com.smart.advisor.Seller;
import com.smart.advisor.Waiter;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.Test;

public class AopAwareTest {
	@Test
	public void autoProxy() {
		String configPath = "com/smart/autoproxy/beans-aware.xml";
		ApplicationContext ctx = new ClassPathXmlApplicationContext(configPath);
		Waiter waiter = (Waiter) ctx.getBean("waiter");
		waiter.serveTo("John");
		//waiter.greetTo("John");
	}
}
