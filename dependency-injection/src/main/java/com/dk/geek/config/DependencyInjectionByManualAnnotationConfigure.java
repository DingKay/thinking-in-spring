package com.dk.geek.config;

import com.dk.geek.domain.CommonUser;
import com.dk.geek.domain.Person;
import com.dk.geek.util.PersonUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author dkay
 * @version 1.0
 */
@Slf4j
@Configuration
public class DependencyInjectionByManualAnnotationConfigure {
    @Bean(initMethod = "initPerson")
    public Person person1() {
        log.debug("register person1 to container");
        return PersonUtil.createPerson("dk-person1", 23, "good", "love");
    }

    @Bean
    public CommonUser commonUser1() {
        log.debug("register commonUser1 to container");
        CommonUser commonUser = new CommonUser();
        commonUser.setName("haha");
        return commonUser;
    }
}
