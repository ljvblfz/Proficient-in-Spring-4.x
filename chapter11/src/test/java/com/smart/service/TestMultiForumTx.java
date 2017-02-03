package com.smart.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.springframework.transaction.annotation.Transactional;
import org.testng.annotations.Test;

@ContextConfiguration(locations = {"classpath:applicationContext-multi.xml"})
@Rollback
@Transactional
public class TestMultiForumTx extends AbstractTransactionalTestNGSpringContextTests {

	@Autowired
	public MultiForumService forumService;

	@Test
	public void testMultiForumTx() throws Throwable{
		System.out.println("begin");
		forumService.addTopic(null);
		System.out.println("end");
		
		System.out.println("begin");
		forumService.updateForum(null);
		System.out.println("end");
    	
    }
}
