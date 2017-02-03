package com.smart.editor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.*;
import static org.testng.Assert.*;

public class CustomerEditorTest {
	public ApplicationContext ctx = null;

	private static String[] CONFIG_FILES = { "com/smart/editor/beans.xml" };

	@BeforeClass
	public void setUp() throws Exception {
		ctx = new ClassPathXmlApplicationContext(CONFIG_FILES);
	}

	@Test
	public void testCustomerCarEditor(){
		Boss boss = (Boss) ctx.getBean("boss");
		assertNotNull(boss);
	    System.out.println(boss);
	} 
	
}
