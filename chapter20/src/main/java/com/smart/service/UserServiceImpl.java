package com.smart.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.smart.dao.LoginLogDao;
import com.smart.dao.UserDao;
import com.smart.domain.LoginLog;
import com.smart.domain.User;
@Service("userService")
public class UserServiceImpl implements UserService {
	private UserDao userDao;
	private UserDao hibernateUserDao;
	private LoginLogDao loginLogDao;

	public boolean hasMatchUser(String userName, String password) {
		int matchCount =userDao.getMatchCount(userName, password);
		return matchCount > 0;
	}
	
	public User findUserByUserName(String userName) {
		return userDao.findUserByUserName(userName);
	}
	
	public void loginSuccess(User user) {
		user.setCredit( 5 + user.getCredit());
		LoginLog loginLog = new LoginLog();
		loginLog.setUserId(user.getUserId());
		loginLog.setIp(user.getLastIp());
		loginLog.setLoginDate(user.getLastVisit());
        userDao.updateLoginInfo(user);
        loginLogDao.insertLoginLog(loginLog);
	}

	@Autowired
	@Qualifier("jdbcUserDao")
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	@Autowired
	@Qualifier("hibernateUserDao")
	public void setHibernateUserDao(UserDao hibernateUserDao) {
		this.hibernateUserDao = hibernateUserDao;
	}

	@Autowired
	@Qualifier("jdbcLoginLogDao")
	public void setLoginLogDao(LoginLogDao loginLogDao) {
		this.loginLogDao = loginLogDao;
	}

	public void registerUser(User user) {
		userDao.save(user);	
	}
}
