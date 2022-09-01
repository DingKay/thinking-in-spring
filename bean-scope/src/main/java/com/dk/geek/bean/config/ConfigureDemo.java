package com.dk.geek.bean.config;

import com.dk.geek.bean.annotation.ThreadScope;
import com.dk.geek.bean.domain.User;
import org.springframework.context.annotation.Bean;

/**
 * @author dkay
 * @version 1.0
 */
public class ConfigureDemo {
    @Bean
    @ThreadScope
    public User user() {
        User user = new User();
        user.setTimestamp(System.nanoTime());
        user.setName("dk");
        user.setAge(25);
        return user;
    }
}
