package com.smart.service;
import org.springframework.transaction.annotation.Transactional;
import com.smart.domain.User;

@Transactional
public interface UserService {
    boolean hasMatchUser(String userName, String password);
    User findUserByUserName(String userName);
    void loginSuccess(User user);
    void registerUser(User user);
}
