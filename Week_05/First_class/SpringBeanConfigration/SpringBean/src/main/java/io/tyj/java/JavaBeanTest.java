package io.tyj.java;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.jws.soap.SOAPBinding;

public class JavaBeanTest {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");

        UserServiceImpl userService = (UserServiceImpl) applicationContext.getBean("userService");

        userService.save();
    }
}
