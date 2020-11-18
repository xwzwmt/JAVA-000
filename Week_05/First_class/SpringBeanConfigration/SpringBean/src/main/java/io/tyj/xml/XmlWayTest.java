package io.tyj.xml;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class XmlWayTest {
    public static void main(String[] args) {
        // 加载配置文件
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");

        // 1. 构造器方式进行装配
        user u1 = (user) applicationContext.getBean("user01");
        System.out.println(u1);

        // 2. 通过设置属性值得方式装配
        user u2 = (user) applicationContext.getBean("user02");
        System.out.println(u2);
    }
}
