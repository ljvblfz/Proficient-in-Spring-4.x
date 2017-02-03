package com.smart.cache.cacheevict;

import com.smart.cache.domain.User;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service(value = "cacheEvictUserServcie")
public class UserService {

    private Map<Integer, User> users = new HashMap<Integer, User>();

    {
        users.put(1, new User("1", "cxh"));
        users.put(2, new User("2", "lkx"));
        users.put(3, new User("3", "wjg"));
    }

    @Cacheable(value = "users")
    public User getUser(int id) {
        return users.get(id);
    }

    @CacheEvict("users")
    public void removeUser(int id) {
        users.remove(id);
    }



}
