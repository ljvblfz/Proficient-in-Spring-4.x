package com.smart.dao.hibernate;

import org.springframework.stereotype.Repository;

import com.smart.domain.Post;

@Repository
public class PostHibernateDao extends BaseDao {
	
	public void addPost(Post post) {
		getHibernateTemplate().save(post);	
	}

	public Post getPost(int postId) {
		// TODO Auto-generated method stub
		return null;
	}

}
