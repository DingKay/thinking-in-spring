package com.dk.geek.bean;

import com.dk.geek.domain.Person;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

/**
 * @author dkay
 * @version 1.0
 */
public class SpringBeanGarbageCollectionDemo {
    public static void main(String[] args) throws InterruptedException {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(Config.class);
        context.refresh();

//        Person bean = context.getBean(Person.class);
//        System.out.println("bean = " + bean);

        context.close();

//        bean = null;
        System.gc();
        Thread.sleep(5000);
    }

    public static class Config {
        @Bean
        public Person getOnePerson() {
            Person person = new Person();
            person.setName("kakaka");
            person.setAge(22);
            return person;
        }
    }
}
