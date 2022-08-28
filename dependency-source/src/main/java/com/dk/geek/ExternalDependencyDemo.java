package com.dk.geek;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @author dkay
 * @version 1.0
 */
@Configuration
@PropertySource("user.properties")
public class ExternalDependencyDemo {
    @Value("${user.name}")
    private String name;

    @Value("${user.age}")
    private Integer age;

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(ExternalDependencyDemo.class);

        ExternalDependencyDemo bean = context.getBean(ExternalDependencyDemo.class);
        System.out.println("bean.name = " + bean.name);
        System.out.println("bean.age = " + bean.age);
    }
}
