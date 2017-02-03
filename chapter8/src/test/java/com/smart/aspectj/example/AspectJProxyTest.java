package com.smart.aspectj.example;

import org.springframework.aop.aspectj.annotation.AspectJProxyFactory;

import com.smart.NaiveWaiter;
import com.smart.Waiter;
import org.testng.annotations.Test;

public class AspectJProxyTest {


	@Test
	public void proxy(){
		Waiter target = new NaiveWaiter();
		AspectJProxyFactory factory = new AspectJProxyFactory();
		factory.setTarget(target);
		factory.addAspect(PreGreetingAspect.class);
		Waiter proxy = factory.getProxy();
		proxy.greetTo("John");
		proxy.serveTo("John");
	}
}
