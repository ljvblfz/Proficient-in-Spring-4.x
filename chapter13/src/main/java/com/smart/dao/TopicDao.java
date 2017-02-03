package com.smart.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.*;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.HashMap;
import java.util.Map;

@Repository
public class TopicDao {
	private JdbcTemplate jdbcTemplate;

	@Autowired
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	public double getReplyRate(int userId) {
		String sql = "SELECT topic_replies,topic_views FROM t_topic WHERE user_id=?";
		double rate = jdbcTemplate.queryForObject(sql, new Object[] { userId },
				new RowMapper<Double>() {
					public Double mapRow(ResultSet rs, int index)
							throws SQLException {
						int replies = rs.getInt("topic_replies");
						int views = rs.getInt("topic_views");
						if (views > 0)
							return new Double((double) replies / views);
						else
							return new Double(0.0);
					}
				});
		return rate;
	};

	public int getUserTopicNum(final int userId) {
		String sql = "{call P_GET_TOPIC_NUM(?,?)}";
		//方式1
/*		Integer num = jdbcTemplate.execute(sql,
				new CallableStatementCallback<Integer>() {
					public Integer doInCallableStatement(CallableStatement cs)
							throws SQLException, DataAccessException {
						cs.setInt(1, userId);
						cs.registerOutParameter(2, Types.INTEGER);
						cs.execute();
						return cs.getInt(2);
					}
				});
		return num;*/
		
		//方式2
		CallableStatementCreatorFactory fac = new CallableStatementCreatorFactory(sql); 
		fac.addParameter(new SqlParameter("userId",Types.INTEGER)); 
		fac.addParameter(new SqlOutParameter("topicNum",Types.INTEGER)); 
		Map<String,Integer> paramsMap = new HashMap<String,Integer>();
		paramsMap.put("userId",userId);
		CallableStatementCreator csc = fac.newCallableStatementCreator (paramsMap);	
		Integer num = jdbcTemplate.execute(csc,new CallableStatementCallback<Integer>(){
			public Integer doInCallableStatement(CallableStatement cs) 
				throws SQLException, DataAccessException {
				cs.execute();
				return cs.getInt(2);
			}	
		});
	    return num;
	}

	public int getUserTopicNum2(int userId) {
		return 0;
	};

	public SqlRowSet getTopicRowSet(int userId) {
		String sql = "SELECT topic_id,topic_title FROM t_topic WHERE user_id=?";
		return jdbcTemplate.queryForRowSet(sql,userId);

	};
}
