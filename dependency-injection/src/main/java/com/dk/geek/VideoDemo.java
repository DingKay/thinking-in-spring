package com.dk.geek;

import com.dk.geek.annotation.CustomerAnnotation;
import com.dk.geek.annotation.CustomerAnnotationExpandAutowired;
import com.dk.geek.config.DependencyInjectionByCustomerAnnotationConfigure;
import com.dk.geek.domain.CommonUser;
import com.dk.geek.domain.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

/**
 * @author dkay
 * @version 1.0
 */
public class VideoDemo {
    @Autowired
    private Person person;

    @CustomerAnnotation
    private Person customPerson;

    @CustomerAnnotationExpandAutowired
    private CommonUser commonUser;

    @Bean
    public AutowiredAnnotationBeanPostProcessor beanPostProcessor() {
        AutowiredAnnotationBeanPostProcessor postProcessor = new AutowiredAnnotationBeanPostProcessor();
        postProcessor.setAutowiredAnnotationType(CustomerAnnotation.class);
        return postProcessor;
    }

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
//        context.register(VideoDemoConfigure.class);
        context.register(VideoDemo.class);
        context.register(DependencyInjectionByCustomerAnnotationConfigure.class);
        context.refresh();

        VideoDemo bean = context.getBean(VideoDemo.class);
        System.out.println("bean = commonUser: " + bean.commonUser);
        System.out.println("bean = person: " + bean.person);
        System.out.println("bean = customPerson: " + bean.customPerson);
    }
}
