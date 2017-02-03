package com.smart.dao;

import com.smart.domain.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.FileCopyUtils;
import org.testng.annotations.Test;

import java.io.FileOutputStream;
import java.util.List;


@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
@Rollback
@Transactional
public class TestPostDao extends AbstractTransactionalTestNGSpringContextTests {
	
	@Autowired
	private PostDao postDao;
	
    @Test
	public void testAddPost() throws Throwable{
		Post post = new Post();
		post.setUserId(2);
		ClassPathResource res = new ClassPathResource("temp.jpg");
		byte[] mockImg = FileCopyUtils.copyToByteArray(res.getFile());	
		post.setPostAttach(mockImg);
		post.setPostText("测试帖子的内容");
		postDao.addPost(post);
	}
	
    @Test
    public void testgetAttach() throws Throwable{
    	FileOutputStream fos = new FileOutputStream("d:/temp.jpg");
    	postDao.getAttach(1,fos);
    }
    
    @Test
    public void testgetAttachs() throws Throwable{   
    	Post post = new Post();
		post.setUserId(2);
		ClassPathResource res = new ClassPathResource("temp.jpg");
		byte[] mockImg = FileCopyUtils.copyToByteArray(res.getFile());	
		post.setPostAttach(mockImg);
		post.setPostText("测试帖子的内容");
		postDao.addPost(post);
    	
    	
    	List<Post> list = postDao.getAttachs(3);
    	for (Post tempPost:list) {
			System.out.println(tempPost.getPostId()+";"+post.getPostAttach().length);
		}
    }	    

}
