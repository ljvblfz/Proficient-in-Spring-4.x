package com.smart.cache.simplecache;

import com.smart.cache.domain.User;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service(value = "userServiceBean")
public class UserService {
    @Cacheable(cacheNames = "users")// 使用了一个缓存名叫 users
    public User getUserById(String userId) {
        //方法内部实现不考虑缓存逻辑，直接实现业务
        System.out.println("执行用户业务查询方法查找." + userId);
        return getFromDB(userId);
    }

    private User getFromDB(String userId) {
        System.out.println("从数据库中查询..." + userId);
        return new User(userId);
    }

}
