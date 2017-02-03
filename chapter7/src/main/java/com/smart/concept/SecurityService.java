package com.smart.concept;

public interface SecurityService {
    boolean checkAccess(User user, String service);
}
