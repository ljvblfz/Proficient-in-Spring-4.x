package com.smart.groovy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

public class LogonController {
	private LogonService logonService;

    public void setLogonService(LogonService logonService) {
        this.logonService = logonService;
    }
}
