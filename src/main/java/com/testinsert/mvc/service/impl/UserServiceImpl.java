package com.testinsert.mvc.service.impl;

import com.testinsert.mvc.dao.UserMapper;
import com.testinsert.mvc.entity.User;
import com.testinsert.mvc.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public User selectByName(String name){
        return userMapper.selectUserByName(name);
    }

    @Override
    public String register(String loginName,String password){
        //该loginName已经注册过了
        if(userMapper.selectUserByName(loginName)!=null){
            return "false";
        }
        User registerUser =new User();
        registerUser.setLoginName(loginName);
        registerUser.setPassword(password);

        if( userMapper.insert(registerUser)>0){
            return "true";
        }else {
            return "false";
        }
    }


}
