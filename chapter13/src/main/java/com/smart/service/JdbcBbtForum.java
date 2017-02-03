package com.smart.service;

import com.smart.dao.ForumDao;
import com.smart.domain.Forum;

public class JdbcBbtForum implements BbtForum {
    private ForumDao forumDao;
    
	public void setForumDao(ForumDao forumDao) {
		this.forumDao = forumDao;
	}

	public void addForum(Forum forum) {
		forumDao.addForum(forum);
	}
}
