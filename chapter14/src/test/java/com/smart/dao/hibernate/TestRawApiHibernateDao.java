package com.smart.dao.hibernate;

import com.smart.dao.hibraw.ForumHibernateDao;
import com.smart.domain.Forum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.springframework.transaction.annotation.Transactional;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

@ContextConfiguration(locations = { "classpath:applicationContext-hbt-raw.xml" })
@Transactional
public class TestRawApiHibernateDao extends AbstractTransactionalTestNGSpringContextTests {

	@Autowired
	private ForumHibernateDao forumDao;
	
	@Test
	public void testAllMethod() {
		Forum forum = forumDao.getForum(1);
		Assert.assertNotNull(forum);
		
		List<Forum> forums = forumDao.findForumByName("forum");
		Assert.assertTrue(forums.size()>0);
	}	
		
}
