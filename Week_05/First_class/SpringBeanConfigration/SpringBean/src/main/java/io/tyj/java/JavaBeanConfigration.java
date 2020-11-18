package io.tyj.java;

import io.tyj.autoconfigration.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class JavaBeanConfigration {
    @Bean("userService")
    public UserServiceImpl getUserServiceImpl() {
        return new UserServiceImpl();
    }
}
