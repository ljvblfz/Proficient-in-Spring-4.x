package com.smart.beanprop;

import java.sql.Connection;

import javax.sql.DataSource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanPropReferenceTest {

	public static void main(String[] args) throws Throwable {
		String resourceFile = "com/smart/beanprop/beans.xml";
		ApplicationContext ctx = new ClassPathXmlApplicationContext(resourceFile);
		DataSource ds = ctx.getBean(DataSource.class);
		Connection conn = ds.getConnection();
		System.out.println("conn is not null:"+(conn!=null));
		
	}
}
