package com.dk.geek.lifecycle.source;

import com.dk.geek.lifecycle.domain.User;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.PropertiesBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.EncodedResource;

import java.nio.charset.StandardCharsets;

/**
 * @author dkay
 * @version 1.0
 */
public class BeanDefinitionPropertiesDemo {
    public static void main(String[] args) {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        PropertiesBeanDefinitionReader reader = new PropertiesBeanDefinitionReader(beanFactory);
        String location = "META-INF/user.properties";
        Resource resource = new ClassPathResource(location);
        EncodedResource encodedResource = new EncodedResource(resource, StandardCharsets.UTF_8);
        int count = reader.loadBeanDefinitions(encodedResource);
        System.out.println("加载BeanDefinition 数量 = " + count);

        User user = beanFactory.getBean("user", User.class);
        System.out.println(user);
    }
}
