package com.smart.dao.mybatis;

import java.util.List;

import com.smart.domain.Forum;

public interface ForumMybatisDao{
	void addForum(Forum forum);	
	void updateForum(Forum forum) ;
	Forum getForum(int forumId) ;
	long getForumNum() ;
	List<Forum> findForumByName(String forumName);
}
