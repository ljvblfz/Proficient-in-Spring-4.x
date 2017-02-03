package com.smart.dao.hibernate;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate4.HibernateTemplate;
import com.smart.dao.UserDao;
import com.smart.domain.User;

public class UserDaoImpl implements UserDao {
	private SessionFactory sessionFactory;

	public User findUserByUserName(String userName) {
		String hql = " from User u where u.userName=?";
		List<User> users =(List<User>) getHibernateTemplate().find(hql, userName);
		if (users != null && users.size() > 0)
			return users.get(0);
		else
			return null;
	}

	public void save(User user) {
		getHibernateTemplate().saveOrUpdate(user);
	}

	public void updateLoginInfo(User user) {
		getHibernateTemplate().saveOrUpdate(user);
	}

	public int getMatchCount(String userName, String password) {
		return 0;
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	public HibernateTemplate getHibernateTemplate() {
		return new HibernateTemplate(sessionFactory);
	}

	public void clean() {

	}
}
