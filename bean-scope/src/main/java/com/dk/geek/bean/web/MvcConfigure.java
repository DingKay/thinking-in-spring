package com.dk.geek.bean.web;

import com.dk.geek.bean.domain.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.annotation.ApplicationScope;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.context.annotation.SessionScope;
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
    public User requestUser() {
        User user = new User();
        user.setAge(25);
        user.setName("丁凯-dk-request");
        user.setTimestamp(System.currentTimeMillis());
        return user;
    }

    @Bean
    @SessionScope
    public User sessionUser() {
        User user = new User();
        user.setAge(25);
        user.setName("丁凯-dk-session");
        user.setTimestamp(System.currentTimeMillis());
        return user;
    }

    @Bean
    @ApplicationScope
    public User servletContextUser() {
        User user = new User();
        user.setAge(25);
        user.setName("丁凯-dk-servletContext");
        user.setTimestamp(System.currentTimeMillis());
        return user;
    }
}
