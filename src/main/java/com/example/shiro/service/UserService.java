package com.example.shiro.service;

import com.example.shiro.model.User;

public interface UserService {
    public User findByName(String name);
    public User findById(Integer id);
}
