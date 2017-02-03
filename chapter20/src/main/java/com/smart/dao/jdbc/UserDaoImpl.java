package com.smart.dao.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Repository;

import com.smart.dao.UserDao;
import com.smart.domain.User;
import org.springframework.util.StringUtils;

@Repository("jdbcUserDao")
public class UserDaoImpl implements UserDao {


    private JdbcTemplate jdbcTemplate;


    public int getMatchCount(String userName, String password) {
        String sqlStr = " SELECT count(*) FROM t_user "
                + " WHERE user_name =? and password=? ";
        return jdbcTemplate.queryForObject(sqlStr,
                new Object[]{userName, password}, Integer.class);
    }

    public User findUserByUserName(final String userName) {
        String sqlStr = " SELECT user_id,user_name,credit,password "
                + " FROM t_user WHERE user_name =? ";
        final User user = new User();
        jdbcTemplate.query(sqlStr, new Object[]{userName},
                new RowCallbackHandler() {
                    public void processRow(ResultSet rs) throws SQLException {
                        user.setUserId(rs.getInt("user_id"));
                        user.setUserName(rs.getString("user_name"));
                        user.setCredit(rs.getInt("credit"));
                        user.setPassword(rs.getString("password"));
                    }
                });
        return StringUtils.isEmpty(user.getUserName()) ? null : user;
    }

    public void updateLoginInfo(User user) {
        String sqlStr = " UPDATE t_user SET last_visit=?,last_ip=?,credit=? "
                + " WHERE user_id =?";
        jdbcTemplate.update(sqlStr, new Object[]{user.getLastVisit(),
                user.getLastIp(), user.getCredit(), user.getUserId()});
    }

    public void save(User user) {
        String sqlStr = " INSERT INTO t_user(user_id,user_name,password,last_visit,last_ip,credit) "
                + " VALUES(?,?,?,?,?,?)";
        jdbcTemplate.update(sqlStr, new Object[]{user.getUserId(),
                user.getUserName(), user.getPassword(), user.getLastVisit(), user.getLastIp(), user.getCredit()});
    }

    public void clean() {
        jdbcTemplate.update("delete from t_user");
        jdbcTemplate.update("delete from t_login_log");
    }

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

}
