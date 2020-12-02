package com.tyj;

import com.tyj.entity.User;
import com.tyj.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@SpringBootTest
@RunWith(SpringRunner.class)
public class DemoTest {
    @Autowired
    private UserService userService;

    @Test
    public void addUser(){
        User user = new User();
        user.setCreateTime(new Date());
        user.setNickName("test");
        user.setPassword("123456");
        user.setUsername("zhangsan");

        userService.addUser(user);
    }

    @Test
    public void getUsers(){
        userService.getAll().forEach(System.out::println);

        userService.getAll().forEach(System.out::println);

        userService.getAll().forEach(System.out::println);

        userService.getAll().forEach(System.out::println);
    }
}
