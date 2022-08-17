package com.dk.geek.bean;

import com.dk.geek.domain.IPBean;
import com.dk.geek.domain.Person;
import com.dk.geek.domain.User;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author dkay
 * @version 1.0
 */
public class BeanDefinitionDemo {
    public static void main(String[] args) {
        BeanDefinitionBuilder builder = BeanDefinitionBuilder.genericBeanDefinition(User.class);
        AbstractBeanDefinition beanDefinition = builder.addPropertyValue("age", 25)
                .addPropertyValue("name", "dk")
                .getBeanDefinition();
        System.out.println("beanDefinition = " + beanDefinition);

        System.out.println("ClassPathXmlApplicationContext... start");
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:/META-INF/spring-bean" +
                ".xml");

        for (String beanDefinitionName : context.getBeanDefinitionNames()) {
            System.out.println("beanDefinitionName = " + beanDefinitionName);
        }
        System.out.println("ClassPathXmlApplicationContext... end");

        System.out.println("AnnotationConfigApplicationContext... start");
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(Person.class,
                IPBean.class);
        for (String beanDefinitionName : applicationContext.getBeanDefinitionNames()) {
            System.out.println("beanDefinitionName = " + beanDefinitionName);
        }
        System.out.println("AnnotationConfigApplicationContext... end");
    }
}
