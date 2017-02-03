package com.smart.multithread;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import org.apache.commons.dbcp.BasicDataSource;

/**
 * @author 陈雄华
 * @version 1.0
 */
@Service("userService")
public class UserService extends BaseService {
    private JdbcTemplate jdbcTemplate;
    private ScoreService scoreService;

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Autowired
    public void setScoreService(ScoreService scoreService) {
        this.scoreService = scoreService;
    }

    public void logon(String userName) {
        System.out.println("before userService.updateLastLogonTime method...");
        updateLastLogonTime(userName);
        System.out.println("after userService.updateLastLogonTime method...");

//      scoreService.addScore(userName, 20);
        Thread myThread = new MyThread(this.scoreService, userName, 20);//使用一个新线程运行
        myThread.start();
    }

    public void updateLastLogonTime(String userName) {
        String sql = "UPDATE t_user u SET u.last_logon_time = ? WHERE user_name =?";
        jdbcTemplate.update(sql, System.currentTimeMillis(), userName);
    }

    private class MyThread extends Thread {
        private ScoreService scoreService;
        private String userName;
        private int toAdd;
        private MyThread(ScoreService scoreService, String userName, int toAdd) {
            this.scoreService = scoreService;
            this.userName = userName;
            this.toAdd = toAdd;
        }

        public void run() {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("before scoreService.addScor method...");
            scoreService.addScore(userName, toAdd);
            System.out.println("after scoreService.addScor method...");
        }
    }

    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("com/smart/multithread/applicatonContext.xml");
        UserService service = (UserService) ctx.getBean("userService");

        JdbcTemplate jdbcTemplate = (JdbcTemplate) ctx.getBean("jdbcTemplate");
        //插入一条记录，初始分数为10
        jdbcTemplate.execute("INSERT INTO t_user(user_name,password,score,last_logon_time) VALUES('tom','123456',10," + System.currentTimeMillis() + ")");


        //调用工作在无事务环境下的服务类方法,将分数添加20分
        System.out.println("before userService.logon method...");
        service.logon("tom");
        System.out.println("after userService.logon method...");
        jdbcTemplate.execute("DELETE FROM t_user WHERE user_name='tom'");

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
