package com.smart.dao;

import org.springframework.stereotype.Repository;

import com.smart.domain.LoginLog;

/**
 * Post的DAO类
 *
 */
@Repository
public class LoginLogDao extends BaseDao<LoginLog> {
	public void save(LoginLog loginLog) {
		this.getHibernateTemplate().save(loginLog);
	}

}
