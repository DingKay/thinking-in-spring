package com.dk.geek.injection;

import com.dk.geek.repository.UserRepository;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.env.Environment;

/**
 * @author dkay
 * @version 1.0
 */
public class DependencyInjectionDemo {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext beanFactory = new ClassPathXmlApplicationContext("classpath:/META-INF/dependency-injection.xml");
        UserRepository byUtil = beanFactory.getBean("userRepositoryByUtil", UserRepository.class);
        System.out.println("userRepository byUtil = " + byUtil);
        System.out.println("userRepository byUtil.getUsers = " + byUtil.getUsers());

        UserRepository byAutowire = beanFactory.getBean("userRepositoryByAutowire", UserRepository.class);
        System.out.println("userRepository byAutowire = " + byAutowire);
        System.out.println("userRepository byAutowire.getUsers = " + byAutowire.getUsers());

        BeanFactory autowireBeanFactory = byAutowire.getBeanFactory();
        System.out.println("userRepository byAutowire.getBeanFactory = " + autowireBeanFactory);

        ApplicationContext applicationContext = byAutowire.getObjectFactory().getObject();
        System.out.println("userRepository byAutowire.getObjectFactory = " + applicationContext);

        System.out.println("==========");

        System.out.println("autowireBeanFactory == BeanFactory => " + (beanFactory == autowireBeanFactory));
        System.out.println("autowireBeanFactory == BeanFactory.getBeanFactory => " + (beanFactory.getBeanFactory() == autowireBeanFactory));
        System.out.println("applicationContext == BeanFactory => " + (beanFactory == applicationContext));

        Environment environment = beanFactory.getBean(Environment.class);
        System.out.println("environment = " + environment);

    }
}
