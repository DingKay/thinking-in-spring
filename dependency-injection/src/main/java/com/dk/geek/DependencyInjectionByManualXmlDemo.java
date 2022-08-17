package com.dk.geek;

import com.dk.geek.domain.Person;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author dkay
 * @version 1.0
 */
public class DependencyInjectionByManualXmlDemo {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:/META-INF/dependency" +
                "-injection-manual.xml");
        ObjectProvider<Person> beanProvider = context.getBeanProvider(Person.class);
        beanProvider.stream().forEach(System.out::println);

    }
}
