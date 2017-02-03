package com.smart.dynamic;


import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertNull;

public class CustomSchemaTest {
    public ApplicationContext applicationContext = null;

    private static String[] CONFIG_FILES = { "com/smart/dynamic/custom.xml" };

    @BeforeClass
    public void setUp() throws Exception {
        applicationContext = new ClassPathXmlApplicationContext(CONFIG_FILES);

    }

    @Test
    public void registerBean(){
        Object userService = applicationContext.getBean("userService");
        assertNotNull(userService);

    }

}
