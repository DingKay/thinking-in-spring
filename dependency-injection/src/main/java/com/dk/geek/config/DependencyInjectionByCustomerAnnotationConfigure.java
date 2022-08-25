package com.dk.geek.config;

import com.dk.geek.domain.CommonUser;
import com.dk.geek.domain.Person;
import org.springframework.context.annotation.Bean;

/**
 * @author dkay
 * @version 1.0
 */
public class DependencyInjectionByCustomerAnnotationConfigure {
    @Bean
    public CommonUser commonUser() {
        CommonUser commonUser = new CommonUser();
        commonUser.setName("dk");
        return commonUser;
    }

    @Bean
    public Person person() {
        Person person = new Person();
        person.setLabel(new String[] {"engineer", "worker"});
        person.setAge(25);
        person.setName("kay-zi");
        return person;
    }
}
