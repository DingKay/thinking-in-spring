package com.dk.geek.bean;

import com.dk.geek.domain.IPBean;
import com.dk.geek.domain.Person;
import com.dk.geek.domain.User;
import com.dk.geek.factory.PersonBeanFactory;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Iterator;
import java.util.ServiceLoader;

/**
 * @author dkay
 * @version 1.0
 */
public class SpecialCreateBeanDemo {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext app = new ClassPathXmlApplicationContext("META-INF/special-spring-bean.xml");
        // jdk 自身简单的服务加载案例
        createBeanByServiceLoaderDemo();

        // spring整合serviceLoader
        ServiceLoader<?> serviceLoaderFactoryBean = app.getBean("serviceLoaderFactoryBean", ServiceLoader.class);
        displayBeanOfServiceLoader(serviceLoaderFactoryBean.iterator());

        // autowire
        AutowireCapableBeanFactory beanFactory = app.getBeanFactory();
        User user = beanFactory.createBean(User.class);
        System.out.println("user = " + user);
    }

    public static void createBeanByServiceLoaderDemo() {
        ServiceLoader<PersonBeanFactory> loader = ServiceLoader.load(PersonBeanFactory.class, SpecialCreateBeanDemo.class.getClassLoader());
        displayBeanOfServiceLoader(loader.iterator());
    }

    public static void displayBeanOfServiceLoader(Iterator<?> iterator) {
        while (iterator.hasNext()) {
            Object next = iterator.next();
            if (next instanceof PersonBeanFactory) {
                System.out.println("person = " + ((PersonBeanFactory) next).getPerson());
            }
            if (next instanceof Person) {
                ((Person) next).setAddress("nanjing");
                ((Person) next).setAge(55);
                ((Person) next).setName("kay-haha");
                System.out.println("next = " + next);
            }
            if (next instanceof IPBean) {
                System.out.println("next = " + IPBean.getIPBean());
            }
        }
    }
}
