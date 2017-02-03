/**
 * 版权声明：Sample有限公司 版权所有 违者必究 2010 
 * 日    期：2010-6-27
 */
package com.smart.programtx;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;
import javax.sql.DataSource;


/**
 * @author 陈雄华
 * @version 1.0
 *          功能说明：
 */
@Service("userService")
public class UserService {

    @Autowired
    private DataSource dataSource;
    private static final String sql = "UPDATE t_user u SET u.score = u.score + ? WHERE user_name =?";

    /**
     * 获取数据源的事务管理器
     *
     * @return
     */
    private PlatformTransactionManager getDataSourceTransactionManager() {
        DataSourceTransactionManager dataSourceTransactionManager = new DataSourceTransactionManager();
        dataSourceTransactionManager.setDataSource(this.dataSource);
        return dataSourceTransactionManager;
    }

    public void addScore() throws Throwable {
        final JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(this.dataSource);
        final BasicDataSource basicDataSource = (BasicDataSource) this.dataSource;

        TransactionTemplate transactionTemplate = new TransactionTemplate(getDataSourceTransactionManager());
        System.out.println("before transactionTemplate.execute...");
        System.out.println("conn.autocommit(before):" + DataSourceUtils.getConnection(basicDataSource).getAutoCommit());
        long begin = System.currentTimeMillis();
        transactionTemplate.execute(new TransactionCallback() {
            public Object doInTransaction(TransactionStatus transactionStatus) {
//                try {
//                    System.out.println("conn.autocommit(in):"+DataSourceUtils.getConnection(basicDataSource).getAutoCommit());
//                } catch (SQLException e) {
//                    e.printStackTrace();
//                } catch (JdbcStoreException e) {
//                    e.printStackTrace();
//                }

                for (int i = 0; i < 100; i++) {
                    jdbcTemplate.update(sql, 30, "tom");
                }
                return null;
            }
        });
        System.out.println("time elapsed in tx:" + (System.currentTimeMillis() - begin));

        begin = System.currentTimeMillis();
        for (int i = 0; i < 100; i++) {
            jdbcTemplate.update(sql, 30, "tom");
        }
        System.out.println("time elapsed not in tx:" + (System.currentTimeMillis() - begin));
//        System.out.println("conn.autocommit(after):"+ DataSourceUtils.getConnection(basicDataSource).getAutoCommit());
//        System.out.println("after transactionTemplate.execute...");
    }

    public static void main(String[] args) throws Throwable {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("com/smart/programtx/programicTx.xml");
        UserService service = (UserService) ctx.getBean("userService");
        service.addScore();
    }
}
