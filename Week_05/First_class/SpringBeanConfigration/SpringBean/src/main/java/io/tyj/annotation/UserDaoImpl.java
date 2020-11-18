package io.tyj.annotation;

import org.springframework.stereotype.Repository;

@Repository("userDao")
//@Repository("userDao")相当于配置文件中的:<bean id="userDao" class="com.ssm.annotation.UserDaoImpl" />
public class UserDaoImpl implements UserDao {
    @Override
    public void save() {
        System.out.println("UserDao ----- save a msg");
    }
}
