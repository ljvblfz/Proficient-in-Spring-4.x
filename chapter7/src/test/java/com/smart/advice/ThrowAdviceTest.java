package com.smart.advice;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import static org.testng.Assert.*;
import org.testng.annotations.*;
public class ThrowAdviceTest {

	@Test
	public void throwAdvice(){
		String configPath = "com/smart/advice/beans.xml";
		ApplicationContext ctx = new ClassPathXmlApplicationContext(configPath);
		ForumService forumService = (ForumService)ctx.getBean("forumService");
		
		try{
			forumService.removeForum(10);
		} catch (Exception e) {}		
		
		try{
			forumService.updateForum(new Forum());
		} catch (Exception e) {}			
	}
}
