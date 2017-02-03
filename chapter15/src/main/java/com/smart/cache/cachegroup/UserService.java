package com.smart.cache.cachegroup;

import com.smart.cache.domain.User;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service(value = "cacheGroupUserServcie")
public class UserService {
    private Map<Integer, User> ppl = new HashMap<Integer, User>();
    {
        ppl.put(1, new Member("1", "w1"));
        ppl.put(2, new Visitor("2", "w2"));
    }

    @Caching(cacheable = {
            @Cacheable(value = "members", condition = "#obj instanceof T(com.smart.cache.cachegroup.Member)"),
            @Cacheable(value = "visitors", condition = "#obj instanceof T(com.smart.cache.cachegroup.Visitor)")
    })
    public User getUser(User obj) {
        return ppl.get(Integer.valueOf(obj.getUserId()));
    }
}
