package com.dk.geek.bean;

import com.dk.geek.domain.IPBean;
import com.dk.geek.domain.Person;
import com.dk.geek.domain.User;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author dkay
 * @version 1.0
 */
public class CreateBeanDemo {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("META-INF/spring-bean.xml");

        // 静态工厂方法
        IPBean bean = applicationContext.getBean("ipBean-by-static-method", IPBean.class);
        System.out.println("bean = " + bean);

        // bean 工厂方法
        Person person = applicationContext.getBean("person-by-instance-method", Person.class);
        System.out.println("person = " + person);

        // factoryBean方式
        User user = applicationContext.getBean("user-by-beanFactory", User.class);
        System.out.println("user = " + user);
    }
}
