package com.example.serverclient.service.impl;

import com.example.serverclient.mapper.UserMapper;
import com.example.serverclient.model.User;
import com.example.serverclient.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author:王泽龙
 * @Description:
 * @Date: 18-8-4 上午9:41
 */
@Service
public class UserServiceImpl implements UserService{
    @Autowired
    UserMapper userMapper;

    @Override
    public User getUserById(Integer id) {
        return userMapper.selectById(id);
    }

    @Override
    public List<User> getAllUser() {
        return userMapper.selectAllUser();
    }


}