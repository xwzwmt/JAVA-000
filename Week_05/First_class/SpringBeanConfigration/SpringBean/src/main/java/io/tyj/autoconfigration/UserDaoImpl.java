package io.tyj.autoconfigration;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
public class UserDaoImpl implements UserDao {
    @Override
    public void save() {
        System.out.println("UserDao ----- save a msg");
    }
}
