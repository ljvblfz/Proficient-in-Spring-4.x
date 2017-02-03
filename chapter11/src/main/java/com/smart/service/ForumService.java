package com.smart.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
@Service
public class ForumService {
    private UserService userService;
    @Transactional(propagation=Propagation.NEVER)
    public void addTopic(){
    	//add Topic
		userService.addCredits();
    }
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
}
