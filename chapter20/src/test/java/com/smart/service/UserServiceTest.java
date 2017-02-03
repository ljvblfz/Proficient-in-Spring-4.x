package com.smart.service;

import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import java.util.Date;

import org.springframework.test.util.ReflectionTestUtils;
import org.unitils.UnitilsTestNG;
import org.unitils.dbunit.annotation.DataSet;
import org.unitils.spring.annotation.SpringApplicationContext;
import org.unitils.spring.annotation.SpringBean;
import com.smart.dao.LoginLogDao;
import com.smart.dao.UserDao;
import com.smart.domain.User;
import static org.mockito.Mockito.*;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import static org.hamcrest.MatcherAssert.*;

@SpringApplicationContext( {"smart-service.xml", "smart-dao.xml"})
public class UserServiceTest extends UnitilsTestNG {
	@SpringBean("userService")
	private UserService userService;
	
	private UserDao userDao;
	
	private LoginLogDao loginLogDao;
	
	@BeforeClass
	public void init(){
		userDao = mock(UserDao.class);
		loginLogDao = mock(LoginLogDao.class);

	}
	
	@Test
	public void hasMatchUser() {
		 User user = new User();
		 user.setUserName("tom");
		 user.setPassword("1234");
		 user.setCredit(100);
		 doReturn(1).when(userDao).getMatchCount("tom", "1234"); 
		 UserServiceImpl userService = new UserServiceImpl();
		 ReflectionTestUtils.setField(userService, "userDao", userDao);
		
		 boolean isMatch = userService.hasMatchUser("tom", "1234"); 
		 assertThat(isMatch,is(true));
	     verify(userDao,times(1)).getMatchCount("tom", "1234");
	}
	
	@Test
	public void findUserByUserName() {
		 User user = new User();
		 user.setUserName("tom");
		 user.setPassword("1234");
		 user.setCredit(100);
		 doReturn(user).when(userDao).findUserByUserName("tom"); 
		 UserServiceImpl userService = new UserServiceImpl();
		 ReflectionTestUtils.setField(userService, "userDao", userDao);   

		
		 User u = userService.findUserByUserName("tom");
		 assertNotNull(u);
		 assertThat(u.getUserName(),equalTo(user.getUserName()));
	     verify(userDao,times(1)).findUserByUserName("tom");
	}
	
	
	@Test
	@DataSet("Service.SaveUsers.xls")
	public void loginSuccess() {
		User user = userService.findUserByUserName("tom");
		Date now = new Date();
		user.setLastVisit(now);
		userService.loginSuccess(user);
	    User u = userService.findUserByUserName("tom");
	    assertThat(u.getCredit(),is(105));
	}	
	
}
