package com.tyj.service;

import com.tyj.annotation.Database;
import com.tyj.entity.User;
import com.tyj.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    @Database(readOnly = false)
    public void addUser(User user) {
        userMapper.insert(user);
    }

    @Database()
    public List<User> getAll() {
        return userMapper.selectList(null);
    }
}
