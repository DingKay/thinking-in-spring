package com.dk.geek.bean.web;

import com.dk.geek.bean.domain.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * @author dkay
 * @version 1.0
 */
@Configuration
@EnableWebMvc
public class MvcConfigure {

    @Bean
    @RequestScope
    public User user() {
        User user = new User();
        user.setAge(25);
        user.setName("丁凯-dk");
        user.setTimestamp(System.currentTimeMillis());
        return user;
    }
}
