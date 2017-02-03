package com.smart.dao;

import com.smart.domain.Forum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.MappingSqlQuery;
import org.springframework.jdbc.object.SqlFunction;
import org.springframework.jdbc.object.SqlUpdate;
import org.springframework.jdbc.object.StoredProcedure;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.HashMap;
import java.util.Map;

@Repository
public class ForumOODao {
    private DataSource dataSource;

	private ForumQuery forumQuery ;//①声明ForumQuery变量

	private ForumInsert forumInsert;

	private GetTopicNum getTopicNum;

	private SqlFunction<Integer> forumNumCount ;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

    @PostConstruct 
    public void init(){
    	this.forumQuery = new ForumQuery(this.dataSource); //②初始化ForumQuery对象
    	this.forumInsert = new ForumInsert(this.dataSource);
    	this.getTopicNum = new GetTopicNum(this.dataSource);
    	this.forumNumCount = new SqlFunction<Integer>(dataSource, "SELECT COUNT(*) FROM t_forum");
    	this.forumNumCount.compile();
    }

	public Forum getForum(int forumId){ 
		return forumQuery.findObject(forumId); //③执行查询并返回结果
	}

    //④定义MappingSqlQuery
	private class ForumQuery extends MappingSqlQuery<Forum> {
		public ForumQuery(DataSource ds) {//⑤定义查询语句并预编译
			super(ds, "SELECT forum_id,forum_name, forum_desc FROM t_forum WHERE forum_id=?");
			declareParameter(new SqlParameter(Types.INTEGER));
			compile();//⑤-1不能忘记这行编译语句，否则会发生错误
		}
         
		public Forum mapRow(ResultSet rs, int rownum) throws SQLException {
			Forum forum = new Forum();
			forum.setForumId(rs.getInt("forum_id"));
			forum.setForumName(rs.getString("forum_name"));
			forum.setForumDesc(rs.getString("forum_desc"));
			return forum;
		}
	}
	
     //①新增Forum对象
  	public void addForum(Forum forum){ 
		forumInsert.insert(forum);
	}
     //②扩展SqlUpdate定义子类
	private class ForumInsert extends SqlUpdate {
		public ForumInsert(DataSource ds) {//③定义SQL语句并预编译
			super(ds, "INSERT INTO t_forum(forum_name,forum_desc) VALUES(:forumName,:forumDesc)");
			declareParameter(new SqlParameter("forumDesc",Types.VARCHAR));
			declareParameter(new SqlParameter("forumName",Types.VARCHAR));
			compile();
		}
		public void insert(Forum forum) {//④绑定参数
			Map<String,String> params = new HashMap<String,String>();
			params.put("forumName", forum.getForumName());
			params.put("forumDesc", forum.getForumDesc());
			super.updateByNamedParam(params);
		}
	}
	

	    public int getTopicNum(int userId){
	        return getTopicNum.getTopicNum(userId);
	    }
	    //①扩展StoredProcedure
		private class GetTopicNum extends StoredProcedure { 
			private static final String SQL = "P_GET_TOPIC_NUM";//②定义存储过程名
			public GetTopicNum(DataSource ds) {
				setDataSource(ds);
				setSql(SQL);
	            //③声明入参
				declareParameter(new SqlParameter("userId",Types.INTEGER)); 
	            //④声明出参
				declareParameter(new SqlOutParameter("outNum",Types. INTEGER)); 
				compile();
			}
			public int getTopicNum(int userId) {//⑤执行存储过程并返回结果
				Map<String,Integer> map = new HashMap<String,Integer>();
				map.put("userId", userId);
				Map<String,Object> outMap = execute(map);
				return (Integer)outMap.get("outNum");
			}
		}
		
		public int getForumNum() {
		    return forumNumCount.run();
		}
}
