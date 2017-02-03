package com.smart.place;

import com.smart.editor.Car;
import com.smart.placeholder.MyDataSource;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class PropertyPlaceTest{
	public ApplicationContext ctx = null;

	private static String[] CONFIG_FILES = { "com/smart/place/beans.xml" };

	@BeforeClass
	public void setUp() throws Exception {
		ctx = new ClassPathXmlApplicationContext(CONFIG_FILES);
		
	}

	@Test
	public void testCustomerCarEditor(){
		MyDataSource dataSource = (MyDataSource)ctx.getBean(MyDataSource.class);
		assertNotNull(dataSource);
	} 	
}
