package com.smart;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class User implements Serializable{
	private int userId;
	private String userName;
	private String password;
	private int credits;
	private String lastIp;
	private Date lastVisit;
	private PlaceOfBirth placeOfBirth;
	private List interestsList;
	private String interestsArray[];
	private Map interestsMap;

	public User() {

	}

	public User(String userName) {
		this.userName = userName;
	}

	public String getLastIp() {
		return lastIp;
	}
	public static String getLastIp2() {
		return "ddddddd";
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

	public PlaceOfBirth getPlaceOfBirth() {
		return placeOfBirth;
	}

	public void setPlaceOfBirth(PlaceOfBirth placeOfBirth) {
		this.placeOfBirth = placeOfBirth;
	}

	public boolean isVipMember(String userName){
         return "tom".equals(userName) || "jony".equals(userName);
	}

	public boolean validatePassword(String password){
         return "123456".equals(password);
	}

	private boolean validatePassword2(String password){
		return "123456".equals(password);
	}

	public static boolean validatePassword3(String password){
		return "123456".equals(password);
	}

	public  void addInterests(String... interests){
		if(interestsList==null){
			   interestsList = new ArrayList();
		}
		for(String interest:interests) {
			interestsList.add(interest);
		}
	}


	public List getInterestsList() {
		return interestsList;
	}

	public void setInterestsList(List interestsList) {
		this.interestsList = interestsList;
	}

	public Map getInterestsMap() {
		return interestsMap;
	}

	public void setInterestsMap(Map interestsMap) {
		this.interestsMap = interestsMap;
	}

	public String[] getInterestsArray() {
		return interestsArray;
	}

	public void setInterestsArray(String[] interestsArray) {
		this.interestsArray = interestsArray;
	}


}
