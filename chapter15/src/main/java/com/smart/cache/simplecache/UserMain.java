package com.smart.cache.simplecache;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserMain {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext(
                "applicationContext.xml");// 加载 spring 配置文件
        UserService userService = (UserService) context.getBean("userServiceBean");
        // 第一次查询，应该走数据库
        System.out.print("第一次查询...");
        userService.getUserById("用户");
        // 第二次查询，应该不查数据库，直接返回缓存的值
        System.out.print("第二次查询...");
        userService.getUserById("用户");
    }
}
