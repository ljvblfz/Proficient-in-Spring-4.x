package com.smart.service;

import com.smart.domain.Post;
import com.smart.domain.Topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.springframework.transaction.annotation.Transactional;
import org.testng.annotations.Test;

@ContextConfiguration(locations = {"classpath:applicationContext-pfb.xml"})
@Rollback
@Transactional
public class TestBbtForumPfb  extends AbstractTransactionalTestNGSpringContextTests {

	@Autowired
	public BbtForum bbtForum;

	@Test
	public  void testBbForum() throws Throwable{
    	System.out.println("begin........");
    	Topic topic = new Topic();
    	topic.setTopicTitle("Title -pfb");
    	Post post = new Post();
    	post.setPostText("post content -pfb");
    	topic.setPost(post);
    	bbtForum.addTopic(topic);
    	System.out.println("end........");
    }
}
