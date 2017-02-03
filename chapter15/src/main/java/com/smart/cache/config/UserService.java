package com.smart.cache.config;

import com.smart.cache.domain.User;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;

@CacheConfig(cacheNames = "users",keyGenerator="MyKeyGenerator ")
public class UserService {
        @Cacheable
        public User findA(User user) {
            return null;
        }

        @Cacheable
        public User findB(User user) {
            return null;
        }
}
