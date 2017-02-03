package com.smart.oxm.xstream.annotations;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.thoughtworks.xstream.annotations.XStreamConverter;
import com.thoughtworks.xstream.annotations.XStreamImplicit;
import com.thoughtworks.xstream.annotations.XStreamOmitField;

@XStreamAlias("user")
public class User {
	@XStreamAsAttribute
	@XStreamAlias("id")
	private int userId;
	
	@XStreamAlias("username")
	private String userName;
	
	@XStreamAlias("password")
	private String password;
	
	@XStreamAlias("credits")
	private int credits;
	
	@XStreamOmitField
	@XStreamAlias("lastIp")
	private String lastIp;

	@XStreamConverter(DateConverter.class)
	private Date lastVisit;

	@XStreamImplicit
	private List logs;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getCredits() {
		return credits;
	}

	public void setCredits(int credits) {
		this.credits = credits;
	}

	public String getLastIp() {
		return lastIp;
	}

	public void setLastIp(String lastIp) {
		this.lastIp = lastIp;
	}

	public Date getLastVisit() {
		return lastVisit;
	}

	public void setLastVisit(Date lastVisit) {
		this.lastVisit = lastVisit;
	}

	public void addLoginLog(LoginLog log) {
		if (this.logs == null) {
			logs = new ArrayList<LoginLog>();
		}
		logs.add(log);
	}

	public List<LoginLog> getLogs() {
		return logs;
	}

}
