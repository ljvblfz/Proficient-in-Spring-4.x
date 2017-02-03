package com.smart.anno;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.*;
import  static  org.testng.Assert.*;

@ContextConfiguration("classpath*:/com/smart/anno/mycomponent.xml")
public class MyComponentTest extends AbstractTestNGSpringContextTests {
	@Autowired
	private ApplicationContext applicationContext;

	@Test
	public void load() {
		MyComponent myComponent = applicationContext.getBean(MyComponent.class);
		assertEquals(myComponent.getPlugins().size(),2);
	}
}
