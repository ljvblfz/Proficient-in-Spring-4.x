package com.smart.anno;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

@Lazy
@Repository
public class LogDao implements InitializingBean {

    public void afterPropertiesSet() throws Exception {
        System.out.println("LogDao....");
    }

    public void saveLog(){}
}
