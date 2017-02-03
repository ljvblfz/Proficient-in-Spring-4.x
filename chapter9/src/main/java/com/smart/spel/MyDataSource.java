package com.smart.spel;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class MyDataSource {

    @Value("#{properties['driverClassName']}")
	private String driverClassName;
    
    @Value("${url}")
	private String url;
    
    @Value("#{properties['userName']}")
	private String userName;
    
    @Value("#{properties['password']}")
	private String password;

}
