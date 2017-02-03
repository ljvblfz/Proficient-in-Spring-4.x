package com.smart.cache.mycache;

import com.smart.cache.domain.User;

public class UserService {
    private CacheManager<User> cacheManager;

    public UserService() {
        cacheManager = new CacheManager<User>();// 构造一个缓存管理器
    }

    public User getUserById(String userId) {
        User result = cacheManager.getValue(userId);// 首先查询缓存
        if(result!=null) {
            System.out.println("从缓存中查询..."+userId);
            return result;// 如果在缓存中，则直接返回缓存的结果
        }
        result = getFromDB(userId);// 否则到数据库中查询
        if(result!=null) {// 将数据库查询的结果更新到缓存中
            cacheManager.addOrUpdateCache(userId, result);
        }
        return result;
    }

    public void reload() {
        cacheManager.evictCache();
    }

    private User getFromDB(String userId) {
        System.out.println("从数据库中查询..."+userId);
        return new User(userId);
    }

}
