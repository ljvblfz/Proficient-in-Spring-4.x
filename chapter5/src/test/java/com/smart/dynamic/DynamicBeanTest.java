package com.smart.dynamic;

import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.*;
import static org.testng.Assert.*;

public class DynamicBeanTest {

	public ApplicationContext applicationContext = null;

	private static String[] CONFIG_FILES = { "com/smart/dynamic/beans.xml" };

	@BeforeClass
	public void setUp() throws Exception {
		applicationContext = new ClassPathXmlApplicationContext(CONFIG_FILES);
		
	}

	@Test
	public void registerBean(){
		try {
			Object userService1 = applicationContext.getBean("userService1");
			Object userService2 = applicationContext.getBean("userService2");
			assertNotNull(userService1);
			assertNotNull(userService2);
		}catch (NoSuchBeanDefinitionException exception){
			exception.printStackTrace();
		}

		//UserServiceFactoryBean.build(applicationContext);

		Object userService1 = applicationContext.getBean("userService1");
		Object userService2 = applicationContext.getBean("userService2");
		assertNotNull(userService1);
		assertNotNull(userService2);
	}

}
