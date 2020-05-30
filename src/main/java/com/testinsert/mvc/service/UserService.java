package com.testinsert.mvc.service;

import com.testinsert.mvc.entity.User;

public interface UserService {
    User selectByName(String username);


    String register(String loginName, String password);
}
