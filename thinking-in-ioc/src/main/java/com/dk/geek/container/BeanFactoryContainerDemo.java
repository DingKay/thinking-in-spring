package com.dk.geek.container;

import com.dk.geek.domain.User;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author dkay
 * @version 1.0
 */
public class BeanFactoryContainerDemo {
    public static void main(String[] args) {
        String location = "classpath:/META-INF/dependency-lookup.xml";
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);
        int definitions = reader.loadBeanDefinitions(location);
        System.out.println("definitions = " + definitions);

        User user = beanFactory.getBean("user", User.class);
        System.out.println("user = " + user);
    }
}
