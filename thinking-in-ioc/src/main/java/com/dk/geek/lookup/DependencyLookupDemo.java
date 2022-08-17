package com.dk.geek.lookup;

import com.dk.geek.annotation.Super;
import com.dk.geek.domain.SuperUser;
import com.dk.geek.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Map;

/**
 * @author dkay
 * @version 1.0
 */
public class DependencyLookupDemo {
    public static void main(String[] args) {
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("classpath:/META-INF/dependency-lookup.xml");

        lookupRealTimeById(beanFactory);

        lookupLazyById(beanFactory);

        lookupByType(beanFactory);

        lookupByCollection(beanFactory);

        lookupByAnnotation(beanFactory);
    }

    @SuppressWarnings("all")
    private static void lookupByAnnotation(BeanFactory beanFactory) {
        if (beanFactory instanceof ListableBeanFactory) {
            ListableBeanFactory factory = (ListableBeanFactory) beanFactory;
            Map<String, SuperUser> superUser = (Map) factory.getBeansWithAnnotation(Super.class);
            System.out.println("根据注解依赖查找：superUser = " + superUser);
        }
    }

    private static void lookupByCollection(BeanFactory beanFactory) {
        if (beanFactory instanceof ListableBeanFactory) {
            ListableBeanFactory factory = (ListableBeanFactory) beanFactory;
            Map<String, User> beansOfType = factory.getBeansOfType(User.class);
            System.out.println("根据类型依赖查找集合：beansOfType = " + beansOfType);
        }
    }

    private static void lookupByType(BeanFactory beanFactory) {
        User bean = beanFactory.getBean(User.class);
        System.out.println("根据类型依赖查找：bean = " + bean);
    }

    @SuppressWarnings("unchecked")
    private static void lookupLazyById(BeanFactory beanFactory) {
        Object o = beanFactory.getBean("objectFactory");
        if (o instanceof ObjectFactory) {
            User user = ((ObjectFactory<User>) o).getObject();
            System.out.println("根据id懒加载：user = " + user);
        }
    }

    private static void lookupRealTimeById(BeanFactory beanFactory) {
        Object user = beanFactory.getBean("user");
        System.out.println("根据id实时查找：user = " + user);
    }

}
