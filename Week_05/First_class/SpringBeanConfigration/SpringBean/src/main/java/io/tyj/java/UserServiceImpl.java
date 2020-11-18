package io.tyj.java;

import io.tyj.annotation.UserDao;
import io.tyj.annotation.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

public class UserServiceImpl implements UserService {

    @Override
    public void save() {
        System.out.println("userService ---- save a msg");
    }
}
