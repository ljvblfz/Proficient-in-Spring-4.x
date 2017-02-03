/**
 * Sample软件有限公司, 版权所有 违者必究
 *   Copyright 2010 
 * 2010-1-19
 */
package com.smart.tx;

import org.springframework.stereotype.Service;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.smart.User;

import javax.sql.DataSource;
import java.util.UUID;
import java.sql.Connection;

/**
 * @author 陈雄华
 * @version 1.0
 */
@Service("userJdbcService")
public class UserJdbcService {

     @Autowired
     private JdbcTemplate jdbcTemplate;

     @Autowired
     private HibernateTemplate hibernateTemplate;

     @Autowired
     private UserHibernateService userHibernateService;

     private static DataSource dataSource;

    public void doAction(User user){
         addNotice(user);
         getNoticeById();
     }


    /**
     * 模拟一个大的操作，模拟的时间为1秒，该操作运行于事务环境下
     * @param user
     */
     public void doBigAction(User user){
//        try {
//            Connection connection = jdbcTemplate.getDataSource().getConnection();
//            Connection connection =  DataSourceUtils.getConnection(dataSource);
//        } catch (SQLException e) {
//            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
//        }
//        Session  session1 = hibernateTemplate.getSessionFactory().getCurrentSession();
//        Session session2 = SessionFactoryUtils.getSession(hibernateTemplate.getSessionFactory(),true);
//         if(session1 == session2){
//             System.out.println("equal!!!");
//         }else{
//             System.out.println("not equals!!!");
//
//         }
        addNotice(user);
         try {
             Thread.sleep(1000);
         } catch (InterruptedException e) {
             e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
         }
         getNoticeById();
     }

    /**
     * doActiono2工作于DataSourceTransactionManager提供的事务环境下
     * 而noticeHibernateService.addNotice()工作于HibernateTransactioinManager提供的事务环境下
     */
     public void doAction2(){
        //do sth
         userHibernateService.addNotice();
     }

    /**
     * 由于是静态方法，因此不能进行事务增强
     * @return
     */
    public static Connection getConnNotInTx() {
        return DataSourceUtils.getConnection(dataSource);
    }

    /**
     * 由于是非静态的方法，因此有进行事务增强
     * @return
     */
    public  Connection getConnInTx() {
        return DataSourceUtils.getConnection(dataSource);
    }

     private void addNotice(User user){
         String sql = "insert into user_bask_sys.T_NTC_NOTICE(notice_id,TITLE) values(?,?)";
//         jdbcTemplate.update(sql,new Object[]{user.getNoticeId(), user.getTitle()});
     }

      private void getNoticeById() {
         String sql = "select TITLE from user_bask_sys.T_NTC_NOTICE where notice_id='BE05C79F-3605-4E02-BD5B-32A0F3DE3325'";
         String title = (String)jdbcTemplate.queryForObject(sql,String.class);
         System.out.println("title:"+title);
     }

    /**
     * 生成36个字符长度的UUID编码串，所有的字母转换为大写的格式。
     *
     * @return 36个字符长度的UUID。
     */
    private static String getUUID()
    {
        UUID uuid = UUID.randomUUID();
        return uuid.toString().toUpperCase();
    }

    public  void setDataSource(DataSource dataSource) {
        UserJdbcService.dataSource = dataSource;
    }
}
