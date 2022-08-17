package com.dk.geek.container;

import com.dk.geek.domain.User;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

/**
 * @author dkay
 * @version 1.0
 */
public class ApplicationContextContainerDemo {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(ApplicationContextContainerDemo.class);
        Map<String, User> beansOfType = ((ListableBeanFactory) applicationContext).getBeansOfType(User.class);
        System.out.println("beansOfType = " + beansOfType);
    }

    @Bean
    public User myUser() {
        User user = new User();
        user.setAge(24);
        user.setName("someone");
        return user;
    }
}
