package io.tyj.autoconfigration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

//相当于配置文件中的:<bean id="userController" class="com.ssm.annotation.UserController" />
@Controller("userController2")
public class UserController2 {
    //当于配置文件中的:<property name="userService"  ref="userService"/>
    @Autowired
    private UserService userService;

    public void save() {
        userService.save();
        System.out.println("userController ---- save a msg");
    }
}
