package com.smart.beanprop;

import javax.sql.DataSource;


public class SysConfig {
	private int sessionTimeout;
	private int maxTabPageNum;
	
	private DataSource dataSource;

	public void initFromDB(){
		//从数据库中获取属性配置值
		this.sessionTimeout = 30; 
		this.maxTabPageNum = 10;
	}

	public int getSessionTimeout() {
		return sessionTimeout;
	}

	public int getMaxTabPageNum() {
		return maxTabPageNum;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	
}
