package com.smart.dao;

import com.smart.domain.Forum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.*;

@Repository
public class ForumDao {
	private JdbcTemplate jdbcTemplate;


	public void addForum(final Forum forum) {
		final String sql = "INSERT INTO t_forum(forum_name,forum_desc) VALUES(?,?)";
		KeyHolder keyHolder = new GeneratedKeyHolder();
		jdbcTemplate.update(new PreparedStatementCreator() {
			public PreparedStatement createPreparedStatement(Connection conn)
					throws SQLException {
				PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
				ps.setString(1, forum.getForumName());
				ps.setString(2, forum.getForumDesc());
				return ps;
			}
		}, keyHolder);
		forum.setForumId(keyHolder.getKey().intValue());
	}
	public Forum getForum(final int forumId) {
		String sql = "SELECT forum_name,forum_desc FROM t_forum WHERE forum_id=?";
		final Forum forum = new Forum();
		jdbcTemplate.query(sql, new Object[]{forumId},
				new RowCallbackHandler() {
					public void processRow(ResultSet rs) throws SQLException {
						forum.setForumId(forumId);
						forum.setForumName(rs.getString("forum_name"));
						forum.setForumDesc(rs.getString("forum_desc"));
					}
				});
		return forum;
	}

	public int getForumNum() {
		String sql = "SELECT forum_id FROM t_forum ";
		return jdbcTemplate.queryForObject(sql, Integer.class);
	}

	public void updateForum(final Forum forum) {
		final String sql = "UPDATE  t_forum SET forum_name=?,forum_desc=? WHERE forum_id=?";
		Object[] params = new Object[]{forum.getForumName(),forum.getForumDesc(),forum.getForumId()};
		jdbcTemplate.update(sql, params);
	}

	@Autowired
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
}
