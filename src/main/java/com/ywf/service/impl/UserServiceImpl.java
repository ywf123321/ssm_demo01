package com.ywf.service.impl;

import com.ywf.mapper.UserMapper;
import com.ywf.pojo.User;
import com.ywf.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public User login(String name, String pwd) {
        return userMapper.getUser(name,pwd);
    }
}
