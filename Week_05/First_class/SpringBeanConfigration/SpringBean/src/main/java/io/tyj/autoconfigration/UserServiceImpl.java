package io.tyj.autoconfigration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
// 相当于配置文件中的:<bean id="userService" class="com.ssm.annotation.UserServiceImpl" />
public class UserServiceImpl implements UserService {
    // 当于配置文件中的:<property name="userDao"  ref="userDao"/>
    @Autowired
    private UserDao userDao;

    @Override
    public void save() {
        // 调用userDao中的save方法
        userDao.save();
        System.out.println("userService ---- save a msg");
    }
}
