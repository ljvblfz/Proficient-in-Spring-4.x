package com.smart.aspectj.basic;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.smart.Seller;
import com.smart.Waiter;
import org.testng.annotations.*;


public class DeclaredParentsTest {


	@Test
	public void parent() {
		String configPath = "com/smart/aspectj/basic/beans.xml";
		ApplicationContext ctx = new ClassPathXmlApplicationContext(configPath);
		Waiter waiter = (Waiter)ctx.getBean("waiter");
		waiter.greetTo("John");
		Seller seller = (Seller)waiter;
		seller.sell("Beer", "John");
	}
}
