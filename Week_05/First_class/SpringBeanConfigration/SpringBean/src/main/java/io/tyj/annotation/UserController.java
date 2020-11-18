package io.tyj.annotation;

import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

//相当于配置文件中的:<bean id="userController" class="com.ssm.annotation.UserController" />
@Controller("userController")

public class UserController {
    //当于配置文件中的:<property name="userService"  ref="userService"/>
    @Resource(name = "userService")
    private UserService userService;

    public void save() {
        userService.save();
        System.out.println("userController ---- save a msg");
    }
}
