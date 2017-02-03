package com.smart.dao.hibraw;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.smart.domain.Forum;

@Repository
public class ForumHibernateDao {

	private SessionFactory sessionFactory;

	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public void addForum(Forum forum) {
		sessionFactory.getCurrentSession().save(forum);
	}
	public void updateForum(Forum forum) {
		sessionFactory.getCurrentSession().update(forum);
	}
	public Forum getForum(int forumId) {
		return (Forum) sessionFactory.getCurrentSession().load(Forum.class,
				forumId);
	}
	public long getForumNum() {
		Object obj = sessionFactory.getCurrentSession().createQuery(
				"select count(f.forumId) from Forum f").list().iterator();
		return (Long) obj;
	}
	public List<Forum> findForumByName(String forumName) {
		List list = sessionFactory
		      .getCurrentSession()
		      .createQuery("from Forum f where f.forumName like ?")
		      .setString(0, forumName + "%")
		      .list();
		return (List<Forum>)list;
	}
}
