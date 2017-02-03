package com.smart.autoproxy;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.smart.advisor.Seller;
import com.smart.advisor.Waiter;
import static org.testng.Assert.*;
import org.testng.annotations.*;
public class BeanNameAutoProxyCreatorTest {

	@Test
	public void autoProxy() {
		String configPath = "com/smart/autoproxy/beans.xml";
		ApplicationContext ctx = new ClassPathXmlApplicationContext(configPath);
		Waiter waiter = (Waiter) ctx.getBean("waiter");
		Seller seller = (Seller) ctx.getBean("seller");
		waiter.serveTo("John");
		waiter.greetTo("John");
		//seller.greetTo("Tom");
	}
}
