package com.smart.dao;

import org.springframework.stereotype.Repository;

import com.smart.domain.LoginLog;
@Repository
public interface LoginLogDao {
   void insertLoginLog(LoginLog loginLog);
}