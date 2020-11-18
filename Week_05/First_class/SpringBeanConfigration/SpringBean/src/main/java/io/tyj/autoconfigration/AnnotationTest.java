package io.tyj.autoconfigration;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationTest {
    public static void main(String[] args) {
        // 加载配置文件
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");

        // 获取UserController实例
        UserController2 userController = (UserController2) applicationContext.getBean("userController2");

        // 调用UserController 的save方法
        userController.save();
    }
}
