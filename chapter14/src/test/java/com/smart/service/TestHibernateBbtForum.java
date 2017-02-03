package com.smart.service;

import com.smart.domain.Forum;
import com.smart.service.hibernate.BbtForumSerive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.springframework.transaction.annotation.Transactional;
import org.testng.annotations.Test;

@ContextConfiguration(locations = {"classpath:applicationContext-hbt.xml"})
@Transactional
public class TestHibernateBbtForum extends AbstractTransactionalTestNGSpringContextTests {
	
	@Autowired
	private BbtForumSerive bbtForumSerive;
	
	@Test
	public void testHibernateInit(){	
		Forum forum = new Forum();
		forum.setForumId(99);
		forum.setForumName("name 99");
		forum.setForumDesc("desc");
		bbtForumSerive.addForum(forum);
	}   

}
