package com.smart.entity;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.smart.User;

import java.util.List;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * @author 陈雄华
 * @version 1.0
 */
@Service("userService")
public class HibernateUserService {

    @Autowired
    public  HibernateTemplate hibernateTemplate;

    public void testUser(){
       User user = (User)hibernateTemplate.get("User","tom");
//       User simpleUser =  (User)hibernateTemplate.get("SimpleUser","tom");
//       simpleUser.setPassword("c");
//       hibernateTemplate.flush();
        
       user.setPassword("d");
       hibernateTemplate.flush();
       hibernateTemplate.clear();


       user = (User)hibernateTemplate.get("User",user.getUserName());
       user.setPassword("c");
       hibernateTemplate.flush();
       hibernateTemplate.clear();
    }

    /**
     * 批量保存
     *
     * @param objList
     */
    public <T> void saveBatch(Set<T> objList) {
        if (objList == null || objList.size() == 0) {
            return;
        }
        int i = 0;
        List<T> batchObjList = new ArrayList<T>();
        for (T obj : objList) {
            hibernateTemplate.save(obj);
            batchObjList.add(obj);
            if (++i % 10 == 0) {
                hibernateTemplate.flush();
                hibernateTemplate.clear();
//                evict(batchObjList);
                batchObjList.clear();
            }
        }
    }

    /**
     * 将对象列表从一级缓存中清除
     * @param objList
     */
    public <T> void evict(List<T> objList) {
        for (T obj : objList) {
            hibernateTemplate.evict(obj);
        }
    }

    public void batchUpdateTest(){

        Set<User> users = new HashSet<User>();
        for(int i=0;i<30;i++){
            User user = new User();
            user.setUserName("name"+i);
            user.setPassword("1");
            user.setScore(10);
            users.add(user);
        }
        saveBatch(users);
    }


    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("user/entity/applicatonContext.xml");
        HibernateUserService service = (HibernateUserService) ctx.getBean("userService");


        JdbcTemplate jdbcTemplate = (JdbcTemplate) ctx.getBean("jdbcTemplate");
        //插入一条记录，初始分数为10
//        jdbcTemplate.execute("INSERT INTO t_user(user_name,password,score,last_logon_time) VALUES('tom','123456',10,"+System.currentTimeMillis()+")");
        //调用工作在无事务环境下的服务类方法,将分数添加20分
//        service.testUser();
//        jdbcTemplate.execute("DELETE FROM t_user WHERE user_name='tom'");
         service.batchUpdateTest();
//         try {
//             Thread.sleep(100000);
//         } catch (InterruptedException e) {
//             e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
//         }
    }

}
