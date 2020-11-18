package io.tyj.annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationTest {
    public static void main(String[] args) {
        // 加载配置文件
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");

        // 获取UserController实例
        UserController userController = (UserController) applicationContext.getBean("userController");

        // 调用UserController 的save方法
        userController.save();
    }
}
