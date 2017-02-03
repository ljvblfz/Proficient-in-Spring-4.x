package com.smart.dao;

import org.springframework.stereotype.Repository;

import com.smart.domain.User;

@Repository
public interface UserDao {
   int getMatchCount(String userName, String password);
   User findUserByUserName(String userName);
   void updateLoginInfo(User user);
   void save(User user);
   void clean();
}
