package com.smart.cache.cachegroup;

import com.smart.cache.domain.User;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.concurrent.ConcurrentHashMap;

public class Main {
    public static void main(String... args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserService userServcie = (UserService) context.getBean("cacheGroupUserServcie");

        Member member = new Member("1", "w1");
        Visitor visitor = new Visitor("2", "w2");

        User userFethch1 = userServcie.getUser(member);
        System.out.println(userFethch1);

        User userFethch2 = userServcie.getUser(visitor);
        System.out.println(userFethch2);

        CacheManager cacheManager = context.getBean(CacheManager.class);
        Cache visitors = cacheManager.getCache("visitors");
        System.out.println("visitors cache storage: " + ((ConcurrentHashMap)visitors.getNativeCache()).values());
        Cache members = cacheManager.getCache("members");
        System.out.println("members cache storage: " + ((ConcurrentHashMap)members.getNativeCache()).values());
    }
}
