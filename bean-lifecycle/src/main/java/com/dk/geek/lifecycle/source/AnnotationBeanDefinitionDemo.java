package com.dk.geek.lifecycle.source;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.annotation.AnnotatedBeanDefinitionReader;

/**
 * @author dkay
 * @version 1.0
 */
public class AnnotationBeanDefinitionDemo {
    public static void main(String[] args) {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        AnnotatedBeanDefinitionReader reader = new AnnotatedBeanDefinitionReader(beanFactory);

        int definitionCountBefore = beanFactory.getBeanDefinitionCount();
        reader.register(AnnotationBeanDefinitionDemo.class);
        int definitionCountAfter = beanFactory.getBeanDefinitionCount();
        System.out.println("注册BeanDefinition数量为:" + (definitionCountAfter - definitionCountBefore));

        AnnotationBeanDefinitionDemo bean = beanFactory.getBean("annotationBeanDefinitionDemo",
                AnnotationBeanDefinitionDemo.class);
        System.out.println("bean = " + bean);
    }
}
