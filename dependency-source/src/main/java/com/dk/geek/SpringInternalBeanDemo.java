package com.dk.geek;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author dkay
 * @version 1.0
 */
public class SpringInternalBeanDemo {
    @Autowired
    private AutowiredAnnotationBeanPostProcessor processor;

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(SpringInternalBeanDemo.class);

        SpringInternalBeanDemo bean = context.getBean(SpringInternalBeanDemo.class);
        System.out.println("processor => " + bean.processor);
    }
}
