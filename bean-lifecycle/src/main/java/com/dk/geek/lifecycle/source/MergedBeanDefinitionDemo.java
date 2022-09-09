package com.dk.geek.lifecycle.source;

import com.dk.geek.lifecycle.domain.User;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

/**
 * @author dkay
 * @version 1.0
 */
public class MergedBeanDefinitionDemo {
    public static void main(String[] args) {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);
        reader.loadBeanDefinitions("META-INF/MergedBeanDefinitionDemo-Config.xml");

        User baseUser = beanFactory.getBean("baseUser", User.class);
        User superUser = beanFactory.getBean("superUser", User.class);

        System.out.println("superUser = " + superUser);
        System.out.println("baseUser = " + baseUser);
    }
}
