package com.smart.domain;

import java.util.Date;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.thoughtworks.xstream.annotations.XStreamOmitField;


@XStreamAlias("message")
public class User {
    
	@XStreamAlias("id")
	@XStreamAsAttribute
	private String userId;
	
	@XStreamAsAttribute
	@Pattern(regexp="w{4,30}")
	private String userName;
	
	@XStreamAsAttribute
	@Pattern(regexp="S{6,30}")
	private String password;
	
	@XStreamAsAttribute
	@Length(min=2,max=100)
	private String realName;
	
	@XStreamAsAttribute
	@Past
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date birthday;
	
	@XStreamAsAttribute
    @DecimalMin(value="1000.00")
    @DecimalMax(value="100000.00")
	@NumberFormat(pattern="#,###.##")
	private long salary;
	
	@XStreamOmitField
	private Dept dept;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
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

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public long getSalary() {
		return salary;
	}

	public void setSalary(long salary) {
		this.salary = salary;
	}

	public Dept getDept() {
		return dept;
	}

	public void setDept(Dept dept) {
		this.dept = dept;
	}
}
