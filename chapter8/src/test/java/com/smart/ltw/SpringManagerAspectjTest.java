package com.smart.ltw;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class SpringManagerAspectjTest {
	public static void main(String[] args) {
		String configPath = "com/smart/configure/beans.xml";
		ApplicationContext ctx = new ClassPathXmlApplicationContext(configPath);
//		
//		Topic topic = new Topic();
//		topic.setTitle("测试主题"); 
//
//		Object obj = ctx.getBean("aspectj");
//		System.out.println("TopicAspectj:" + obj);
	}
}
