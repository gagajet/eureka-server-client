package com.example.serverclient.service;

import com.example.serverclient.model.User;

import java.util.List;

public interface UserService {

    User getUserById(Integer id);

    List<User> getAllUser();
    
}
