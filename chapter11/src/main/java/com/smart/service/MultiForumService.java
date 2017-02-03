package com.smart.service;

import com.smart.ForumTransactional;
import com.smart.TopicTransactional;
import com.smart.dao.ForumDao;
import com.smart.dao.PostDao;
import com.smart.dao.TopicDao;
import com.smart.domain.Forum;
import com.smart.domain.Topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MultiForumService {
	private ForumDao forumDao;
	private TopicDao topicDao;
	private PostDao postDao;
	
//	@Transactional("topic")
	@TopicTransactional
	public void addTopic(Topic topic) throws Exception {
       System.out.println("topic tx");
	}
	
//	@Transactional("forum")
	@ForumTransactional
	public void updateForum(Forum forum) {
		System.out.println("forum tx");
	}

	public ForumDao getForumDao() {
		return forumDao;
	}
	@Autowired
	public void setForumDao(ForumDao forumDao) {
		this.forumDao = forumDao;
	}
	public TopicDao getTopicDao() {
		return topicDao;
	}
	@Autowired
	public void setTopicDao(TopicDao topicDao) {
		this.topicDao = topicDao;
	}
	public PostDao getPostDao() {
		return postDao;
	}
	@Autowired
	public void setPostDao(PostDao postDao) {
		this.postDao = postDao;
	}
	
}
