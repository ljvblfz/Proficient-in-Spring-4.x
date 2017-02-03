package com.smart.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.springframework.transaction.annotation.Transactional;
import org.testng.annotations.Test;

@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
@Transactional
public class TestTopicDao  extends AbstractTransactionalTestNGSpringContextTests {
	@Autowired
	private TopicDao topicDao;

	@Test
	public void testGetReplyRate() {
		double rate = topicDao.getReplyRate(2);
		System.out.println("rate is:" + rate);
	}
    
	@Test
	public void testGetUserTopicNum() throws Throwable {
		int num = topicDao.getUserTopicNum(1);
		System.out.println("num is:" + num);
	}

	//
	// public void testGetUserTopicNum2() throws Throwable{
	// int num = topicDao.getUserTopicNum2(1);
	// System.out.println("num is:" + num);
	// }
	
	@Test
	public void testGetTopicRowSet() {
		SqlRowSet srs = topicDao.getTopicRowSet(1);
		while (srs.next()) {
			System.out.println(srs.getString("topic_id"));
		}
	}

}
