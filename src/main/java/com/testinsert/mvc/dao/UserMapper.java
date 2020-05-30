package com.testinsert.mvc.dao;

import com.testinsert.mvc.entity.User;
import org.apache.ibatis.annotations.Mapper;


public interface UserMapper {
    User selectUserByName(String name);

    int insert(User registerUser);
}
