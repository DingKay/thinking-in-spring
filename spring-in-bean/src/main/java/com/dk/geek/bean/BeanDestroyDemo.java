package com.dk.geek.bean;

import com.dk.geek.domain.Person;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;

/**
 * @author dkay
 * @version 1.0
 */
@Import(BeanDestroyDemo.Config.class)
public class BeanDestroyDemo {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(BeanDestroyDemo.class);
        context.refresh();

        context.close();
    }

    public static class Config {
        @Bean(destroyMethod = "customizeDestroy")
        public Person getPersonBean() {
            Person person = new Person();
            person.setAge(24);
            person.setName("kkk");
            return person;
        }
    }
}
