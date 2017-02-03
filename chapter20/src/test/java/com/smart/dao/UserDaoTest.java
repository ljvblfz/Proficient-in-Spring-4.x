package com.smart.dao;

import java.util.List;

import com.smart.domain.LoginLog;
import com.smart.test.dataset.excel.MultiSchemaXlsDataSetFactory;
import com.smart.test.dataset.util.XlsDataSetBeanFactory;
import org.testng.Assert;
import org.unitils.UnitilsTestNG;
import org.unitils.dbunit.annotation.DataSet;
import org.unitils.dbunit.annotation.ExpectedDataSet;
import org.unitils.dbunit.datasetloadstrategy.impl.CleanInsertLoadStrategy;
import org.unitils.spring.annotation.SpringApplicationContext;
import org.unitils.spring.annotation.SpringBean;
import org.testng.annotations.*;
import com.smart.domain.User;

@SpringApplicationContext({"smart-dao.xml"})
public class UserDaoTest extends UnitilsTestNG {

    @SpringBean("jdbcUserDao")
    private UserDao userDao;

    @Test
    @DataSet(value = "UserDao.Users.xls")//准备数据
    public void findUserByUserName() {
        User user = userDao.findUserByUserName("tony");
        Assert.assertNull(user, "不存在用户名为tony的用户!");
        user = userDao.findUserByUserName("tom");
        Assert.assertNotNull(user, "tom用户存在！");
        Assert.assertEquals(user.getUserName(),"tom");
        Assert.assertEquals(user.getPassword(),"123456");
    }

    // 验证数据库保存的正确性
    @Test
    @ExpectedDataSet(value = "UserDao.ExpectedSaveUser.xls")// 准备验证数据
    public void saveUser() throws Exception {
        //通过XlsDataSetBeanFactory数据集绑定工厂创建测试实体
        userDao.clean();
        User u = XlsDataSetBeanFactory.createBean(UserDaoTest.class, "UserDao.SaveUser.xls", "t_user", User.class);
        userDao.save(u);  //执行用户信息更新操作
    }

    //验证数据库保存的正确性
    @Test
    @ExpectedDataSet("UserDao.ExpectedSaveUsers.xls")// 准备验证数据
    public void saveUsers() throws Exception {
        userDao.clean();
        List<User> users = XlsDataSetBeanFactory.createBeans(UserDaoTest.class, "UserDao.SaveUsers.xls", "t_user", User.class);
        for (User u : users) {
            userDao.save(u);
        }
    }

}
