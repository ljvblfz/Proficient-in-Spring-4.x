package com.smart.dao;

import com.smart.domain.User;
import com.smart.test.dataset.util.XlsDataSetBeanFactory;
import org.testng.annotations.Test;
import org.unitils.dbunit.annotation.DataSet;
import org.unitils.dbunit.annotation.ExpectedDataSet;
import org.unitils.spring.annotation.SpringBean;

import java.util.List;

import static org.junit.Assert.*;


public class UserDaoTest extends BaseDaoTest {

	@SpringBean("userDao")
	private UserDao userDao;


	@Test
	@DataSet("XiaoChun.Users.xls")//准备数据
	public void findUserByUserName() {
		User user = userDao.getUserByUserName("tony");
		assertNull("不存在用户名为tony的用户!", user);
		user = userDao.getUserByUserName("jan");
		assertNotNull("Jan用户存在！", user);
		assertEquals("jan", user.getUserName());
		assertEquals("123456",user.getPassword());
		assertEquals(10,user.getCredit());
	}

	// 验证数据库保存的正确性
	@Test
	@ExpectedDataSet("XiaoChun.ExpectedSaveUser.xls")// 准备验证数据
	public void saveUser()throws Exception  {
		/**
		硬编码创建测试实体
		User u = new User();
		u.setUserId(1);
		u.setUserName("tom");
		u.setPassword("123456");
		u.setLastVisit(getDate("2011-06-06 08:00:00","yyyy-MM-dd HH:mm:ss"));
		u.setCredits(30);
		u.setLastIp("127.0.0.1");
		**/
		//通过XlsDataSetBeanFactory数据集绑定工厂创建测试实体
		User u  = XlsDataSetBeanFactory.createBean(UserDaoTest.class,"XiaoChun.SaveUser.xls", "t_user", User.class);
		userDao.save(u);  //执行用户信息更新操作
	}
	
	//验证数据库保存的正确性
	//@Test
	//@ExpectedDataSet("XiaoChun.ExpectedSaveUsers.xls")// 准备验证数据
	public void saveUsers()throws Exception  {
		List<User> users  = XlsDataSetBeanFactory.createBeans(UserDaoTest.class,"XiaoChun.SaveUsers.xls", "t_user", User.class);
		for(User u:users){
		     userDao.save(u);
		}
	}

}
