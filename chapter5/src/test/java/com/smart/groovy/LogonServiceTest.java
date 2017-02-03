package com.smart.groovy;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericGroovyApplicationContext;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertTrue;

public class LogonServiceTest {

    @Test
    public  void getBean(){
        ApplicationContext ctx = new GenericGroovyApplicationContext("classpath:com/smart/groovy/spring-context.groovy");
        LogDao logDao = ctx.getBean(LogDao.class);

        LogonService logonService = ctx.getBean(LogonService.class);
        assertNotNull(logonService);

        MailService mailService = ctx.getBean(MailService.class);
        assertNotNull(mailService);

        UserDao userDao = ctx.getBean(UserDao.class);
        assertTrue(userDao instanceof DbUserDao);


    }
}
