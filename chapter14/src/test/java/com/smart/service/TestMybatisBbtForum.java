package com.smart.service;

import com.smart.dao.mybatis.ForumMybatisTemplateDao;
import com.smart.domain.Forum;
import com.smart.domain.Post;
import com.smart.domain.Topic;
import com.smart.service.mybatis.BbtForumSerive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.FileCopyUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Date;


@ContextConfiguration(locations = {"classpath:applicationContext-mybatis.xml"})
@Rollback
@Transactional
public class TestMybatisBbtForum extends AbstractTransactionalTestNGSpringContextTests {
	
	@Autowired
	private BbtForumSerive bbtForumSerive;
	
	@Autowired
	private ForumMybatisTemplateDao forumMybatisTemplateDao;

	@Test
	public void testForumMethod(){	
		Forum forum = new Forum();
		forum.setForumId(99);
		forum.setForumName("name_99");
		forum.setForumDesc("desc");
		bbtForumSerive.addForum(forum);
		
		Forum forum1 = bbtForumSerive.getForum(99);
		Assert.assertEquals("name_99", forum1.getForumName());
		forum1.setForumName("forum99");
		bbtForumSerive.updateForum(forum1);
	} 
	
	@Test
	public void testTopicMethod(){
		Topic topic1 = new Topic();
		topic1.setTopicId(99);
		topic1.setTopicTitle("title99");
		topic1.setUserId(1);
		topic1.setTopicTime(new Date());
		Forum forum = new Forum();
		forum.setForumId(1);
		topic1.setForum(forum);
		bbtForumSerive.addTopic(topic1);
	}

	@Test
	public void testPostMethod() throws Throwable{
		Post post = new Post();
		post.setPostId(99);
		post.setPostText("post content...");
		post.setPostTime(new Date());
		post.setUserId(1);
		Topic topic = new Topic();
		topic.setTopicId(1);
		post.setTopic(topic);
		
		Resource resource = new ClassPathResource("temp.jpg");
        byte[] imgFile =FileCopyUtils.copyToByteArray(resource.getFile());
        post.setPostAttach(imgFile);    
        
        post.setPostAttach(imgFile);
        bbtForumSerive.addPost(post);
	}	
	
	@Test
	public void testTemplateDao(){
		Forum forum = forumMybatisTemplateDao.getForum(1);
		Assert.assertEquals("forum1", forum.getForumName());
	}
}
